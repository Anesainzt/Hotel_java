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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import hotel.Cliente;

public class VentanaSeleccionHabitacion extends JFrame{
	
	JButton boton;
	JButton vueltaHabitacion;
	JButton vueltaCalendario;
	JButton continuarServicios;
	
	public VentanaSeleccionHabitacion(Cliente cliente, int dinero, String tipo) {
		
		setLayout(new GridLayout(3, 1));
		
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
		
		String textoFichero = textoCalendario + ";" + dias;
		
		continuarServicios = new JButton("CONTINUAR");
		
		continuarServicios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PrintWriter pw = null;
				try {
				    pw = new PrintWriter(new BufferedWriter(new FileWriter("datosFactura.txt", true)));
				    pw.print(textoFichero);
				    
				} catch (IOException e1) {
				    System.err.println(e1);
				} finally {
				    if (pw != null) {
				        pw.close();
				    }
				}
				
				VentanaServicios vs = new VentanaServicios(cliente);
				dispose();
			}
			
		});
		
		add(vueltaHabitacion);
		add(vueltaCalendario);
		add(continuarServicios);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro del cliente");
		setSize(800, 200);
		setVisible(true);
		
	}
	
}
