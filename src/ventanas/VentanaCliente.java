package ventanas;

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
	JTable tabla;
	DefaultTableModel modelo;
	
	
	public VentanaCliente(Cliente cliente) {
		
		setLayout(new GridLayout(3, 2));
		
		historial = new JButton("HISTORAIL DE RESERVA");
		salir = new JButton("SALIR");
		nuevaReserva = new JButton("NUEVA RESERVA");
		tabla = new JTable();
		modelo = (DefaultTableModel)tabla.getModel();
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
					ResultSet res1 = stmt.executeQuery("SELECT COUNT(usuario) numero FROM habitacion WHERE usuario = '"+ cliente.getLogin() +"'");
					
					while (res1.next()) {
						numFilas = res1.getInt("numero");
					}
					
					String [][] fila = new String[numFilas][3];
					
					
					
					ResultSet res2 = stmt.executeQuery("SELECT fechaEntrada, fechaSalida, tipo FROM habitacion WHERE usuario = '"+ cliente.getLogin() +"'");
					while(res2.next()) {
						for (int i = 0; i < fila.length; i++) {
							DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
							fila[i][0] = dateFormat.format(res2.getDate("fechaEntrada"));
							fila[i][1] = dateFormat.format(res2.getDate("fechaSalida"));
							fila[i][2] = res2.getString("tipo");
							modelo.addRow(fila);
						}
						
					}
					tabla.setVisible(true);
					
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
		add(tabla);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Identificación del cliente");
		setSize(800, 200);
		setVisible(true);
		tabla.setVisible(false);
		
		
		
	}
	
}