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

public class VentanaMiniBar extends JFrame{

	JComboBox<String> comboMiniBar;
	JLabel miniBar;
	JButton continuar;
	
	public VentanaMiniBar(Cliente cliente, int pago) {
		setLayout(new GridLayout(3, 1));
		
		comboMiniBar = new JComboBox<String>();
		
		miniBar = new JLabel("MINI BAR: ");
		continuar = new JButton("CONTINUAR");
		
		comboMiniBar.addItem("VODKA ---> 30€");
		comboMiniBar.addItem("GINEBRA ---> 30€");
		comboMiniBar.addItem("WHISKEY ---> 50€");
		comboMiniBar.addItem("TEQUILA ---> 45€");
		comboMiniBar.addItem("RON ---> 30€");
		comboMiniBar.addItem("ELECCION DE DOS (DIFERENTES) ---> 90€");
		comboMiniBar.addItem("ELECCION DE TRES (DIFERENTES) ---> 140€");
		comboMiniBar.addItem("TODOS ---> 180€");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboMiniBar.getSelectedItem().equals("VODKA ---> 30€")) {
			    	JOptionPane.showMessageDialog(null, pago + 30);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 30);
				}else if (comboMiniBar.getSelectedItem().equals("GINEBRA ---> 30€")){
					JOptionPane.showMessageDialog(null, pago + 30);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 30);
				}else if (comboMiniBar.getSelectedItem().equals("WHISKEY ---> 50€")){
					JOptionPane.showMessageDialog(null, pago + 50);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 50);
				}else if (comboMiniBar.getSelectedItem().equals("TEQUILA ---> 45€")){
					JOptionPane.showMessageDialog(null, pago + 45);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 45);
				}else if (comboMiniBar.getSelectedItem().equals("RON ---> 30€")){
					JOptionPane.showMessageDialog(null, pago + 30);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 30);
				}else if (comboMiniBar.getSelectedItem().equals("ELECCION DE DOS (DIFERENTES) ---> 90€")){
					JOptionPane.showMessageDialog(null, pago + 90);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 90);
				}else if (comboMiniBar.getSelectedItem().equals("ELECCION DE TRES (DIFERENTES) ---> 140€")){
					JOptionPane.showMessageDialog(null, pago + 140);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 140);
				}else {
					JOptionPane.showMessageDialog(null, pago + 180);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 180);
				}
				
				dispose();
			}
		});
		
		add(miniBar);
		add(comboMiniBar);
		add(continuar);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio Mini Bar");
		setSize(800, 200);
		setVisible(true);

	}
}
