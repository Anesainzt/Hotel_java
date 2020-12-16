package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;

import hotel.Cliente;

public class VentanaCreacionRegistro extends JFrame{
	JLabel nombre;
	JTextField n;
	JLabel apellidos;
	JTextField a;
	JLabel dni;
	JTextField d;
	JLabel tarjeta;
	JTextField t;
	JButton continuar;
	
	public VentanaCreacionRegistro(Cliente cliente) {
		
		setLayout(new GridLayout(5, 2));
		
		nombre = new JLabel("NOMBRE");
		n = new JTextField();
		apellidos = new JLabel("APELLIDOS");
		a = new JTextField();
		dni = new JLabel("DNI");
		d = new JTextField();
		tarjeta = new JLabel("TARJETA");
		t = new JTextField();
		continuar = new JButton("CONTINUAR");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente nuevo;
				
				if (cliente != null) {
					nuevo = cliente;
				} else {
					nuevo = new Cliente();
				}

				//SI LOS DATOS ESTAN VACIOS, NO TE DEJA CONTINUAR, DEBES RELLENAR TODOS LOS DATOS
				if(n.getText().length() == 0 || a.getText().length() == 0 || d.getText().length() == 0 || t.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "DEBES RELLENAR TODOS LOS DATOS");
					VentanaCreacionRegistro vr = new VentanaCreacionRegistro(cliente);
					dispose();
				}else {
					
					nuevo.setNombre(n.getText());
					nuevo.setApellido(a.getText());
					nuevo.setDni(d.getText());
					nuevo.setTarjeta(t.getText());
					VentanaEleccionHabitacion vcr = new VentanaEleccionHabitacion(nuevo);
					
					try {	
						Class.forName("org.sqlite.JDBC");
						String url = "jdbc:sqlite:hotelJava.db";
						Connection conn = DriverManager.getConnection(url);
						
						PreparedStatement pstmt = conn.prepareStatement("UPDATE cliente SET nombre = ?, apellido = ?, dni = ?, tarjeta = ? WHERE usuario = '"+ nuevo.getLogin() +"' AND contraseya = '"+ nuevo.getPassword() +"';");
						
						pstmt.setString(1, nuevo.getNombre());
						pstmt.setString(2, nuevo.getApellido());
						pstmt.setString(3, nuevo.getDni());
						pstmt.setString(4, nuevo.getTarjeta());
						pstmt.executeUpdate();
						conn.close();
					} catch (ClassNotFoundException e2) {
					 System.out.println("No se ha podido cargar el driver de la base de datos");
					} catch (SQLException e2) {
						System.out.println(e2.getMessage());
					} 	
						
					dispose();
					
				}
				
			}
		});
		
		add(nombre);
		add(n);
		add(apellidos);
		add(a);
		add(dni);
		add(d);
		add(tarjeta);
		add(t);
		add(continuar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro del cliente");
		setSize(800, 200);
		setVisible(true);
		
	}

}