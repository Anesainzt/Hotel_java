package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hotel.*;

public class VentanaCliente extends JFrame{
	
	JButton historial;
	JButton nuevaReserva;
	JPanel inicio;
	JPanel reservas;
	
	
	public VentanaCliente(Cliente cliente) {
		
		inicio = new JPanel();
		reservas = new JPanel();
		historial = new JButton("HISTORAIL DE RESERVA");
		nuevaReserva = new JButton("NUEVA RESERVA");
		
		historial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		
		nuevaReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		
		inicio.add(historial);
		inicio.add(nuevaReserva);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Identificación del cliente");
		inicio.setSize(800, 200);
		inicio.setVisible(true);
		reservas.setVisible(false);
		
	}
	
}