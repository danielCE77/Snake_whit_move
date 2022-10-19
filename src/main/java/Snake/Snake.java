/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Snake;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author DANIC
 */
class Snake {
    private final Color color;
    private final ArrayList<Point> body = new ArrayList<>();
    private final int speed;
    
    public Snake(){
        body.add(new Point (6, 1));
        body.add(new Point (5, 1));
        body.add(new Point (4, 1));
        color = Color.GREEN;
        speed = 1;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Point> getBody() {
        return body;
    }

    public int getSpeed() {
        return speed;
    }

   
}
