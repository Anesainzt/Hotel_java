package ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;

import hotel.Cliente;

public class VentanaSeleccionHabitacion extends JFrame{
	
	JButton boton;
	
	
	public VentanaSeleccionHabitacion(Cliente cliente, int dinero, String tipo) {
		
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:hotelJava.db";
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = (Statement) conn.createStatement();
			
			ResultSet res1 = stmt.executeQuery("SELECT num_habitacion, libre FROM habitacion WHERE tipo = '"+ tipo +"'");
			while (res1.next()) {
				String numero = res1.getString("num_habitacion");
				int libre = res1.getInt("libre");
				boton = new JButton(numero);
				if (libre == 0) {
					boton.setBackground(Color.GREEN);
					boton.setEnabled(true);
					boton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							
						}
						
					});
				} else {
					boton.setBackground(Color.RED);
					boton.setEnabled(false);
					
				}
				
				add(boton);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("fechas"));
			bw.write(" ");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
