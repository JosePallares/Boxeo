/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxeov3;

import java.util.Scanner;

/**
 *
 * @author josepallaresescobar
 */
public class Boxeo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numboxeadores;
        System.out.println("¿Cuantos boxeadores hay?");
        Scanner entrada = new Scanner(System.in);
        numboxeadores= Integer.parseInt(entrada.nextLine());
        
        Boxeador arrayBoxeador []= new Boxeador [numboxeadores];
        Thread arrayThreads []= new Thread [numboxeadores];
        
        for(int i=0; i<numboxeadores; i++){
            arrayBoxeador [i] = new Boxeador(i);
            arrayThreads [i] = new Thread(arrayBoxeador[i]);
        }
        
        System.out.println("Presiona enter para continuar");
        entrada.nextLine();
        
        for (int i=0; i<numboxeadores; i++){
            arrayThreads[i].start();
        }
        
        
        
    }
    
}
