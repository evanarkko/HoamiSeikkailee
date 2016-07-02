/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peliolennot.pahikset;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author eamiller
 */
public class Susi extends Pahis {

    private BufferedImage img;
    private final static String imgPath = "wolf2.png";

    public Susi(int x, int y) {
        super(x, y);
        try {
            img = ImageIO.read(new File(imgPath));
        } catch (Exception e) {
            System.out.println("Exception in loading the wolf image: " + e.toString());
        }
        this.liikkumisKynnys = 40;
        this.health = 2;
    }

    @Override
    public void luo(Graphics g) {
        g.drawImage(img, koordinaattiX, koordinaattiY, 130, 100, null);
//        g.setColor(Color.gray);
//        g.fillOval(koordinaattiX, koordinaattiY, 50, 50);
    }

    @Override
    public void setKoordinaatit(int koordinaattiX, int koordinaattiY) {
        this.koordinaattiX = koordinaattiX - 55;
        this.koordinaattiY = koordinaattiY - 45;
    }

    @Override
    public boolean isSusi() {
        return true;
    }

    public void liiku(int kohdeX, int kohdeY) {
        if (Math.abs(this.koordinaattiX - kohdeX) > Math.abs(this.koordinaattiY - kohdeY)) {

            if (koordinaattiX < kohdeX) {
                if (!((y > 2) && (y < 6))) {
                    liikuOikealle();
                } else if (x + 1 != 5) {
                    liikuOikealle();
                }
            }
            if (koordinaattiX > kohdeX) {
                if (!((y > 2) && (y < 6))) {
                    liikuVasemmalle();
                } else if (x - 1 != 8) {
                    liikuVasemmalle();
                }
            }
        } else {
            if (koordinaattiY < kohdeY) {
                
                if (!((y > 2) && (y < 6))) {
                    
                liikuAlas();
                } else if (x - 1 != 8) {
                liikuAlas();
                    
                }
                liikuAlas();
            }
            if (koordinaattiY > kohdeY) {
                liikuYlos();
            }
        }
    }

}
