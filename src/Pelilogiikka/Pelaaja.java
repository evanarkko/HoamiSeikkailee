/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelilogiikka;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author eamiller
 */
public class Pelaaja {
    private String nimi;
    private int aitauksenHealth;
    private int health;
    private int pisteet;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.aitauksenHealth = 100;
        this.health = 100;
        this.pisteet = 0;
    }
    
    public boolean isDefeated(){
        if(this.health < 1 || this.aitauksenHealth < 1){
            return true;
        }
        return false;
    }
    
    public void takeDamage(int damage){
        this.health -= damage;
    }
    
    public void aitausOttaaDamagea(int damage){
        this.aitauksenHealth -= damage;
    }
    
    public void lisaaPisteita(int pisteita){
        this.pisteet += pisteita;
    }
    
    public void luoNakyma(Graphics g){
        g.setFont(new Font("TimesRoman", Font.PLAIN, 35)); 
        g.setColor(new Color(128,0,0));
        int x = 430;
        int y = 300;
        String omistus;
        char c = nimi.charAt(nimi.length()-1);
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='y'||c=='ä'||c=='ö'){
            omistus = "n";
        }else{
            omistus = "in";
        }
        g.drawString(nimi + omistus + " aitaus", x, y);
        g.drawString("Tarhan kunto: " + aitauksenHealth + "%", x, y+35);
        g.drawString("Oma kunto: " + health + "%", x, y+70);
        g.drawString("Pisteet: " + pisteet, x, y+105);
    }

    public int getHealth() {
        return health;
    }

    public String getNimi() {
        return nimi;
    }
    
        
    
}
