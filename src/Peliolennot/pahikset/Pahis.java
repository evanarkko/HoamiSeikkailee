/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peliolennot.pahikset;

import Peliolennot.Peliolio;

/**
 *
 * @author eamiller
 */
public abstract class Pahis extends Peliolio {
    public int health;
    public int koordinaattiX;
    public int koordinaattiY;
    public int liikkumisKynnys;

    public Pahis(int x, int y) {
        super(x, y);
    }

    public void setKoordinaatit(int koordinaattiX, int koordinaattiY) {
        this.koordinaattiX = koordinaattiX - 15;
        this.koordinaattiY = koordinaattiY - 15;
    }
    
    public void takeDamage(int damage){
        this.health-=damage;
    }
    
    public boolean isSusi(){
        return false;
    }

    public void liiku(int kohdeX, int kohdeY) {
        double xy = Math.random();
        if (xy < 0.5) {
            if (koordinaattiX < kohdeX) {
                liikuOikealle();
            }
            if (koordinaattiX > kohdeX) {
                liikuVasemmalle();
            }
        } else {
            if (koordinaattiY < kohdeY) {
                liikuAlas();
            }
            if (koordinaattiY > kohdeY) {
                liikuYlos();
            }
        }
    }

    public void liikuOikealle() {
        if (x != 13) {
            x++;
        }
    }

    public void liikuVasemmalle() {
        if (x != 1) {
            x--;
        }
    }

    public void liikuYlos() {
        if (y != 1) {
            y--;
        }
    }

    public void liikuAlas() {
        if (y != 8) {
            y++;
        }
    }

    public int getLiikkumisKynnys() {
        return liikkumisKynnys;
    }

}
