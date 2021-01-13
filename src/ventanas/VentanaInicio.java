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
	
	//METODO PARA LIMPIAR LOS FICHEROS ANTES DE VOLVER A ESCRIBIR EN ELLOS
	public void limpiezaDeFicheros(String fichero) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(fichero));
			bw.write(" ");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public VentanaInicio() {
		
		setLayout(new GridLayout(3, 1));
		
		usuario = new JLabel("USUARIO");
		u = new JTextField();
		password = new JLabel("CONTRASEÑA");
		p = new JPasswordField();
		registro = new JButton("REGISTRARSE");
		continuar = new JButton("CONTINUAR");
		//LIMPIAMOS LOS FICHEROS
		limpiezaDeFicheros("fechas");
		limpiezaDeFicheros("baseDeDatos");
		limpiezaDeFicheros("datosFactura.txt");
		
		//EL BOTON REGISTRO TE LLEVA A LA VENTANA REGISTRO PARA RECOGER TUS DATOS DE REGISTRO
		registro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro vr = new VentanaRegistro(cliente);
				dispose();
			}
		});
		
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cl = new Cliente();
				Empleado emp = new Empleado();
				char[] arrayC = p.getPassword();
				String password = new String(arrayC);
				//CONECTAMOS LA BASE DE DATOS
				BD bd = new BD();
				try {
					bd.connect();
				} catch (BDException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        //EN CASO DE QUE SEA EMPLEADO
				emp = bd.empleado(u.getText(), password);
				//EN CASO DE QUE SEA CLIENTE
				cl = bd.cliente(u.getText(), password);
				
				//EN CASO DE QUE SEA CLIENTE, ESCRIBIMOS SUS DATOS EN EL FICHERO PARA UTILIZARLOS MAS TARDE
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
					//LE LLEVAMOS A VENTANA CLIENTE
					VentanaCliente vc = new VentanaCliente(cl);
				//EN CASO DE SER EMPLEADO LE LLEVAMOS A VENTANA EMPLEADO
				} else if (emp.getUsuario().equals(u.getText()) && emp.getUsuario() != "") {
					VentanaEmpleado ve = new VentanaEmpleado(emp);
				//SI NO CORRESPONDE CON NINGUNA, O SE HA EQUIVOCADO AL ESCRIBIR O DEBE REGISTRARSE
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

}
