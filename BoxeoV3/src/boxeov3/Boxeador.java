/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxeov3;

import java.util.logging.Level;
import java.util.logging.Logger;
import static java.lang.Thread.sleep;

/**
 *
 * @author josepallaresescobar
 */
public class Boxeador implements Runnable{

private int golpe;
private int vida;
private int num;

    public Boxeador(int golpe){
        this.golpe = golpe;
        this.vida = 100;
        
    }

    
    
    
    
    @Override
    public void run() {
        int tEspera;
        int vidafinal =0;
       while(vida<0){
           
           tEspera = (int) Math.floor(Math.random()*10+2);
            try {
                Thread.sleep(tEspera);
            } catch (InterruptedException ex) {
                Logger.getLogger(Boxeador.class.getName()).log(Level.SEVERE, null, ex);
            }
            vida -=golpe;
           
           System.out.println("Al boxeador " + num + " le quedan " + vida + " puntos de vida");
       } 
        
    }
    
}
