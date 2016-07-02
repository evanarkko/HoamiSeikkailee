/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoamiseikkailee;

import Kayttoliittyma.Piirtoalusta;
import Kayttoliittyma.Kayttoliittyma;
import Kayttoliittyma.Nappaintenkuuntelija;
import Pelilogiikka.Levelit;
import Pelilogiikka.Peli;
import Peliolennot.hyvikset.*;
import Peliolennot.pahikset.*;
import java.util.ArrayList;

/**
 *
 * @author eamiller
 */
public class HoamiSeikkailee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int currentLevel = 1;
        Hoami hoami = new Hoami(100, 300);
        Peli peli = new Peli(hoami);
        Levelit lvls = new Levelit(peli);
        
        Piirtoalusta p = new Piirtoalusta(peli);
        Nappaintenkuuntelija n = new Nappaintenkuuntelija(peli);
        Kayttoliittyma k = new Kayttoliittyma(p, n);
        k.run();
        
        while(true){
            Thread.sleep(23);
            if(!peli.isGameOver()) peli.etene();
            if(peli.levelClear()){
                lvls.makeLevel(currentLevel);
                currentLevel++;
            }
            p.repaint();
        }
        
    }
    
}