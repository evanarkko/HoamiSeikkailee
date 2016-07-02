/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peliolennot.pahikset;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author eamiller
 */
public class Kaarme extends Pahis {

    private BufferedImage img;

    public Kaarme(int x, int y, String imgPath) {
        super(x, y);
        try {
            img = ImageIO.read(new File(imgPath));
        } catch (Exception e) {
            System.out.println("Exception in loading the wolf image: " + e.toString());
        }
        if (imgPath.contains("red")) {
            this.liikkumisKynnys = 30;
        } else if (imgPath.contains("green")){
            this.liikkumisKynnys = 55;
        }else{
            this.liikkumisKynnys = 80;
        }
        this.health = 1;

    }

    @Override
    public void luo(Graphics g) {
        g.drawImage(img, koordinaattiX, koordinaattiY, 100, 70, null);
    }

    @Override
    public void setKoordinaatit(int koordinaattiX, int koordinaattiY) {
        this.koordinaattiX = koordinaattiX - 55;
        this.koordinaattiY = koordinaattiY - 45;
    }

}
