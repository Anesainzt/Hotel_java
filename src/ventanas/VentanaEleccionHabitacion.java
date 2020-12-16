package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
			    
				if(comboHabitaciones.getSelectedItem().equals("VIP ---> 200€/noche")){
					VentanaCalendario vc = new VentanaCalendario(cliente, 200, "VIP");
				}else if(comboHabitaciones.getSelectedItem().equals("DOBLE ---> 100€/noche")){
					VentanaCalendario vc = new VentanaCalendario(cliente, 100, "DOBLE");
				}else if(comboHabitaciones.getSelectedItem().equals("INDIVIDUAL ---> 80€/noche")){
					VentanaCalendario vc = new VentanaCalendario(cliente, 80, "INDIVIDUAL");
				}else{
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