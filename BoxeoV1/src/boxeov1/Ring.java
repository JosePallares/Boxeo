/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxeov1;

/**
 *
 * @author josepallaresescobar
 */
public class Ring {
private int golpes;
	
	public Ring() {
		golpes = 0;
	}
	
	public int getGolpes() {
		return golpes;
	}
	
	public synchronized void pegar(Boxeador boxeador) {
		
		boxeador.pegar();
		golpes++;
		
		System.out.println("Pegada de " + boxeador.getNombre() + " (" + boxeador.getGolpes() + ")");
	}
}
