package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hotel.Cliente;

public class VentanaFactura extends JFrame {	
	
	JLabel factura;
	JLabel nombre;
	JLabel apellidos;
	JLabel dni;
	
	JLabel cantidad;
	JLabel productos;
	JLabel precio;
	JLabel precioTotal;
	
	JLabel cantDias;
	JLabel habitacion;
	JLabel precioHabitacion;
	JLabel precioTotHabitacion;
	
	JLabel cantComida;
	JLabel servicioComida;
	JLabel precioComida;
	JLabel precioTotComida;
	
	JLabel cantSpa;
	JLabel servicioSpa;
	JLabel precioSpa;
	JLabel precioTotSpa;
	
	JLabel cantDeporte;
	JLabel servicioDeporte;
	JLabel precioDeporte;
	JLabel precioTotDeporte;
	
	JLabel cantMiniBar;
	JLabel servicioMiniBar;
	JLabel precioMiniBar;
	JLabel precioTotMiniBar;
	
	JLabel cantSala;
	JLabel servicioSalaReunion;
	JLabel precioSala;
	JLabel precioTotSala;
	
	JLabel subtotal;
	JLabel iva;
	JLabel total;
	JButton salir;
	
	public VentanaFactura(Cliente cliente) {
		
		setLayout(new GridLayout(9, 4));
		
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
		
		factura = new JLabel("     FACTURA");
		nombre = new JLabel(n);
		apellidos = new JLabel(a);
		dni = new JLabel(d);
		
		cantidad = new JLabel("     CANTIDAD");
		productos = new JLabel("PRODUCTOS");
		precio = new JLabel("PRECIO");
		precioTotal = new JLabel("PRECIO TOTAL");
		
		cantDias = new JLabel("     "+dias);
		habitacion = new JLabel(nomHab);
		precioHabitacion = new JLabel(precHab);
		int diasEstancia = Integer.parseInt(dias);
		int precioHabitacion1 = Integer.parseInt(precHab);
		precioTotHabitacion = new JLabel("" + diasEstancia*precioHabitacion1);
		
		cantComida = new JLabel("     11");
		servicioComida = new JLabel("SERVICIO COMIDA");
		precioComida = new JLabel("     12");
		precioTotComida = new JLabel("     13");
		
		cantSpa = new JLabel("     21");
		servicioSpa = new JLabel("SERVICIO SPA");
		precioSpa = new JLabel("     22");
		precioTotSpa = new JLabel("     23");
		
		cantDeporte = new JLabel("     31");
		servicioDeporte = new JLabel("SERVICIO DEPORTE");
		precioDeporte = new JLabel("     32");
		precioTotDeporte = new JLabel("     33");
		
		cantMiniBar = new JLabel("     41");
		servicioMiniBar = new JLabel("SERVICIO MINI-BAR");
		precioMiniBar = new JLabel("     42");
		precioTotMiniBar = new JLabel("     43");
		
		cantSala = new JLabel("     51");
		servicioSalaReunion = new JLabel("SERVICIO SALA REUNION");
		precioSala = new JLabel("     52");
		precioTotSala = new JLabel("     53");
		
		subtotal = new JLabel("     " + diasEstancia*precioHabitacion1);
		iva = new JLabel("     " + diasEstancia*precioHabitacion1);
		total = new JLabel("     " + diasEstancia*precioHabitacion1);	
		salir = new JButton("SALIR");
		
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		

		add(factura);
		add(nombre);
		add(apellidos);
		add(dni);
		
		add(cantidad);
		add(productos);
		add(precio);
		add(precioTotal);
		
		add(cantDias);
		add(habitacion);
		add(precioHabitacion);
		add(precioTotHabitacion);
		
		add(cantComida);
		add(servicioComida);
		add(precioComida);
		add(precioTotComida);
		
		add(cantSpa);
		add(servicioSpa);
		add(precioSpa);
		add(precioTotSpa);
		
		add(cantDeporte);
		add(servicioDeporte);
		add(precioDeporte);
		add(precioTotDeporte);
		
		add(cantMiniBar);
		add(servicioMiniBar);
		add(precioMiniBar);
		add(precioTotMiniBar);
		
		add(cantSala);
		add(servicioSalaReunion);
		add(precioSala);
		add(precioTotSala);
		
		
		add(subtotal);
		add(iva);
		add(total);
		add(salir);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Factura");
		pack();
		setVisible(true);
    	
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("datosFactura.txt"));
			bw.write(" ");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
