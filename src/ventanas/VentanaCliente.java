package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
	
	public VentanaCliente(Cliente cliente) { 
		
		setLayout(new GridLayout(2,2));
		
		panel = new JPanel();
		historial = new JButton("HISTORAIL DE RESERVA");
		salir = new JButton("SALIR");
		nuevaReserva = new JButton("NUEVA RESERVA");
		historia = new JTable();
		modelo = (DefaultTableModel)historia.getModel();
		modelo.addColumn("Entrada");
		modelo.addColumn("Salida");
		modelo.addColumn("Tipo de habitacion");
		
		historial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try {	
					Class.forName("org.sqlite.JDBC");
					String url = "jdbc:sqlite:hotelJava.db";
					Connection conn = DriverManager.getConnection(url);
					Statement stmt = (Statement) conn.createStatement();
					Integer numFilas = 0 ;
					ResultSet res1 = stmt.executeQuery("SELECT COUNT(usuario) numero FROM historialregistros WHERE usuario = '"+ cliente.getLogin() +"'");
					
					while (res1.next()) {
						numFilas = res1.getInt("numero");
					}
					
					String [] tabla = new String[3];
					
					
					int i = 0;
					ResultSet res2 = stmt.executeQuery("SELECT fechaEntrada, fechaSalida, tipo FROM historialregistros WHERE usuario = '"+ cliente.getLogin() +"'");
					while(res2.next()) {
						
						String fila = res2.getString("fechaEntrada");
						tabla[0] = fila;
						fila = res2.getString("fechaSalida");
						tabla[1] = fila;
						fila = res2.getString("tipo");
						tabla[2] = fila;
						modelo.addRow(tabla);
						if (i != numFilas) {
							i = i + 1;
						}
					}
					
					
					historia.setVisible(true);
					
					historial.setVisible(false);
					
					conn.close();
				} catch (ClassNotFoundException e2) {
					System.out.println("No se ha podido cargar el driver de la base de datos");
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				}
				
				
				
			}
		});
		
		nuevaReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaEleccionHabitacion veh = new VentanaEleccionHabitacion(cliente);			
				dispose();
			}
		});
		
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				dispose();
			}
		});
		
		
		add(historial);
		add(nuevaReserva);
		add(salir);
		add(historia);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Identificación del cliente");
		setSize(800, 200);
		setVisible(true);
		historia.setVisible(false);
		
		
		
	}
	
}