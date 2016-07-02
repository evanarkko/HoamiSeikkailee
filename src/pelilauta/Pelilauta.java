package pelilauta;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.ColorSpace;

/**
 *
 * @author eamiller
 */
public class Pelilauta {

    private Peliruutu[][] ruudukko;

    public Pelilauta() {
        this.ruudukko = new Peliruutu[100][100];
        for (int x = 1; x < 14; x += 1) {
            for (int y = 1; y < 9; y += 1) {
                ruudukko[x][y] = new Peliruutu((x-1)*100 + 50, (y-1)*100 + 50);
                
            }
        }
    }

    public Peliruutu[][] getRuudukko() {
        return ruudukko;
    }
    
    

    public void luoLauta(Graphics g) {
//        g.setColor(new Color(0, 0, 145));
    g.setColor(Color.black);
        g.fillRect(0, 0, 1295, 800);
//        g.setColor(new Color(0, 160, 145));
        g.setColor(Color.green);
        for (int i = 0; i < 1300; i += 100) {
            g.fillRect(i, 0, 5, 1000);
        }
        for (int i = 0; i < 800; i += 100) {
            g.fillRect(0, i, 1300, 5);
        }
//        g.setColor(new Color(95, 0, 140));
        g.setColor(new Color(0, 160, 145));
        g.fillRect(405, 205, 395, 295);
    }
}
