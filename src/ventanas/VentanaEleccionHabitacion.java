package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

import hotel.Cliente;

public class VentanaEleccionHabitacion extends JFrame{

	JComboBox<String> comboHabitaciones;
	JLabel habitaciones;
	JButton elegir;
	
	public static void fichero(String tipo, int precio) {
		PrintWriter pw = null;
		try {
		    pw = new PrintWriter(new BufferedWriter(new FileWriter("datosFactura.txt", true)));
		    pw.print(";" + tipo + ";" + precio);
		    
		} catch (IOException e1) {
		    System.err.println(e1);
		} finally {
		    if (pw != null) {
		        pw.close();
		    }
		}
	}
	
	public VentanaEleccionHabitacion(Cliente cliente) {
		
		setLayout(new GridLayout(3, 1));
		
		//TE DAN UNA SERIE DE HABITACIONES ENTRE LAS QUE PUEDES ELEGIR
		comboHabitaciones = new JComboBox<String>();
		
		habitaciones = new JLabel("HABITACIONES: ");
		elegir = new JButton("ELEGIR HABITACION");
		
		comboHabitaciones.addItem("VIP ---> 200€/noche");
		comboHabitaciones.addItem("DOBLE ---> 100€/noche");
		comboHabitaciones.addItem("INDIVIDUAL ---> 80€/noche");
		comboHabitaciones.addItem("FAMILIAR ---> 130€/noche");
		
		//AL ELEGIRLA SE GUARDARÁ EN UN FICHERO PARA UTILIZAR LA INFORMACION MAS ADELANTE
		elegir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    
				if(comboHabitaciones.getSelectedItem().equals("VIP ---> 200€/noche")){
					fichero("VIP", 200);
					VentanaCalendario vc = new VentanaCalendario(cliente, 200, "VIP");
				}else if(comboHabitaciones.getSelectedItem().equals("DOBLE ---> 100€/noche")){
					fichero("DOBLE", 100);
					VentanaCalendario vc = new VentanaCalendario(cliente, 100, "DOBLE");
				}else if(comboHabitaciones.getSelectedItem().equals("INDIVIDUAL ---> 80€/noche")){
					fichero("INDIVIDUAL", 80);
					VentanaCalendario vc = new VentanaCalendario(cliente, 80, "INDIVIDUAL");
				}else{
					fichero("FAMILIAR", 130);
					VentanaCalendario vc = new VentanaCalendario(cliente, 130, "FAMILIAR");
				}
				
				dispose();
				
			}
		});
		
		add(habitaciones);
		add(comboHabitaciones);
		add(elegir);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Elección habitación");
		setSize(800, 200);
		setVisible(true);
		
	}
	
}