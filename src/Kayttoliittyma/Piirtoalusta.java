/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;
import Peliolennot.hyvikset.Possu;
import Pelilogiikka.Peli;
import Peliolennot.*;
import Peliolennot.pahikset.Pahis;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author eamiller
 */
public class Piirtoalusta extends JPanel{
    private Peli p;

    public Piirtoalusta(Peli p) {
        this.p = p;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(p.isGameOver()){
            displayGameOver(g);
        }else if(p.isGameWon()){
            displayVictory(g);
        }else{
            displayGame(g);
        }
        
    }
    
    private void displayGame(Graphics g){
        p.getPelilauta().luoLauta(g);
        p.getLisaPossu().luo(g);
        p.getHoami().luo(g);
        for(Possu p : p.getPossut()){
            p.luo(g);
        }
        for(Pahis p : p.getPahikset()){
            p.luo(g);
        }
        for(Possu p : p.getHeitetyPossut()){
            p.luo(g);
        }
        g.setColor(Color.black);
        g.fillRect(1295, 0, 200, 1000);
        g.fillRect(0, 800, 1495, 200); 
        p.getPelaaja().luoNakyma(g);
    }
    
    private void displayGameOver(Graphics g){
        g.fillRect(0, 0, 1500, 1000);
        g.setColor(Color.orange);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        g.drawString("GAME OVER", 300, 300);
        g.setFont(new Font("Lobster Two", Font.PLAIN, 25)); 
    }
    
    private void displayVictory(Graphics g){
        g.fillRect(0, 0, 1500, 1000);
        g.setColor(Color.orange);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
        g.drawString("You won!", 300, 300);
        g.setFont(new Font("Lobster Two", Font.PLAIN, 25)); 
        g.drawString("(Not bad)", 770, 435);
    }
    
    
}