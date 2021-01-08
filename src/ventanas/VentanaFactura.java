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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import hotel.Cliente;

public class VentanaFactura extends JFrame {
	
	public VentanaFactura(Cliente cliente) {
		
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
		
    	JLabel factura = new JLabel("FACTURA");
    	JLabel nom = new JLabel("    NOMBRE");
    	JLabel ape = new JLabel("    APELLIDO");
    	JLabel dn = new JLabel("    DNI");
    	
    	JLabel fac = new JLabel(" ");
    	JLabel nombre = new JLabel("    " + n);
		JLabel apellidos = new JLabel("    " + a);
		JLabel dni = new JLabel("    " + d);
    	
    	JPanel datosCliente = new JPanel();
    	Border datosClienteBorder = BorderFactory.createTitledBorder("CLIENTE");
    	datosCliente.setBorder(datosClienteBorder);
    	datosCliente.setLayout(new GridLayout(2, 4));
    	datosCliente.setBackground(Color.LIGHT_GRAY);
    	
    	datosCliente.add(factura);
    	datosCliente.add(nom);
    	datosCliente.add(ape);
    	datosCliente.add(dn);
    	
    	datosCliente.add(fac);
    	datosCliente.add(nombre);
    	datosCliente.add(apellidos);
    	datosCliente.add(dni);
    	
    	JLabel cantDias = new JLabel("     " + dias);
    	JLabel habitacion = new JLabel("    " + nomHab);
		JLabel precioHabitacion = new JLabel("    " + precHab);
		int diasEstancia = Integer.parseInt(dias);
		int precioHabitacion1 = Integer.parseInt(precHab);
		int t = diasEstancia*precioHabitacion1;
		JLabel precioTotHabitacion = new JLabel("    " + t);
    	
		JLabel cantidad = new JLabel("CANTIDAD");
    	JLabel productos = new JLabel("PRODUCTOS");
		JLabel precio = new JLabel("PRECIO");
		JLabel precioTotal = new JLabel("PRECIO TOTAL");
		
		JPanel datosHabitacion = new JPanel();
    	Border datosHabitacionBorder = BorderFactory.createTitledBorder("HABITACION");
    	datosHabitacion.setBorder(datosHabitacionBorder);
    	datosHabitacion.setLayout(new GridLayout(2, 4));
    	datosHabitacion.setBackground(Color.LIGHT_GRAY);
    	
    	datosHabitacion.add(cantidad);
    	datosHabitacion.add(productos);
    	datosHabitacion.add(precio);
    	datosHabitacion.add(precioTotal);
    	
    	datosHabitacion.add(cantDias);
    	datosHabitacion.add(habitacion);
    	datosHabitacion.add(precioHabitacion);
    	datosHabitacion.add(precioTotHabitacion);
    	
    	HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap = cliente.getHashmap();
    	
		ArrayList<String> comida = new ArrayList<String>();
		ArrayList<String> deporte = new ArrayList<String>();
		ArrayList<String> miniBar = new ArrayList<String>();
		ArrayList<String> salaReunion = new ArrayList<String>();
		ArrayList<String> spa = new ArrayList<String>();
		
		int precComida = 0;
		int precDeporte = 0;
		int precMiniBar = 0;
		int precSalaReunion = 0;
		int precSpa = 0;
		
		for (Entry<String, Integer> entry : hashmap.entrySet()) {
            if(entry.getKey().equals("MASAJE FACIAL") || entry.getKey().equals("MASAJE CORPORAL") || entry.getKey().equals("MASAJE TOTAL") || entry.getKey().equals("JACUZZI") || entry.getKey().equals("SALES MINERALES") || entry.getKey().equals("MASAJE PIEDRAS") || entry.getKey().equals("TRATAMIENTO ESTÉTICO")) {
            	spa.add(entry.getKey());
            	precSpa += entry.getValue();
            }else if(entry.getKey().equals("SALA CONVENCION") || entry.getKey().equals("SALA JUNTA") || entry.getKey().equals("SALA PETIT COMITÉ") || entry.getKey().equals("SALA CONVENCION EQUIPADA") || entry.getKey().equals("SALA JUNTA EQUIPADA") || entry.getKey().equals("SALA PETIT COMITÉ EQUIPADA")) {
            	salaReunion.add(entry.getKey());
            	precSalaReunion += entry.getValue();
            }else if(entry.getKey().equals("VODKA") || entry.getKey().equals("GINEBRA") || entry.getKey().equals("WHISKEY") || entry.getKey().equals("TEQUILA") || entry.getKey().equals("RON") || entry.getKey().equals("ELECCION DE DOS") || entry.getKey().equals("ELECCION DE TRES") || entry.getKey().equals("TODOS")) {
            	miniBar.add(entry.getKey());
            	precMiniBar += entry.getValue();
            }else if(entry.getKey().equals("MCDONALDS") || entry.getKey().equals("BURGER KING") || entry.getKey().equals("FOSTERS HOLLYWOOD") || entry.getKey().equals("POMODORO") || entry.getKey().equals("FOODOO") || entry.getKey().equals("DONGA") || entry.getKey().equals("MENU DEL DIA HOTEL") || entry.getKey().equals("BUFFET HOTEL")) {
            	comida.add(entry.getKey());
            	precComida += entry.getValue();
            }else{
            	deporte.add(entry.getKey());
            	precDeporte += entry.getValue();
            }
        }
    	
        JLabel cantidadComida = new JLabel("" + comida.size());
        JLabel cantidadDeporte = new JLabel("" + deporte.size());
        JLabel cantidadMiniBar = new JLabel("" + miniBar.size());
        JLabel cantidadSalaReunion = new JLabel("" + salaReunion.size());
        JLabel cantidadSpa = new JLabel("" + spa.size());
        
        JLabel descripcionComida = new JLabel("COMIDA");
        JLabel descripcionDeporte = new JLabel("DEPORTE");
        JLabel descripcionMiniBar = new JLabel("MINI BAR");
        JLabel descripcionSalaReunion = new JLabel("SALA REUNION");
        JLabel descripcionSpa = new JLabel("SPA");
        
        JLabel pComida = new JLabel("" + precComida);
        JLabel pDeporte = new JLabel("" + precDeporte);
        JLabel pMiniBar = new JLabel("" + precMiniBar);
        JLabel pSalaReunion = new JLabel("" + precSalaReunion);
        JLabel pSpa = new JLabel("" + precSpa);
        
    	JPanel datosServiciosExtra = new JPanel();
    	Border datosServiciosExtraBorder = BorderFactory.createTitledBorder("SERVICIOS");
    	datosServiciosExtra.setBorder(datosServiciosExtraBorder);
    	datosServiciosExtra.setBackground(Color.WHITE);
    	datosServiciosExtra.setLayout(new GridLayout(6, 3));
    	
    	datosServiciosExtra.add(cantidad);
    	datosServiciosExtra.add(productos);
    	datosServiciosExtra.add(precio);
    	
    	datosServiciosExtra.add(cantidadComida);
    	datosServiciosExtra.add(descripcionComida);
    	datosServiciosExtra.add(pComida);
    	
    	datosServiciosExtra.add(cantidadDeporte);
    	datosServiciosExtra.add(descripcionDeporte);
    	datosServiciosExtra.add(pDeporte);
    	
    	datosServiciosExtra.add(cantidadMiniBar);
    	datosServiciosExtra.add(descripcionMiniBar);
    	datosServiciosExtra.add(pMiniBar);
    	
    	datosServiciosExtra.add(cantidadSalaReunion);
    	datosServiciosExtra.add(descripcionSalaReunion);
    	datosServiciosExtra.add(pSalaReunion);
    	
    	datosServiciosExtra.add(cantidadSpa);
    	datosServiciosExtra.add(descripcionSpa);
    	datosServiciosExtra.add(pSpa);
    	
		int precioSalida = precioHabitacion1* diasEstancia + precComida + precDeporte + precMiniBar + precSalaReunion + precSpa;
    	JLabel total = new JLabel("PRECIO TOTAL: " + precioSalida);
    	
    	JButton salir = new JButton("SALIR");
		
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
    	JPanel main = new JPanel();
    	main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(datosCliente);
		main.add(datosHabitacion);
		main.add(datosServiciosExtra);
		main.add(total);
		main.add(salir);	

		add(main);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Factura");
		pack();
		setVisible(true);
	}
		
}
