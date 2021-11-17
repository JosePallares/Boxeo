
package boxeov2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class BoxeoV2 {

	private JFrame frmBoxeo;
	private JProgressBar pbBoxeador1;
	private JProgressBar pbBoxeador2;
        private JProgressBar pbBoxeador3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfProgreso;
	private JButton btLuchar;
	private JLabel lblProgreso;
	private JLabel lbMarcador;
	private JLabel progresoBoxeador1;

	private void luchar() {
		
		int progreso = 
			Integer.parseInt(tfProgreso.getText());
		
		final boxeador b1 = new boxeador(3, progreso, lbMarcador, "Tyson");
		final boxeador b2 = new boxeador(2, progreso, lbMarcador, "Creed");
		final boxeador b3 = new boxeador(1, progreso, lbMarcador, "Rocky");
		
		b1.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getPropertyName().equals("progress")) {
					pbBoxeador1.setValue((Integer) event.getNewValue());
					progresoBoxeador1.setText(
						event.getNewValue() + " %");
				}
				if (event.getPropertyName().equals("ganador")) {
					b2.cancel(true);
					b3.cancel(true);
				}
			}
		});
		b2.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getPropertyName().equals("progress")) {
					pbBoxeador2.setValue((Integer) event.getNewValue());
				}
				if (event.getPropertyName().equals("ganador")) {
					b1.cancel(true);
					b3.cancel(true);
				}
			}
		});
		b3.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getPropertyName().equals("progress")) {
					pbBoxeador3.setValue((Integer) event.getNewValue());
				}
				if (event.getPropertyName().equals("ganador")) {
					b1.cancel(true);
					b2.cancel(true);
				}
			}
		});
		
		b1.execute();
		b2.execute();
		b3.execute();
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoxeoV2 window = new BoxeoV2();
					window.frmBoxeo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creacion de la aplicacion.
	 */
	public BoxeoV2() {
		initialize();
	}

	/**
	 * Iniciaando el frame.
	 */
	private void initialize() {
		frmBoxeo = new JFrame();
		frmBoxeo.setTitle("Combate");
		frmBoxeo.setBounds(200, 200, 450, 300);
		frmBoxeo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBoxeo.getContentPane().setLayout(null);
		frmBoxeo.getContentPane().add(getPbBoxeador1());
		frmBoxeo.getContentPane().add(getPbBoxeador2());
		frmBoxeo.getContentPane().add(getLblNewLabel());
		frmBoxeo.getContentPane().add(getLblNewLabel_1());
		frmBoxeo.getContentPane().add(getPbBoxeador3());
		frmBoxeo.getContentPane().add(getLblNewLabel_2());
		frmBoxeo.getContentPane().add(getTfProgreso());
		frmBoxeo.getContentPane().add(getBtLuchar());
		frmBoxeo.getContentPane().add(getLblProgreso());
		frmBoxeo.getContentPane().add(getLbMarcador());
		frmBoxeo.getContentPane().add(getProgresoBoxeador1());
	}
	public JProgressBar getPbBoxeador1() {
		if (pbBoxeador1 == null) {
			pbBoxeador1 = new JProgressBar();
			pbBoxeador1.setBounds(10, 65, 422, 19);
		}
		return pbBoxeador1;
	}
	public JProgressBar getPbBoxeador2() {
		if (pbBoxeador2 == null) {
			pbBoxeador2 = new JProgressBar();
			pbBoxeador2.setBounds(10, 137, 422, 19);
		}
		return pbBoxeador2;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Boxeador 1");
			lblNewLabel.setBounds(10, 43, 46, 14);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Boxeador 2");
			lblNewLabel_1.setBounds(10, 114, 46, 14);
		}
		return lblNewLabel_1;
	}
	public JProgressBar getPbBoxeador3() {
		if (pbBoxeador3 == null) {
			pbBoxeador3 = new JProgressBar();
			pbBoxeador3.setString("34");
			pbBoxeador3.setBounds(10, 207, 422, 19);
		}
		return pbBoxeador3;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Boxeador 3");
			lblNewLabel_2.setBounds(10, 182, 46, 14);
		}
		return lblNewLabel_2;
	}
	public JTextField getTfProgreso() {
		if (tfProgreso == null) {
			tfProgreso = new JTextField();
			tfProgreso.setBounds(247, 12, 86, 20);
			tfProgreso.setColumns(10);
		}
		return tfProgreso;
	}
	public JButton getBtLuchar() {
		if (btLuchar == null) {
			btLuchar = new JButton("Luchar");
			btLuchar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					luchar();
				}
			});
			btLuchar.setBounds(343, 11, 89, 23);
		}
		return btLuchar;
	}
	public JLabel getLblProgreso() {
		if (lblProgreso == null) {
			lblProgreso = new JLabel("Progreso");
			lblProgreso.setBounds(176, 15, 72, 14);
		}
		return lblProgreso;
	}
	public JLabel getLbMarcador() {
		if (lbMarcador == null) {
			lbMarcador = new JLabel("");
			lbMarcador.setBounds(147, 241, 144, 14);
		}
		return lbMarcador;
	}
	public JLabel getProgresoBoxeador1() {
		if (progresoBoxeador1 == null) {
			progresoBoxeador1 = new JLabel("");
			progresoBoxeador1.setBounds(65, 40, 46, 14);
		}
		return progresoBoxeador1;
	}
}

