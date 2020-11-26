package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import hotel.Cliente;

public class VentanaContinuacion extends JFrame{
	
	JButton elegirNuevoServicio;
	JButton continuar;
	
	public VentanaContinuacion(Cliente cliente, int pago) {
		
		setLayout(new GridLayout(2, 1));
		
		elegirNuevoServicio = new JButton("ELEGIR NUEVO SERVICIO");
		continuar = new JButton("CONTINUAR");
		
		elegirNuevoServicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaServicios vs = new VentanaServicios(cliente, pago);				
				dispose();
			}
		});
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		
		add(elegirNuevoServicio);
		add(continuar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Continuacion");
		setSize(800, 200);
		setVisible(true);
		
	}

}
