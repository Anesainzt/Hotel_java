package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import hotel.*;

public class VentanaCliente extends JFrame{
	
	JButton historial;
	JButton nuevaReserva;
	JButton salir;
	JButton newServicio;
	JTable historia;
	DefaultTableModel modelo;
	JPanel panelBotones;
	JPanel panelTabla;
	JPanel main;
	JScrollPane scroll;
	BD bd;

	
	public VentanaCliente(Cliente cliente) { 
		
		
		panelBotones = new JPanel();
		panelTabla = new JPanel();
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
				bd.connect();
				//MIRAMOS EL HISTORIAL
				bd.historial(cliente, modelo);
				//LO HACEMOS VISIBLE
				historia.setVisible(true);
				historial.setVisible(false);
				main.add(panelTabla);
				setSize(600, 500);
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
		
		//LE DAMOS LA OPORTUNIDAD DE ELEGIR SERVICIOS EN HABITACIONES YA RESERVADAS
		newServicio = new JButton("NUEVO SERVICIO");
		
		newServicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				VentanaNuevoServicio ven = new VentanaNuevoServicio(cliente);
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
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		panelBotones.add(historial);
		panelBotones.add(nuevaReserva);
		panelBotones.add(newServicio);
		panelBotones.add(salir);
		panelTabla.add(scroll);
		main.add(panelBotones);
		add(main);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Identificación del cliente");
		setSize(600, 100);
		setVisible(true);
		historia.setVisible(false);
	}
}