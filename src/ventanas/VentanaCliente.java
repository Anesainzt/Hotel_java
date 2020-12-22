package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import hotel.*;

public class VentanaCliente extends JFrame{
	
	JButton historial;
	JButton nuevaReserva;
	JPanel inicio;
	JButton salir;
	JPanel reservas;
	Integer filas;
	
	public VentanaCliente(Cliente cliente) {
		
		inicio = new JPanel();
		reservas = new JPanel();
		historial = new JButton("HISTORAIL DE RESERVA");
		salir = new JButton("SALIR");
		nuevaReserva = new JButton("NUEVA RESERVA");
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:hotelJava.db";
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = (Statement) conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT COUNT('usuario') numero FROM habitacion WHERE usuario = '"+ cliente.getLogin() +"'");
			
			while (rs.next()) {
				filas = rs.getInt("numero");	
				System.out.println(filas);
			}
			String[][] datos = new String[filas][5];
			conn.close();
		}catch (ClassNotFoundException e2) {
			System.out.println("No se ha podido cargar el driver de la base de datos");
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		} 
			
			
		historial.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		
		nuevaReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaEleccionHabitacion veh = new VentanaEleccionHabitacion(cliente);			
			}
		});
		
		inicio.add(historial);
		inicio.add(nuevaReserva);
		inicio.add(salir);
		
		add(inicio);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Identificación del cliente");
		inicio.setSize(800, 200);
		setVisible(true);
		reservas.setVisible(true);
		
		
	}
	
}