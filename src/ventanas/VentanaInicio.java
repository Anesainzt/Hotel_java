package ventanas;

import java.awt.*; 
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

import hotel.*;

public class VentanaInicio extends JFrame{
	
	JLabel usuario;
	JTextField u;
	JLabel password;
	JTextField p;
	JButton registro;
	JButton continuar;
	Cliente cliente;
	
	public VentanaInicio() {
		
		setLayout(new GridLayout(3, 1));
		
		usuario = new JLabel("USUARIO");
		u = new JTextField();
		password = new JLabel("CONTRASEÑA");
		p = new JTextField();
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
					
					Cliente cliente = new Cliente();
					Empleado empleado = new Empleado();
					Cliente clienteVacio = new Cliente();
					Empleado empleadoVacio = new Empleado();
					
					//EN CASO DE QUE EL USUARIO CORRESPONDA A UN EMPLEADO
					ResultSet emp = stmt.executeQuery("SELECT nombre, apellido, contraseya, usuario FROM empleado WHERE (usuario = '" + u.getText() + "' AND contraseya = '"+ p.getText() +"');");
					
					while(emp.next()) {
						String nombreBD = emp.getString("nombre");
						String apellidoBD = emp.getString("apellido");
						String contraseya = emp.getString("contraseya");
						String usuario = emp.getString("usuario");
						
						empleado.setNombre(nombreBD);
						empleado.setApellido(apellidoBD);
						empleado.setPassword(contraseya);
						empleado.setUsuario(usuario);
						
					}
					
					//EN CASO DE QUE EL USUARIO CORRESPONDA A UN CLIENTE QUE HAYA VENIDO ANTERIOR MENTE
					ResultSet cl = stmt.executeQuery("SELECT nombre, apellido, contraseya, usuario FROM cliente WHERE (usuario = '" + u.getText() + "' AND contraseya = '"+ p.getText() +"');");
					while(cl.next()) {
						String nombreBD = cl.getString("nombre");
						String apellidoBD = cl.getString("apellido");
						String contraseya = emp.getString("contraseya");
						String usuario = emp.getString("usuario");
						
						cliente.setNombre(nombreBD);
						cliente.setApellido(apellidoBD);
						cliente.setPassword(contraseya);
						cliente.setLogin(usuario);
					}
										
					if(cliente.getLogin() != "") {
						VentanaCliente vnc = new VentanaCliente(cliente);
						System.out.println("5");
					} else if (empleado.getUsuario() != "") {
						VentanaEmpleado vnm = new VentanaEmpleado(empleado);
						System.out.println("empleado");
					} else {
						JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO, PRUEBE OTRA VEZ");
						VentanaInicio vn = new VentanaInicio();
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
