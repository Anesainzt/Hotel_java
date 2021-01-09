package ventanas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import hotel.Cliente;

public class VentanaSeleccionHabitacion extends JFrame{
	
	JButton boton;
	JButton vueltaHabitacion;
	JButton vueltaCalendario;

	static String fechaEntrada = null;
	static String fechaSalida = null;
	public VentanaSeleccionHabitacion(Cliente cliente, int dinero, String tipo) {
		
		JPanel habitaciones = new JPanel();
    	Border habitacionesBorder = BorderFactory.createTitledBorder("HABITACIONES");
    	habitaciones.setBorder(habitacionesBorder);
    	habitaciones.setLayout(new GridLayout(5, 5));
    	
    	Scanner sc2;
    	String linea1 = null;
    	String[] campos1 = null;
    	
		try {
			sc2 = new Scanner(new FileInputStream("fechas"));
			while(sc2.hasNext()) {
				 
				 linea1 = sc2.nextLine();
				 campos1 = linea1.split(";");
				 fechaSalida = campos1[1];
				 fechaEntrada = campos1[0];
				 
			 }
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 
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
							// TODO 
							
							try {
								int res2 = stmt.executeUpdate("INSERT INTO historialregistros VALUES('"+ fechaEntrada +"', '"+ fechaSalida +"', '"+ tipo +"', "+ Integer.parseInt(numero) +", '"+ cliente.getLogin() +"', 1);");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							VentanaServicios vs = new VentanaServicios(cliente);
							dispose();
						}
						
					});
				} else {
					boton.setBackground(Color.RED);
					boton.setEnabled(false);
					
				}
				
				habitaciones.add(boton);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ArrayList<String> nuevosDatos = new ArrayList<String>();
		String linea = null;
		String[] campos = null;
		String n = null;
		String a = null;
		String d = null;
		String nomHab = null;
		String precHab = null;
		String dias = null;
		
		try {
			Scanner sc1 = new Scanner(new FileInputStream("datosFactura.txt"));
			
			while(sc1.hasNext()) {
				linea = sc1.nextLine();
				campos = linea.split(";");
				nuevosDatos.add(linea);
				n = campos[0];
				a = campos[1];
				d = campos[2];
				nomHab = campos[3];
				precHab = campos[4];
				dias = campos[5];
			}
			
		}catch(FileNotFoundException e1) {
			System.err.println("ERROR");
		}finally{
			//borrar fichero

		}
		
		
		JPanel cambioEleccion = new JPanel();
    	Border cambioEleccionBorder = BorderFactory.createTitledBorder("CAMBIO ELECCION");
    	cambioEleccion.setBorder(cambioEleccionBorder);
    	cambioEleccion.setLayout(new GridLayout(2, 1));
		
		
		String textoHabitacion = n + ";" + a + ";" + d;
		
		vueltaHabitacion = new JButton("ELEGIR NUEVA HABITACION");
		
		vueltaHabitacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				
				PrintWriter pw = null;
				try {
				    pw = new PrintWriter(new BufferedWriter(new FileWriter("datosFactura.txt", true)));
				    pw.print(textoHabitacion);
				    
				} catch (IOException e1) {
				    System.err.println(e1);
				} finally {
				    if (pw != null) {
				        pw.close();
				    }
				}
				
				VentanaEleccionHabitacion veh = new VentanaEleccionHabitacion(cliente);
				
				dispose();
			}
			
		});
		
		String textoCalendario = textoHabitacion + ";" + nomHab + ";" + precHab;
		
		vueltaCalendario = new JButton("ELEGIR NUEVA FECHA");
		
		vueltaCalendario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PrintWriter pw = null;
				try {
				    pw = new PrintWriter(new BufferedWriter(new FileWriter("datosFactura.txt", true)));
				    pw.print(textoCalendario);
				    
				} catch (IOException e1) {
				    System.err.println(e1);
				} finally {
				    if (pw != null) {
				        pw.close();
				    }
				}
				
				VentanaCalendario vc = new VentanaCalendario(cliente, dinero, tipo);
				dispose();
			}
			
		});
		
		cambioEleccion.add(vueltaHabitacion);
		cambioEleccion.add(vueltaCalendario);
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(habitaciones);
		main.add(cambioEleccion);
		
		add(main);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro del cliente");
		setSize(1200, 500);
		setVisible(true);
		
	}
	
}
