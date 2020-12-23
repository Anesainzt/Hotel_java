package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import hotel.Cliente;

public class VentanaContinuacion extends JFrame{
	
	JButton elegirNuevoServicio;
	JButton continuar;
	JProgressBar barra;
	
	public VentanaContinuacion(Cliente cliente) {
		
		setLayout(new GridLayout(3, 1));
		
		elegirNuevoServicio = new JButton("ELEGIR NUEVO SERVICIO");
		continuar = new JButton("CONTINUAR");
		
		elegirNuevoServicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaServicios vs = new VentanaServicios(cliente);				
				dispose();
			}
		});
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaFactura vf = new VentanaFactura(cliente);
				dispose();
				
			}
		});
		
		
		barra = new JProgressBar(0,50);
		
		Thread hilo = new Thread(new Runnable() {

			@Override
			public void run() {
				barra.setVisible(true);
				
				for (int i = 0; i <= 75; i++) {
					barra.setValue(i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				continuar.setVisible(true);
				
			}
			
			
		});
		hilo.start();
		
		
		
		add(elegirNuevoServicio);
		add(continuar);
		add(barra);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Continuacion");
		setSize(800, 200);
		setVisible(true);
		continuar.setVisible(false);
		
	}

}
