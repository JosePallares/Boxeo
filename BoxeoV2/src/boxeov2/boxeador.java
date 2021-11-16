
package boxeov2;

import java.util.Random;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 * Representa a cada uno de los coches que compiten en la carrera
 * Notifican, mediante la clase SwingWorker su progreso al UI de la clase principal
 * @author Santiago Faci
 * @version curso 2014-2015
*/
public class boxeador extends SwingWorker<Void, Integer> {

	private int golpe;
	private int vida;
	private JLabel marcador;
	private String nombre;

	public boxeador(int golpe, int vida,
		JLabel marcador, String nombre) {
		
		this.golpe = golpe;
		this.vida = vida;
		this.marcador = marcador;
		this.nombre = nombre;
	}

    public boxeador(int vida,
                 JLabel marcador, String nombre) {

        this.golpe = new Random().nextInt(5);
        this.vida = vida;
        this.marcador = marcador;
        this.nombre = nombre;
    }

	@Override
	protected Void doInBackground() throws Exception {
		
		while (vida > 0) {
			Thread.sleep(100);
			vida -= golpe;
			if (vida < 0)
				vida = 0;
			
			//setProgress(distanciaRecorrida * 100 / 
			//	vida);
			
			/*if (isCancelled())
				return null;*/
		}
		
		marcador.setText(nombre + ": He ganado");
		firePropertyChange("ganador", "", nombre);
		
		return null;
	}
}
