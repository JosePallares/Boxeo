/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxeov1;

import java.util.Scanner;

/**
 *
 * @author josepallaresescobar
 */
public class BoxeoV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	
	Ring ring = new Ring();
        
        
		Boxeador boxeador1 = new Boxeador("Tyson", ring);
		Boxeador boxeador2 = new Boxeador("Rocky", ring);
                Boxeador boxeador3 = new Boxeador("Creed", ring);
		
		boxeador1.start();
		boxeador2.start();
                boxeador3.start();
		
		try {
			boxeador1.join();
			boxeador2.join();
		} catch (InterruptedException ie) {}
		
		System.out.println("Fin del combate");
		if (boxeador1.getGolpes() > boxeador2.getGolpes() && boxeador1.getGolpes() > boxeador3.getGolpes())
			System.out.println("Ha ganado " + boxeador1.getNombre());
		else if (boxeador2.getGolpes() < boxeador1.getGolpes() && boxeador2.getGolpes() < boxeador3.getGolpes())
			System.out.println("Ha ganado " + boxeador2.getNombre());
                else if (boxeador3.getGolpes() < boxeador1.getGolpes() && boxeador3.getGolpes() < boxeador2.getGolpes())
			System.out.println("Ha ganado " + boxeador2.getNombre());
		else
			System.out.println("Empate");
	}
}
