package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import hotel.Cliente;
import ventanas.VentanaCalendario;
import ventanas.VentanaReservaServicio;

public class VentanaSpa extends JFrame{
	
	JComboBox<String> comboSpa;
	JLabel spa;
	JButton continuar;
	
	public VentanaSpa(Cliente cliente, int pago) {
		setLayout(new GridLayout(3, 1));
		
		comboSpa = new JComboBox<String>();
		
		spa = new JLabel("SPA: ");
		continuar = new JButton("CONTINUAR");
				
		comboSpa.addItem("MASAJE FACIAL ---> 50€");
		comboSpa.addItem("MASAJE CORPORAL ---> 90€");
		comboSpa.addItem("MASAJE TOTAL ---> 130€");
		comboSpa.addItem("JACUZZI ---> 150€");
		comboSpa.addItem("SALES MINERALES ---> 60€");
		comboSpa.addItem("MASAJE PIEDRAS ---> 80€");
		comboSpa.addItem("TRATAMIENTO ESTETICO ---> 90€");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente nuevo;
				
				if (cliente != null) {
					nuevo = cliente;
				} else {
					nuevo = new Cliente();
				}
				
				int contador = 1;
				try {
					Scanner sc = new Scanner(new FileInputStream("Servicios"));
					while(sc.hasNext()) {
						contador = contador + 1;
						String linea = sc.nextLine();
					}
					
				}catch(FileNotFoundException e1) {
					System.err.println("ERROR");
				}
				
				PrintWriter pw = null;
				try {
				    pw = new PrintWriter(new BufferedWriter(new FileWriter("Servicios", true)));
				    pw.print("");
				    
				    if(comboSpa.getSelectedItem().equals("MASAJE FACIAL ---> 50€")) {
				    	pw.println(contador + ";" + "MASAJE FACIAL" + ";" + 50);
				    	JOptionPane.showMessageDialog(null, pago + 50);
				    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago);
				    }else if(comboSpa.getSelectedItem().equals("MASAJE CORPORAL ---> 90€")) {
				    	pw.println(contador + ";" + "MASAJE CORPORAL" + ";" + 90);
				    	JOptionPane.showMessageDialog(null, pago + 90);
				    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago);
				    }else if(comboSpa.getSelectedItem().equals("MASAJE TOTAL ---> 130€")) {
				    	pw.println(contador + ";" + "MASAJE TOTAL" + ";" + 130);
				    	JOptionPane.showMessageDialog(null, pago + 130);
				    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago);
				    }else if(comboSpa.getSelectedItem().equals("JACUZZI ---> 150€")) {
				    	pw.println(contador + ";" + "JACUZZI" + ";" + 150);
				    	JOptionPane.showMessageDialog(null, pago + 150);
				    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago);
				    }else if(comboSpa.getSelectedItem().equals("SALES MINERALES ---> 60€")) {
				    	pw.println(contador + ";" + "SALES MINERALES" + ";" + 60);
				    	JOptionPane.showMessageDialog(null, pago + 60);
				    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago);
				    }else if(comboSpa.getSelectedItem().equals("MASAJE PIEDRAS ---> 80€")) {
				    	pw.println(contador + ";" + "MASAJE PIEDRAS" + ";" + 80);
				    	JOptionPane.showMessageDialog(null, pago + 80);
				    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago);
				    }else{
				    	pw.println(contador + ";" + "TRATAMIENTO ESTETICO" + ";" + 90);
				    	JOptionPane.showMessageDialog(null, pago + 90);
				    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago);
				    }
				    
				} catch (IOException e1) {
				    System.err.println(e1);
				} finally {
				    if (pw != null) {
				        pw.close();
				    }
				}
				
				dispose();
			}
		});
		
		
		add(spa);
		add(comboSpa);
		add(continuar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio SPA");
		setSize(800, 200);
		setVisible(true);
	}

}