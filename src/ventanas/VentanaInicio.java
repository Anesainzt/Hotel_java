package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import hotel.*;

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
		
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("fechas"));
			bw.write(" ");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedWriter bw0;
		try {
			bw0 = new BufferedWriter(new FileWriter("baseDeDatos"));
			bw0.write(" ");
			bw0.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedWriter bw1;
		try {
			bw1 = new BufferedWriter(new FileWriter("datosFactura.txt"));
			bw1.write(" ");
			bw1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
				Cliente cl = new Cliente();
				Empleado emp = new Empleado();
				char[] arrayC = p.getPassword();
				String password = new String(arrayC);
				
		        //EN CASO DE QUE SEA EMPLEADO
				try {	
					Class.forName("org.sqlite.JDBC");
					String url = "jdbc:sqlite:hotelJava.db";
					Connection conn = DriverManager.getConnection(url);
					Statement stmt = (Statement) conn.createStatement();
					
					ResultSet empleado = stmt.executeQuery("SELECT nombre, apellido, contraseya, usuario FROM empleado WHERE (usuario = '" + u.getText() + "' AND contraseya = '"+ password +"');");
					
					while(empleado.next()) {						
						String nombreBD = empleado.getString("nombre");
						String apellidoBD = empleado.getString("apellido");
						String contraseya = empleado.getString("contraseya");
						String usuario = empleado.getString("usuario");
						
						emp.setNombre(nombreBD);
						emp.setApellido(apellidoBD);
						emp.setPassword(contraseya);
						emp.setUsuario(usuario);
						
					}

				conn.close();
				} catch (ClassNotFoundException e2) {
				 System.out.println("No se ha podido cargar el driver de la base de datos");
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				} 
				
				//EN CASO DE QUE SEA CLIENTE
				try {	
					Class.forName("org.sqlite.JDBC");
					String url = "jdbc:sqlite:hotelJava.db";
					Connection conn = DriverManager.getConnection(url);
					Statement stmt = (Statement) conn.createStatement();
					
					ResultSet cliente = stmt.executeQuery("SELECT nombre, apellido, dni, contraseya, usuario FROM cliente WHERE (usuario = '" + u.getText() + "' AND contraseya = '"+ password +"');");
					while(cliente.next()) {
						String nombreBD = cliente.getString("nombre");
						String apellidoBD = cliente.getString("apellido");
						String dniBD = cliente.getString("dni");
						String contraseya = cliente.getString("contraseya");
						String usuario = cliente.getString("usuario");
						
						cl.setNombre(nombreBD);
						cl.setApellido(apellidoBD);
						cl.setDni(dniBD);
						cl.setPassword(contraseya);
						cl.setLogin(usuario);
						
					}
					
				conn.close();
				} catch (ClassNotFoundException e2) {
				 System.out.println("No se ha podido cargar el driver de la base de datos");
				} catch (SQLException e2) {
					System.out.println(e2.getMessage());
				} 
				
				
				
				if(cl.getLogin().equals(u.getText()) && cl.getLogin() != "") {	
					PrintWriter pw = null;
					try {
						String sep = File.separator;
					    pw = new PrintWriter(new BufferedWriter(new FileWriter("datosFactura.txt", true)));
					    pw.print(cl.getNombre() + ";" + cl.getApellido() + ";" + cl.getDni());
					    
					} catch (IOException e1) {
					    System.err.println(e1);
					} finally {
					    if (pw != null) {
					        pw.close();
					    }
					}
					VentanaCliente vc = new VentanaCliente(cl);

				} else if (emp.getUsuario().equals(u.getText()) && emp.getUsuario() != "") {
					VentanaEmpleado ve = new VentanaEmpleado(emp);

				} else {
					JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTO, PRUEBE OTRA VEZ");
					VentanaInicio vi = new VentanaInicio();
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
