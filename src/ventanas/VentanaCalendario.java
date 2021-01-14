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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;


public class VentanaCalendario extends JFrame{
	
	JCalendar calendario;
	JTextField fecha;
	JButton fechaInicio;
	JButton fechaFin;
	Date d1;
	Date d2;
	Date hoy;
	JPanel p;
	JPanel pfecha;
	
	BD bd;
	
	
	static  String fechaInc;
	private static Logger logger = Logger.getLogger(VentanaCalendario.class.getName());
	
	public VentanaCalendario(Cliente cliente, int precioHab, String type) {
		
		setLayout(new GridLayout(2, 1));
		
		p = new JPanel();
		pfecha = new JPanel();
		calendario = new JCalendar();
		fecha=new JTextField(30);
		fechaInicio = new JButton("Fecha Inicio");
		fechaFin = new JButton("Fecha Fin");
		bd = new BD();
		//IMPEDIMOS QUE SE PUEDAN HACER RESERVAS ANTERIORES AL DIA DE HOY
		hoy = calendario.getDate();
		calendario.setMinSelectableDate(hoy);
		
		
		//PRIMERO SELECCIONAS UN DIA, Y CLICAS EL BOTON FECHA INICIO PARA GUARDAR ESA FECHA COMO EL DIA DE ENTRADA
		fechaInicio.addActionListener(new ActionListener(){

		     @Override
		     public void actionPerformed(ActionEvent e) {
		    	 String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
		    	 String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
		    	 String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
		    	 fecha.setText(dia + "-" + mes + "-" + year);
		    	 if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
		    		 fechaInc = year + "-0" + mes + "-0" + dia;
		    	 } else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
					 fechaInc = year + "-0" + mes + "-" + dia;
		    	 } else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
					 fechaInc = year + "-" + mes + "-0" + dia;
		    	 } else {
					 fechaInc = year + "-" + mes + "-" + dia;
		    	 }
		    	 
		    	 pfecha.add(fechaFin);
		    	 pfecha.remove(fechaInicio);
		    	 setVisible(true);
		    	 
		    	 d1 = calendario.getDate();
		    	 
		    	 //CREAMOS LA RESTRICCION DE NO PODER VOLVER A ESCOGER LA FECHA INICIO PARA LA FECHA FINAL
		    	 int minYear = Integer.parseInt(year);
		    	 int minMes = Integer.parseInt(mes);
		    	 int minDia = Integer.parseInt(dia);
		    	 
		    	 //SE RESTA 1900 PORQUE LA LIBRERÍA EMPIEZA A CONTAR DESDE 1900
		    	 //SE RESTA 1 AL MES PORQUE EMPIEZA A CONTAR DESDE 0 Y ANTES LE HEMOS SUMADO 1 PARA ESCRIBIR BIEN LA FECHA
		    	 Date minNoche = new Date(Date.UTC(minYear-1900, minMes-1, minDia +1, 0, 0, 0));
		    	 
		    	 calendario.setMinSelectableDate(minNoche);
		     }
		});
		
		//A CONTINUACION SELECCIONAS OTRA FECHA PARA SELECCIONAR EL DIA DE SALIDA DEL HOTEL
		fechaFin.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
				String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
				String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
				fecha.setText(dia + "-" + mes + "-" + year);
				String fechaEndBD = year + "-" + mes + "-" + dia;
				d2 = calendario.getDate();
				
				
				//CON LAS FECHAS DE ENTRADA Y SALIDA, CALCULAMOS LA DIFERENCIA PARA SABER LOS DIAS TOTALES DE ESTANCIA EN EL HOTEL
				Date startDate1 = d1;
		        Date endDate1 = d2;
		        long diff = endDate1.getTime() - startDate1.getTime();
		        
		        //ESCRIBIMOS LAS FECHAS ENN UN FICHERO
		        bd.escribirFichero("fechas", new SimpleDateFormat("yyyy-MM-dd").format(startDate1) + ";" + new SimpleDateFormat("yyyy-MM-dd").format(endDate1));
		       
				//EL DINERO DE LA VARIABLE ANTERIOR LA CONVERTIMOS A INT PARA PODER TRABAJAR CON ELLA
				String pago = Long.toString((diff / (1000L*60L*60L*24L)));
				//ESCRIBIMOS LOS DATOS EN UN FICHERO
				bd.escribirFichero("datosFactura.txt", ";" + pago);
				
				//LA VARIABLE STRING PAGO ANTERIOR LA CONVIERTES A INT Y LA MULTIPLICAS POR EL PAGO POR NOCHE DE HABITACION
				//Y YA TENEMOS LO QUE PAGA POR LA HABITACION TOTAL DE TODOS LOS DIAS
				int pagoHabitacion = (Integer.parseInt(pago)*precioHab);
				
				//LE MOSTRAMOS UNA VENTANA INFORMATIVA PARA QUE SEPA EL DINERO QUE GASTARA POR ESOS DIAS DE LA HABITACION
				JOptionPane.showMessageDialog(null, "PAGO HABITACION: " + pago + " DIAS " + " = " + pagoHabitacion + "€");
				
				try {
					bd.connect();
				} catch (BDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//GUARDAMOS LOS DIAS QUE HA RESERVADO EN LA BASE DE DATOS
				bd.calendario(type, dia, mes , year, fechaInc);
				
				//A CONTINUACION LE LLEVAMOS A LA VENTANA SELECCION HABITACION PARA QUE ELIGA EL NUMERO DE HABITACION EN LA QUE SE ALOJARA ESOS DIAS
				VentanaSeleccionHabitacion vsh = new VentanaSeleccionHabitacion(cliente, precioHab, type);
				
		        dispose();		       
			}
		});
		
		pfecha.add(new JLabel("Fecha Seleccionada"));
		pfecha.add(fecha);
		pfecha.add(fechaInicio);
		
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