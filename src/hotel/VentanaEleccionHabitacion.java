package hotel;

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

public class VentanaEleccionHabitacion extends JFrame{

	JComboBox<String> comboHabitaciones;
	JLabel habitaciones;
	JButton elegir;
	
	public VentanaEleccionHabitacion(Cliente cliente) {
		
		setLayout(new GridLayout(3, 1));
		
		comboHabitaciones = new JComboBox<String>();
		
		habitaciones = new JLabel("HABITACIONES: ");
		elegir = new JButton("ELEGIR HABITACION");
		
		comboHabitaciones.addItem("VIP ---> 200�/noche");
		comboHabitaciones.addItem("DOBLE ---> 100�/noche");
		comboHabitaciones.addItem("INDIVIDUAL ---> 80�/noche");
		comboHabitaciones.addItem("FAMILIAR ---> 130�/noche");
		
		
		elegir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaServicios vs = new VentanaServicios(cliente);
				
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
				    pw.println(contador + ";" + comboHabitaciones.getSelectedItem());
				} catch (IOException e1) {
				    System.err.println(e1);
				} finally {
				    if (pw != null) {
				        pw.close();
				    }
				}
				
			}
		});
		
		add(habitaciones);
		add(comboHabitaciones);
		add(elegir);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Elecci�n habitaci�n");
		setSize(800, 200);
		setVisible(true);
		
	}
	
}

