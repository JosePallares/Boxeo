/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxeov1;

import java.util.Random;

/**
 *
 * @author josepallaresescobar
 */

 public class Boxeador extends Thread {

	private String nombre;
	private Ring ring;
	private int golpes;
	
	public Boxeador(String nombre, Ring ring) {
		
		this.nombre = nombre;
		this.ring = ring;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getGolpes() {
		return golpes;
	}
	
	public void pegar() {
		golpes++;
	}
	
	@Override
	public void run() {
		
		while (ring.getGolpes() < 100) {
			
			ring.pegar(this);
			try {
				Thread.sleep(new Random().nextInt(500));
			} catch (InterruptedException ie) {}
		}
	}
}

