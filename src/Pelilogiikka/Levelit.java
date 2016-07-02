/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelilogiikka;

import Peliolennot.pahikset.Kaarme;
import Peliolennot.pahikset.Susi;

/**
 *
 * @author eamiller
 */
public class Levelit {
    private String punKaarme = "redsnake.png";
    private String vihKaarme = "greensnake.png";
    private String keltKaarme = "snake.png";

    Peli peli;

    public Levelit(Peli peli) {
        this.peli = peli;
    }

    public void makeLevel(int level) {
        switch (level) {
            case 0:
                break;
            case 1:
                peli.lisaaPahis(new Kaarme(1, 1, vihKaarme));
                System.out.println(level);
                break;
            case 2:
                peli.lisaaPahis(new Kaarme(13, 8, keltKaarme));
                System.out.println(level);
                break;
            case 3:
                System.out.println(level);
                peli.lisaaPahis(new Susi(1, 1));
                break;
            case 4:
                peli.lisaaPahis(new Kaarme(4, 3, punKaarme));
                peli.lisaaPahis(new Kaarme(10, 3, vihKaarme));
                break;
            case 5:
                peli.lisaaPahis(new Susi(1, 1));
                peli.lisaaPahis(new Susi(1, 1));
                peli.lisaaPahis(new Susi(1, 1));
                peli.lisaaPahis(new Susi(1, 1));
                System.out.println(level);
                break;
            case 6:
                peli.lisaaPahis(new Kaarme(4, 3, keltKaarme));
                peli.lisaaPahis(new Kaarme(4, 3, keltKaarme));
                peli.lisaaPahis(new Kaarme(4, 3, keltKaarme));
                peli.lisaaPahis(new Kaarme(4, 3, keltKaarme));
                System.out.println(level);
                break;
            case 7:
                peli.lisaaPahis(new Kaarme(1, 1, punKaarme));
                peli.lisaaPahis(new Kaarme(1, 8, vihKaarme));
                peli.lisaaPahis(new Kaarme(12, 1, punKaarme));
                peli.lisaaPahis(new Kaarme(12, 8, vihKaarme));
                peli.lisaaPahis(new Kaarme(4, 3, keltKaarme));
                System.out.println(level);
                break;
            case 8:
                peli.lisaaPahis(new Kaarme(4, 3, punKaarme));
                peli.lisaaPahis(new Kaarme(10, 3, vihKaarme));
                peli.lisaaPahis(new Kaarme(4, 3, punKaarme));
                System.out.println(level);
                break;
            case 9:
                peli.victory();
                System.out.println(level);
                break;

        }
    }

}
