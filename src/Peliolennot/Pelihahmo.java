/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peliolennot;

import java.util.HashMap;

/**
 *
 * @author eamiller
 */
public abstract class Pelihahmo extends Peliolio{
    public int nopeusX;
    public int nopeusY;
    public boolean lattialla;
    private int nopeus;
    
    public Pelihahmo(int x, int y) {
        super(x, y);
        this.nopeusX = 0;
        this.nopeusY = 0;
    }
    
    
    public void kiihdyta(int deltaX, int deltaY){
        this.nopeusX += deltaX;
        this.nopeusY += deltaY;
    }
    
    public void liikuta(int deltaX, int deltaY){
        this.x += deltaX;
        this.y += deltaY;
    }
    
    public void liiku(){
        this.x += nopeusX;
        this.y += nopeusY;
    }
    
}
