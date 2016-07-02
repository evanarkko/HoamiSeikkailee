/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Peliolennot.gadgets;

import Peliolennot.Peliolio;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author eamiller
 */
public class LisaPossu extends Peliolio{
    
    private BufferedImage img;
    private final static String imgPath = "possu.png";
    
    public LisaPossu(int x, int y) {
        super(x, y);
        try {
            img = ImageIO.read(new File(imgPath));
        } catch (Exception e) {
            System.out.println("Exception in loading the wolf image: " + e.toString());
        }
    }
    

    @Override
    public void luo(Graphics g) {
//        g.setColor(Color.pink);
//        g.fillOval(x, y, 30, 30);
//        g.setColor(Color.black);
//        g.drawOval(x, y, 30, 30);
//        g.drawOval(x+9, y+11, 12, 12);
//        g.fillOval(x+7, y+3, 5, 5);
//        g.fillOval(x+17, y+3, 5, 5);
//        g.fillOval(x+11, y+14, 3, 6);
//        g.fillOval(x+16, y+14, 3, 6);
        
        
        g.drawImage(img, x, y, 50, 50, null);
    }
    
    
    
}
