/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author DANIC
 */
class Board extends JPanel implements ActionListener{
    Snake snake;
    
    public static void main(String args[]){
        Board board = new Board();
    }
    public Board(){
        setPreferredSize(new Dimension(Config.SIZE_WIN_W, Config.SIZE_WIN_H));
        setBackground(Color.LIGHT_GRAY);
        
        JFrame f=new JFrame("Snake");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(Config.SIZE_WIN_W, Config.SIZE_WIN_H);
        f.add(this);
        f.pack();
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.add(this);
        Timer timer = new Timer(1000, this);
        timer.start();
        snake = new Snake();
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(snake.getColor());
        for(Point p : snake.getBody()){
            g.fillOval(p.getPosX()*Config.SIZE_SEGMENT,p.getPosY()*Config.SIZE_SEGMENT, Config.SIZE_SEGMENT, Config.SIZE_SEGMENT);
        }
        g.setColor(Color.BLACK);
        for(int i =0; i<Config.SIZE_WIN_W; i+=Config.SIZE_SEGMENT){
            g.drawLine(i, 0, i, Config.SIZE_WIN_H);
        }
        for(int j=0;j<Config.SIZE_WIN_H;j+=Config.SIZE_SEGMENT){
            g.drawLine(0,j ,Config.SIZE_WIN_W, j);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Point> body = new ArrayList<Point>();
        body = snake.getBody();
        for(int i=body.size()-1; i>0; i--){
            int x=body.get(i-1).getPosX();
            body.get(i).setPosX(x);
            int y=body.get(i-1).getPosY();
            body.get(i).setPosY(y);
        }
        int HEAD = 0;
        int y= body.get(HEAD).getPosY();
        y+=1;
        body.get(HEAD).setPosY(y);
        repaint();
    }
}
