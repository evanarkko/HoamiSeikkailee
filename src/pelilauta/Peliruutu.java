/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelilauta;

import Peliolennot.Peliolio;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author eamiller
 */
public class Peliruutu extends Peliolio {
    
    public Peliruutu(int x, int y) {
        super(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    @Override
    public void luo(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(x, y, 10, 10);
    }
    
    
    
}
