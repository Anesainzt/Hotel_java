package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import hotel.Cliente;
import ventanas.VentanaReservaServicio;

public class VentanaDeporte extends JFrame{

	JComboBox<String> comboDeporte;
	JLabel deporte;
	JButton elegir;
	
	public VentanaDeporte(Cliente cliente, int pago) {
		setLayout(new GridLayout(3, 1));
		
		comboDeporte = new JComboBox<String>();
		
		deporte = new JLabel("DEPORTE: ");
		elegir = new JButton("ELEGIR PISTA");
		
		comboDeporte.addItem("PISTA TENNIS ---> 15€/hora");
		comboDeporte.addItem("PISTA PADDLE ---> 15€/hora");
		comboDeporte.addItem("PISCINA NATACION ---> 10€/hora");
		comboDeporte.addItem("CAMPO FUTBOL ---> 20€/hora");
		comboDeporte.addItem("CAMPO BALONCESTO ---> 20€/hora");
		comboDeporte.addItem("PISTA ATLETISMO ---> 10€/hora");
		comboDeporte.addItem("CAMPO FUTBOL-SALA ---> 15€/hora");
		
		comboDeporte.addItem("CLASE TENNIS ---> 30€/hora");
		comboDeporte.addItem("CLASE PADDLE ---> 30€/hora");
		comboDeporte.addItem("CLASE NATACION ---> 15€/hora");
		comboDeporte.addItem("CLASE FUTBOL ---> 30€/hora");
		comboDeporte.addItem("CLASE BALONCESTO ---> 30€/hora");
		comboDeporte.addItem("CLASE ATLETISMO ---> 15€/hora");
		comboDeporte.addItem("CLASE FUTBOL-SALA ---> 20€/hora");
		
		elegir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboDeporte.getSelectedItem().equals("PISTA TENNIS ---> 15€/hora")) {
			    	JOptionPane.showMessageDialog(null, pago + 15);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 15);
				}else if (comboDeporte.getSelectedItem().equals("PISTA PADDLE ---> 15€/hora")){
					JOptionPane.showMessageDialog(null, pago + 15);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 15);
				} else if (comboDeporte.getSelectedItem().equals("PISCINA NATACION ---> 10€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 10);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 10);
				}else if (comboDeporte.getSelectedItem().equals("CAMPO FUTBOL ---> 20€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 20);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 20);
				}else if (comboDeporte.getSelectedItem().equals("CAMPO BALONCESTO ---> 20€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 20);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 20);
				}else if (comboDeporte.getSelectedItem().equals("PISTA ATLETISMO ---> 10€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 10);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 10);
				}else if (comboDeporte.getSelectedItem().equals("CAMPO FUTBOL-SALA ---> 15€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 15);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 15);
				}else if (comboDeporte.getSelectedItem().equals("CLASE TENNIS ---> 30€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 30);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 30);
				}else if (comboDeporte.getSelectedItem().equals("CLASE PADDLE ---> 30€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 30);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 30);
				}else if (comboDeporte.getSelectedItem().equals("CLASE NATACION ---> 15€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 15);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 15);
				}else if (comboDeporte.getSelectedItem().equals("CLASE FUTBOL ---> 30€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 30);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 30);
				}else if (comboDeporte.getSelectedItem().equals("CLASE BALONCESTO ---> 30€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 30);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 30);
				}else if (comboDeporte.getSelectedItem().equals("CLASE ATLETISMO ---> 15€/hora")) {
					JOptionPane.showMessageDialog(null, pago + 15);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 15);
				}else {
					JOptionPane.showMessageDialog(null, pago + 20);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 20);
				}
				
				dispose();
			}
		});
		
		add(deporte);
		add(comboDeporte);
		add(elegir);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio Deportes");
		setSize(800, 200);
		setVisible(true);

	}
}
