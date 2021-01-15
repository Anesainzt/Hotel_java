package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import hotel.*;

public class VentanaCliente extends JFrame{
	
	JButton historial;
	JButton nuevaReserva;
	JButton salir;
	JTable historia;
	DefaultTableModel modelo;
	JPanel panel;
	JScrollPane scroll;
	BD bd;
	
	public VentanaCliente(Cliente cliente) { 
		
		setLayout(new GridLayout(2,2));
		
		panel = new JPanel();
		historial = new JButton("HISTORIAL DE RESERVA");
		salir = new JButton("SALIR");
		nuevaReserva = new JButton("NUEVA RESERVA");
		historia = new JTable();
		scroll = new JScrollPane(historia);
		modelo = (DefaultTableModel)historia.getModel();
		modelo.addColumn("Entrada");
		modelo.addColumn("Salida");
		modelo.addColumn("Tipo de habitacion");
		
		//MUESTRA EL HISTORIAL DE LAS FECHAS Y LA HABITACION EN LAS QUE SE HA QUEDADO EN OTRAS OCASIONES
		historial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//NOS CONECTAMOS A LA BASE DE DATOS
				bd = new BD();
				try {
					bd.connect();
				} catch (BDException e) {
					e.printStackTrace();
				}
				//MIRAMOS EL HISTORIAL
				bd.historial(cliente, modelo);
				//LO HACEMOS VISIBLE
				historia.setVisible(true);
				historial.setVisible(false);
				
			}
		});
		//LE LLEVAMOS A LA VENTANA DE ELECCION HABITACION PARA QUE HAGA UNA NUEVA RESERVA
		nuevaReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaEleccionHabitacion veh = new VentanaEleccionHabitacion(cliente);			
				dispose();
			}
		});
		//SI SOLO QUIERE VER SU HISTORIAL Y NADA MAS, PUEDE DARLE A SALIR Y TERMINAR
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		add(historial);
		add(nuevaReserva);
		add(salir);
		add(scroll);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Identificación del cliente");
		setSize(800, 200);
		setVisible(true);
		historia.setVisible(false);
	}
}