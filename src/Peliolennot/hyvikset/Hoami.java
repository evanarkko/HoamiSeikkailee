/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peliolennot.hyvikset;

import Peliolennot.Pelihahmo;
import Peliolennot.Suunta;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

/**
 *
 * @author eamiller
 */
public class Hoami extends Pelihahmo {

    public HashMap<Integer, Suunta> suunnat;
    private int nopeus;

    public Hoami(int x, int y) {
        super(x, y);
        this.suunnat = new HashMap<>();
        nopeus = 7;
    }

    public void heitapossu(Possu possu) {
        for (Suunta s : suunnat.values()) {
            if (s == Suunta.NORTH) {
                possu.setNopeusY(-9);
            }
            if (s == Suunta.EAST) {
                possu.setNopeusX(9);
            }
            if (s == Suunta.SOUTH) {
                possu.setNopeusY(9);
            }
            if (s == Suunta.WEST) {
                possu.setNopeusX(-9);
            }
        }
        possu.setX(this.x);
        possu.setY(this.y);
        possu.setHeitetty(true);
    }

    @Override
    public void liiku() {
        for (Suunta s : suunnat.values()) {
            if (s == Suunta.NORTH) {
                liikuta(0, nopeus * (-1));
            }
            if (s == Suunta.EAST) {
                liikuta(nopeus, 0);
            }
            if (s == Suunta.SOUTH) {
                liikuta(0, nopeus);
            }
            if (s == Suunta.WEST) {
                liikuta(nopeus * (-1), 0);
            }
        }
        super.liiku();
        if (this.x < -25) {
            this.x = 1300;
        } else if (this.x > 1300) {
            this.x = -25;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void luo(Graphics g) {
        luoSydan(g, x, y);
    }

    private void luoSydan(Graphics g, int x, int y) {
//        g.setColor(Color.MAGENTA);

        g.setColor(Color.red);
        g.fillOval(x, y, 20, 20);
        g.fillOval(x + 16, y, 20, 20);

        int[] xarray = {x, x + 36, x + 17};
        int[] yarray = {y + 13, y + 13, y + 40};
        g.fillPolygon(xarray, yarray, 3);
    }

    public HashMap<Integer, Suunta> getSuunnat() {
        return suunnat;
    }

}
