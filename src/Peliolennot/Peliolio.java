/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peliolennot;

import java.awt.Graphics;

/**
 *
 * @author eamiller
 */
public abstract class Peliolio {
    public int x;
    public int y;

    public Peliolio(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
    
    public int etaisyys(Peliolio olio) { //Pythagoraan lause
        int etaisyysX = Math.abs(this.x - olio.x);
        int etaisyysY = Math.abs(this.y - olio.y);
        int etaisyys = (int) Math.sqrt(Math.pow(etaisyysX, 2) + Math.pow(etaisyysY, 2));
        return etaisyys;
    }
    public int etaisyys(int x, int y) { //Pythagoraan lause
        int etaisyysX = Math.abs(this.x - x);
        int etaisyysY = Math.abs(this.y - y);
        int etaisyys = (int) Math.sqrt(Math.pow(etaisyysX, 2) + Math.pow(etaisyysY, 2));
        return etaisyys;
    }
    
    public void luo(Graphics g){
        
    }
    
}
