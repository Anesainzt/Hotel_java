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

public class VentanaComida extends JFrame{

	JComboBox<String> comboComida;
	JLabel comida;
	JButton continuar;
	
	public VentanaComida(Cliente cliente, int pago) {
		setLayout(new GridLayout(3, 1));
		
		comboComida = new JComboBox<String>();
		
		comida = new JLabel("COMIDA: ");
		continuar = new JButton("ELEGIR RESTAURANTE");
		
		comboComida.addItem("MCDONALDS ---> 30€");
		comboComida.addItem("BURGER KING ---> 30€");
		comboComida.addItem("FOSTERS HOLLYWOOD ---> 40€");
		comboComida.addItem("POMODORO ---> 45€");
		comboComida.addItem("FOODOO ---> 50€");
		comboComida.addItem("DONGA ---> 60€");
		comboComida.addItem("MENU DEL DIA HOTEL ---> 150€");
		comboComida.addItem("BUFFET HOTEL ---> 110€");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboComida.getSelectedItem().equals("MCDONALDS ---> 30€")) {
			    	JOptionPane.showMessageDialog(null, pago + 30);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 30, "MCDONALDS");
				}else if (comboComida.getSelectedItem().equals("BURGER KING ---> 30€")){
					JOptionPane.showMessageDialog(null, pago + 30);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 30, "BURGER KING");
				} else if (comboComida.getSelectedItem().equals("FOSTERS HOLLYWOOD ---> 40€")) {
					JOptionPane.showMessageDialog(null, pago + 40);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 40, "FOSTERS HOLLYWOOD");
				}else if (comboComida.getSelectedItem().equals("POMODORO ---> 45€")) {
					JOptionPane.showMessageDialog(null, pago + 45);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 45, "POMODORO");
				}else if (comboComida.getSelectedItem().equals("FOODOO ---> 50€")) {
					JOptionPane.showMessageDialog(null, pago + 50);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 50, "FOODOO");
				}else if (comboComida.getSelectedItem().equals("DONGA ---> 60€")) {
					JOptionPane.showMessageDialog(null, pago + 60);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 60, "DONGA");
				}else if (comboComida.getSelectedItem().equals("MENU DEL DIA HOTEL ---> 150€")) {
					JOptionPane.showMessageDialog(null, pago + 150);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 150, "MENU DEL DIA HOTEL");
				}else {
					JOptionPane.showMessageDialog(null, pago + 110);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 110, "BUFFET HOTEL");
				}
				
				dispose();
			}
		});
		
		add(comida);
		add(comboComida);
		add(continuar);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio Comida");
		setSize(800, 200);
		setVisible(true);

	}
	
}
