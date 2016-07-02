/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelilogiikka;

import Peliolennot.hyvikset.Hoami;
import Peliolennot.hyvikset.Possu;
import Peliolennot.*;
import Peliolennot.gadgets.*;
import Peliolennot.pahikset.Pahis;
import java.util.ArrayList;
import java.util.Stack;
import pelilauta.Pelilauta;

/**
 *
 * @author eamiller
 */
public class Peli {

    private Aitaus aitaus;
    private Pelaaja pelaaja;
    private Hoami hoami;
    private Pelilauta pelilauta;
    private Stack<Possu> possut;
    private ArrayList<Possu> heitetyPossut;
    private ArrayList<Pahis> pahikset;
    private Peliolio lisaPossu;
    private boolean peliHavitty;
    private boolean peliVoitettu;
    private int kierroksia = 0;

    public Peli(Hoami hoami) {
        this.pelaaja = new Pelaaja("Evan");
        this.hoami = hoami;
        this.peliHavitty = false;
        this.peliVoitettu = false;
        this.possut = new Stack();
        this.lisaPossu = new LisaPossu(550, 400);
        this.heitetyPossut = new ArrayList<>();
        this.pelilauta = new Pelilauta();
        this.pahikset = new ArrayList<>();
        this.aitaus = new Aitaus(500, 250);
    }

    public void etene() {
        kierroksia++;
        ArrayList<Integer> kuolleidenIndeksit = new ArrayList<Integer>();
        int currentIndex = 0;
        for (Pahis p : pahikset) {
            if (hoami.etaisyys(p.koordinaattiX + 30, p.koordinaattiY + 30) < 45) {
                pelaaja.takeDamage(1);

            }
            if (kierroksia % p.getLiikkumisKynnys() == 0) {
                if (p.isSusi()) {
                    p.liiku(hoami.getX(), hoami.getY());
                } else {
                    p.liiku(500, 250);
                    if (aitaus.etaisyys(p.koordinaattiX, p.koordinaattiY) < 110) {
                        pelaaja.aitausOttaaDamagea(5);
                    }
                }
            }
            ArrayList<Integer> possujenIndeksit = new ArrayList<Integer>();
            int currentPossuIndex = 0;
            for (Possu possu : heitetyPossut) {
                if (possu.etaisyys(p.koordinaattiX + 30, p.koordinaattiY + 30) < 50) {
                    p.takeDamage(1);
                    if (!possujenIndeksit.contains(currentPossuIndex)) {
                        possujenIndeksit.add(currentPossuIndex);
                    }
                }
                currentPossuIndex++;
                if (p.health < 1) {
                    kuolleidenIndeksit.add(currentIndex);
                    if (p.isSusi()) {
                        pelaaja.lisaaPisteita(10);
                    } else {
                        pelaaja.lisaaPisteita(5);
                    }
                }
            }
            for (int i : possujenIndeksit) {
                if (i > heitetyPossut.size() - 1 || heitetyPossut.size() == 0) {
                    continue;
                }
                heitetyPossut.remove(i);
            }

            p.setKoordinaatit(pelilauta.getRuudukko()[p.x][p.y].getX(), pelilauta.getRuudukko()[p.x][p.y].getY());
            currentIndex++;
        }

        for (int i : kuolleidenIndeksit) {
            if (i > pahikset.size() - 1 || pahikset.size() == 0) {
                continue;
            }
            pahikset.remove(i);
        }
        for (Possu p : possut) {
            p.liiku();
        }
        for (Possu p : heitetyPossut) {
            p.liiku();
        }
        hoami.liiku();
        if (hoami.etaisyys(this.lisaPossu) < 20) {
            uusiLisaPossu();
        }

        if (pelaaja.isDefeated()) {
            this.peliHavitty = true;
        }
    }

    private void uusiLisaPossu() {
        lisaaPossu();
        int x = (int) (Math.random() * 390) + 385;
        int y = (int) (Math.random() * 205) + 255;
        this.lisaPossu = new LisaPossu(x, y);

    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public Pelilauta getPelilauta() {
        return pelilauta;
    }

    public void lisaaPahis(Pahis p) {
        this.pahikset.add(p);
    }

    public ArrayList<Pahis> getPahikset() {
        return pahikset;
    }

    public Hoami getHoami() {
        return hoami;
    }

    public Stack<Possu> getPossut() {
        return possut;
    }

    public Peliolio getLisaPossu() {
        return lisaPossu;
    }

    public void lisaaPossu() {
        Possu possu;
        if (possut.isEmpty()) {
            possu = new Possu(hoami.getX(), hoami.getY(), hoami);
        } else {
            possu = new Possu(hoami.getX(), hoami.getY(), possut.peek());
        }
        possut.push(possu);
    }

    public void hoamiHeittaaPossun() {
        if (!possut.isEmpty()) {
            Possu p = possut.pop();
            hoami.heitapossu(p);
            heitetyPossut.add(p);
        }

    }
    
    public void victory(){
        this.peliVoitettu = true;
    }

    public void poistaPossu() {
        possut.pop();
    }

    public ArrayList<Possu> getHeitetyPossut() {
        return heitetyPossut;
    }

    public boolean isGameOver() {
        return peliHavitty;
    }
    
    public boolean isGameWon(){
        return peliVoitettu;
    }

    public boolean levelClear() {
        if (this.pahikset.size() == 0) {
            return true;
        }
        return false;
    }

}
