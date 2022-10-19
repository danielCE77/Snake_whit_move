/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author DANIC
 */
class Food {
    private Color color;
    private int size;
    private Point point;
    
    public  Food(Color color, int size, Point p){
        this.color = color;
        this.size = size;
        point = p ;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point p) {
        point = p;
    }
    
    public void randomNewFood(){
        double x = Math.random()*Config.SIZE_X_SEGMENTS;
        double y = Math.random()*Config.SIZE_Y_SEGMENTS;
        point.setPosX((int)x);
        point.setPosX((int)y);
    }
    
    public void draw(Graphics g){
        randomNewFood();
        g.setColor(color);
        g.fillOval(point.getPosX()*Config.SIZE_X_SEGMENTS, point.getPosY()*Config.SIZE_Y_SEGMENTS, size, size);
    }
}


