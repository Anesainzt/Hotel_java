package ventanas;

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

import javax.swing.*;

import hotel.Cliente;

public class VentanaEleccionHabitacion extends JFrame{

	JComboBox<String> comboHabitaciones;
	JLabel habitaciones;
	JButton elegir;
	
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
				//DESPUES DE ELEGIR LA HABITACION, NOS LLEVA A LA VENTANA CALENDARIO PARA ELEGIR LOS DIAS DE ESTANCIA
				VentanaCalendario vc = new VentanaCalendario(cliente);
				
				Cliente nuevo;
				
				if (cliente != null) {
					nuevo = cliente;
				} else {
					nuevo = new Cliente();
				}
				
				int contador = 1;
				try {
					Scanner sc = new Scanner(new FileInputStream("Habitacion"));
					while(sc.hasNext()) {
						contador = contador + 1;
						String linea = sc.nextLine();
					}
					
				}catch(FileNotFoundException e1) {
					System.err.println("ERROR");
				}
				
				PrintWriter pw = null;
				try {
				    pw = new PrintWriter(new BufferedWriter(new FileWriter("Habitacion", true)));
				    pw.print("");
				    //DEPENDIENDO DE LA HABITACION QUE SELECCIONES, SE COBRARÁ MAS O MENOS POR NOCHE
				    if(comboHabitaciones.getSelectedItem().equals("VIP ---> 200€/noche")) {
				    	pw.println(contador + ";" + "VIP" + ";" + 200);
				    }else if(comboHabitaciones.getSelectedItem().equals("DOBLE ---> 100€/noche")) {
				    	pw.println(contador + ";" + "DOBLE" + ";" + 100);
				    }else if(comboHabitaciones.getSelectedItem().equals("INDIVIDUAL ---> 80€/noche")) {
				    	pw.println(contador + ";" + "INDIVIDUAL" + ";" + 80);
				    }else {
				    	pw.println(contador + ";" + "FAMILIAR" + ";" + 130);
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
		
		add(habitaciones);
		add(comboHabitaciones);
		add(elegir);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Elección habitación");
		setSize(800, 200);
		setVisible(true);
		
	}
	
}
