
package boxeov2;


import java.util.Random;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class boxeador extends SwingWorker<Void, Integer> {

	private int golpe;
	private int vida;
	private int vidagastada;
	private JLabel marcador;
	private String nombre;

	public boxeador(int velocidad, int vidagastada,
		JLabel marcador, String nombre) {
		
		this.golpe = golpe;
		this.vida = vida;
		vidagastada = 100;
		this.marcador = marcador;
		this.nombre = nombre;
	}

    public boxeador(int vida,
                 JLabel marcador, String nombre) {

        this.golpe = new Random().nextInt();
        this.vida = vida;
        vidagastada = 0;
        this.marcador = marcador;
        this.nombre = nombre;
    }

	@Override
	protected Void doInBackground() throws Exception {
		
		while (vidagastada < vida) {
			Thread.sleep(100);
			vidagastada += golpe;
			if (vidagastada > vida)
				vidagastada = vida;
			
			setProgress(vidagastada * 100 / 
				vida);
			
			/*if (isCancelled())
				return null;*/
		}
		
		marcador.setText(nombre + ": Ha ganado");
		firePropertyChange("ganador", "", nombre);
		
		return null;
	}
}