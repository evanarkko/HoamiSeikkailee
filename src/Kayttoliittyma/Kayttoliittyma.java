/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author eamiller
 */
public class Kayttoliittyma implements Runnable{
    private JFrame frame;
    private JPanel piirtoalusta;
    private KeyListener n;

    public Kayttoliittyma(JPanel piirtoalusta, KeyListener k) {
        this.frame = new JFrame("Homie");
        this.piirtoalusta = piirtoalusta;
        this.n = k;
    }
    
    @Override
    public void run() {
        frame.setPreferredSize(new Dimension(1500, 800));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container){
        container.add(piirtoalusta);
        frame.addKeyListener(n);
    }
    
}
