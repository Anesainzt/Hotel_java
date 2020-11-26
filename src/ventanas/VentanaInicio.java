package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.JButton;

import com.toedter.calendar.JCalendar;

import hotel.Cliente;

public class VentanaInicio extends JFrame{
	
	JLabel usuario;
	JTextField u;
	JLabel password;
	JPasswordField p;
	JButton registro;
	JButton continuar;
	Cliente cliente;
	
	public VentanaInicio() {
		
		setLayout(new GridLayout(3, 1));
		
		usuario = new JLabel("USUARIO");
		u = new JTextField();
		password = new JLabel("CONTRASEÑA");
		p = new JPasswordField();
		registro = new JButton("REGISTRARSE");
		continuar = new JButton("CONTINUAR");
		
		//EL BOTON REGISTRO TE LLEVA A LA VENTANA REGISTRO PARA RECOGER TUS DATOS DE REGISTRO
		registro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro vr = new VentanaRegistro(cliente);
				dispose();
			}
		});
		
		//Cargamos los drivers de la base de datos
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {	
					Class.forName("org.sqlite.JDBC");
					String url = "jdbc:sqlite:hotelJava.db";
					Connection conn = DriverManager.getConnection(url);
					Statement stmt = (Statement) conn.createStatement();
		
					ResultSet emp = stmt.executeQuery("SELECT * FROM empleado WHERE (usuario = '" + u.getText() + "' AND contraseya = '"+ p.getText() +"');");
					//Detectamos si la persona que ha accedido a su cuenta es un cliente con cuenta o un empleado
					//Aparte también obtenemos su nombre y apellido
					while(emp.next()) {
						String nombreBD = emp.getString("nombre");
						String apellidoBD = emp.getString("apellido");
						String tipo = emp.getString("tipo");
						System.out.println(nombreBD);
						System.out.println(apellidoBD);
						System.out.println(tipo);
					}
					ResultSet cl = stmt.executeQuery("SELECT * FROM cliente WHERE (usuario = '" + u.getText() + "' AND contraseya = '"+ p.getText() +"');");
					while(cl.next()) {
						String nombreBD = cl.getString("nombre");
						String apellidoBD = cl.getString("apellido");
						String tipo = cl.getString("tipo");
						System.out.println(nombreBD);
						System.out.println(apellidoBD);
						System.out.println(tipo);
					}
					conn.close();
					} catch (ClassNotFoundException e2) {
					 System.out.println("No se ha podido cargar el driver de la base de datos");
					} catch (SQLException e2) {
						System.out.println(e2.getMessage());
					}	
				dispose();
			}
		});
		
		add(usuario);
		add(u);
		add(password);
		add(p);
		add(registro);
		add(continuar);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Identificación del cliente");
		setSize(800, 200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		VentanaInicio vi = new VentanaInicio();
		
	}

}
