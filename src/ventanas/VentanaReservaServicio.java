package ventanas;
import javax.swing.*;

import com.toedter.calendar.JCalendar;

import hotel.BD;
import hotel.BDException;
import hotel.Cliente;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class VentanaReservaServicio extends JFrame{
	
	BD bd;
	
	JCalendar calendario;
	JTextField fecha;
	JButton fechaSeleccion;
	Date d1;
	Date d2;
	Date hoy;
	String fechaRegistro;
	
	public VentanaReservaServicio(Cliente cliente, int precio, String tipo) {			
		Cliente nuevo = cliente;
		bd = new BD();
		try {
			bd.connect();
		} catch (BDException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
		hashmap = cliente.getHashmap();
		hashmap.put(tipo, precio);
			
		nuevo.setHashmap(hashmap);
		
		setLayout(new GridLayout(2, 1));
		
		calendario = new JCalendar();
		fecha = new JTextField(30);
		fechaSeleccion = new JButton("Fecha eleccion");
		
		ArrayList<String> nuevosDatos = new ArrayList<String>();
		String linea = null;
		String[] campos = null;
		String fechaInicio = null;
		String fechaFin = null;
    	
    	try {
			Scanner sc1 = new Scanner(new FileInputStream("fechas"));
			
			while(sc1.hasNext()) {
				linea = sc1.nextLine();
				campos = linea.split(";");
				nuevosDatos.add(linea);
				fechaInicio = campos[0];
				fechaFin = campos[1];
			}
			
		}catch(FileNotFoundException e1) {
			System.err.println("ERROR");
		}finally{
			//borrar fichero
		}
    	
    	Date fi = null;
		try {
			fi = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
    	Date ff = null;
		try {
			ff = new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		//IMPEDIMOS QUE SE PUEDAN HACER RESERVAS ANTERIORES AL DIA DE HOY
		hoy = calendario.getDate();
		calendario.setSelectableDateRange(fi, ff);		
		//A CONTINUACION SELECCIONAS OTRA FECHA PARA SELECCIONAR EL DIA DE SALIDA DEL HOTEL
		fechaSeleccion.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
		    	String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
		    	String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
		    	fecha.setText(year + "-" + mes + "-" + dia);
		    	d1 = calendario.getDate();

		    	if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
		    		fechaRegistro = year + "-0" + mes + "-0" + dia;
		    	 } else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
		    		 fechaRegistro = year + "-0" + mes + "-" + dia;
		    	 } else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
		    		 fechaRegistro = year + "-" + mes + "-0" + dia;
		    	 } else {
		    		 fechaRegistro = year + "-" + mes + "-" + dia;
		    	 }
		    	
		    	//CREAMOS LA RESTRICCION DE NO PODER VOLVER A ESCOGER LA FECHA INICIO PARA LA FECHA FINAL
		    	int minYear = Integer.parseInt(year);
		    	int minMes = Integer.parseInt(mes);
		    	int minDia = Integer.parseInt(dia);
		    	
		    	//SE RESTA 1900 PORQUE LA LIBRERÍA EMPIEZA A CONTAR DESDE 1900
		    	//SE RESTA 1 AL MES PORQUE EMPIEZA A CONTAR DESDE 0 Y ANTES LE HEMOS SUMADO 1 PARA ESCRIBIR BIEN LA FECHA
		    	Date minNoche = new Date(Date.UTC(minYear-1900, minMes-1, minDia +1, 0, 0, 0));
		    	if (tipo.contains("PADDLE") == true || tipo.contains("NATACION") == true  || tipo.contains("FUTBOL-SALA") == true || tipo.contains("BALONCESTO") == true) {
		    		VentanaReservaPista vrp = new VentanaReservaPista(nuevo, fechaRegistro, tipo, precio);
		    		dispose();
				} else if (tipo == "CLASE PADDLE" || tipo == "CLASE NATACION" || tipo == "CLASE FUTBOL-SALA" || tipo == "CLASE BALONCESTO") {
					bd.eleccionClaseDeporte(cliente, fechaRegistro, tipo);
					VentanaContinuacion vc = new VentanaContinuacion(cliente);
					dispose();
				}else {
				
					VentanaContinuacion vc = new VentanaContinuacion(cliente);
					dispose();
				}	    	
		    	
		    	dispose();
			}
		});
		
		JPanel p = new JPanel();
		
		JPanel pfecha = new JPanel();
		pfecha.add(new JLabel("Fecha Seleccionada"));
		pfecha.add(fecha);
		
		pfecha.add(fechaSeleccion);
		
		p.add(pfecha);
		p.add(calendario);
		add(p);
		
		// Cambiar color de letra del numero de día 
		calendario.setForeground(Color.BLACK);
		 
		// Cambiar color de letra del dia domingo
		calendario.setSundayForeground(Color.RED);
		 
		// Cambiar color de letra de semana
		calendario.setWeekdayForeground(Color.BLUE);
		
		// No mostramos la semana del año que es
		calendario.setWeekOfYearVisible(false);
		
		add(calendario);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calendario");
		setSize(800, 600);
		setVisible(true);
		
	}
	
}