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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import hotel.BD;
import hotel.BDException;
import hotel.Cliente;

public class VentanaSeleccionHabitacion extends JFrame{
	
	JButton boton;
	JButton vueltaHabitacion;
	JButton vueltaCalendario;
	
	BD bd;

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
    	//LEEMOS LAS FECHAS OBTENIDAS EN LA VENTANA CALENDARIO
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
		//CONECTAMOS LA BASE DE DATOS
		bd = new BD();
		try {
			bd.connect();
		} catch (BDException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//ELEGIMOS LA HABITACION QUE QUEREMOS Y LA GUARDAMOS
		List <JButton> b = bd.habitacion(boton, fechaEntrada, fechaSalida, tipo, habitaciones, cliente);
		for(JButton bu: b ) {
			if(bu.getBackground() == Color.GREEN) {
				bu.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//ESCRIBIMOS EL NUMERO DE HABITACION EN EL FICHERO
						bd.escribirFichero("baseDeDatos", fechaEntrada + ";" + fechaSalida + ";" + tipo + ";" + bu.getText());
						VentanaServicios vs = new VentanaServicios(cliente);
						dispose();
					}
				});
			}
			boton = bu;
			habitaciones.add(boton);
		}
		//LEEMOS EL FICHERO CON LOS DATOS
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
		
		//SI ELEGIMOS OTRA HABITACION, GUARDAMOS LOS DATOS DE LA NUEVA HABITACION
		String textoHabitacion = n + ";" + a + ";" + d;
		
		vueltaHabitacion = new JButton("ELEGIR NUEVA HABITACION");
		
		vueltaHabitacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				//ESCRIBIMOS LA NUEVA INFORMACION EN EL FICHERO
				bd.escribirFichero("datosFactura.txt", textoHabitacion);
				VentanaEleccionHabitacion veh = new VentanaEleccionHabitacion(cliente);
				bd.restartHabitacion();
				dispose();
			}
			
		});
		//SI ELEGIMOS OTRA FECHA, GUARDAMOS LOS DATOS CON LAS NUEVAS FECHAS
		String textoCalendario = textoHabitacion + ";" + nomHab + ";" + precHab;
		
		vueltaCalendario = new JButton("ELEGIR NUEVA FECHA");
		
		vueltaCalendario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ESCRIBIMOS LA NUEVA INFORMACION EN LOS FICHEROS
				bd.escribirFichero("datosFactura.txt", textoCalendario);
				VentanaCalendario vc = new VentanaCalendario(cliente, dinero, tipo);
				bd.restartHabitacion();
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