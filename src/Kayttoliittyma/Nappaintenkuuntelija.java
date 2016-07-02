/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Pelilogiikka.Peli;
import Peliolennot.Suunta;
import Peliolennot.pahikset.Pahis;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author eamiller
 */
public class Nappaintenkuuntelija implements KeyListener {

    private Peli p;

    public Nappaintenkuuntelija(Peli p) {
        this.p = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'd'){
            System.out.println(p.getHoami().x);
            System.out.println(p.getHoami().y);
            System.out.println("");
            p.getPahikset().get(0).liikuOikealle();
        }
        if(e.getKeyChar() == 'x'){
            p.hoamiHeittaaPossun();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p.getHoami().getSuunnat().put(1, Suunta.NORTH);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            p.getHoami().getSuunnat().put(2, Suunta.EAST);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p.getHoami().getSuunnat().put(3, Suunta.SOUTH);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            p.getHoami().getSuunnat().put(4, Suunta.WEST);
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p.getHoami().getSuunnat().remove(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            p.getHoami().getSuunnat().remove(2);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p.getHoami().getSuunnat().remove(3);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            p.getHoami().getSuunnat().remove(4);
        }
    }

}
