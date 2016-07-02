package Peliolennot.hyvikset;

import Peliolennot.Pelihahmo;
import Peliolennot.Suunta;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author eamiller
 */
public class Possu extends Pelihahmo {
    private int nopeus;
    private int nopeusX;
    private int nopeusY;
    private Pelihahmo edeltaja;
    private Suunta suunta;
    private boolean heitetty;

    public Possu(int x, int y, Pelihahmo edeltaja) {
        super(x, y);
        this.edeltaja = edeltaja;
        this.heitetty = false;
        nopeus = 6;
    }

    public void setNopeusX(int nopeusX) {
        this.nopeusX = nopeusX;
    }

    public void setNopeusY(int nopeusY) {
        this.nopeusY = nopeusY;
    }

    
    @Override
    public void luo(Graphics g) {
        g.setColor(new Color(210, 170, 210));
        g.fillOval(x, y, 30, 17);
        g.fillRect(x + 3, y + 12, 6, 10);
        g.fillRect(x + 21, y + 12, 6, 10);
        if (this.suunta == Suunta.EAST) {
            luoOikealle(g);
        } else {
            luoVasemalle(g);
        }
//        g.drawImage(img, x, y, 50, 50, null);
    }

    private void luoOikealle(Graphics g) {
        g.fillOval(x + 20, y - 5, 15, 15);
        g.fillRect(x + 29, y, 10, 4);
        g.setColor(Color.black);
        g.fillOval(x + 30, y - 2, 3, 3);
    }

    private void luoVasemalle(Graphics g) {
        g.fillOval(x - 5, y - 5, 15, 15);
        g.fillRect(x - 8, y, 10, 4);
        g.setColor(Color.black);
        g.fillOval(x - 2, y - 2, 3, 3);
    }

    private int etaisyysEdeltajasta() { //Pythagoraan lause
        int etaisyysX = Math.abs(this.x - edeltaja.x);
        int etaisyysY = Math.abs(this.y - edeltaja.y);
        int etaisyys = (int) Math.sqrt(Math.pow(etaisyysX, 2) + Math.pow(etaisyysY, 2));
        return etaisyys;
    }

    public void setHeitetty(boolean heitetty) {
        this.heitetty = heitetty;
    }
    
    

    @Override
    public void liiku() {
        if (heitetty) {
            this.x += nopeusX;
            this.y += nopeusY;
        } else if (etaisyysEdeltajasta() > 70) {
            if (this.x < edeltaja.x) {
                this.suunta = Suunta.EAST;
                this.x += nopeus;
                if (this.y < edeltaja.y) {
                    this.y += nopeus;
                }
                if (this.y > edeltaja.y) {
                    this.y -= nopeus;
                }
            } else {
                this.x -= nopeus;
                this.suunta = Suunta.WEST;
                if (this.y < edeltaja.y) {
                    this.y += nopeus;
                }
                if (this.y > edeltaja.y) {
                    this.y -= nopeus;
                }
            }
        }

    }

}
