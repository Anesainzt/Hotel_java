package ventanas;
import javax.swing.*;

import com.toedter.calendar.JCalendar;

import hotel.Cliente;

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
import java.text.SimpleDateFormat;
import java.util.*;


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
	
	public VentanaCalendario(Cliente cliente, int precioHab) {
		
		setLayout(new GridLayout(2, 1));
		
		p = new JPanel();
		pfecha = new JPanel();
		calendario = new JCalendar();
		fecha=new JTextField(30);
		fechaInicio = new JButton("Fecha Inicio");
		fechaFin = new JButton("Fecha Fin");
		
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
				d2 = calendario.getDate();
				
				//CON LAS FECHAS DE ENTRADA Y SALIDA, CALCULAMOS LA DIFERENCIA PARA SABER LOS DIAS TOTALES DE ESTANCIA EN EL HOTEL
				Date startDate1 = d1;
		        Date endDate1 = d2;
		        long diff = endDate1.getTime() - startDate1.getTime();
		        
		        //VentanaServicios vs = new VentanaServicios(cliente);
		        
		        PrintWriter pw = null;
				try {
				    pw = new PrintWriter(new BufferedWriter(new FileWriter("Habitacion", true)));
				    pw.print("");
				    pw.println(new SimpleDateFormat("dd/MM/yyyy").format(startDate1) + ";" + new SimpleDateFormat("dd/MM/yyyy").format(endDate1));
				    
				} catch (IOException e1) {
				    System.err.println(e1);
				} finally {
				    if (pw != null) {
				        pw.close();
				    }
				}
				
				//EL DINERO DE LA VARIABLE ANTERIOR LA CONVERTIMOS A INT PARA PODER TRABAJAR CON ELLA
				String pago = Long.toString((diff / (1000L*60L*60L*24L)));
				
				//LA VARIABLE STRING PAGO ANTERIOR LA CONVIERTES A INT Y LA MULTIPLICAS POR EL PAGO POR NOCHE DE HABITACION
				//Y YA TENEMOS LO QUE PAGA POR LA HABITACION TOTAL DE TODOS LOS DIAS
				int pagoHabitacion = (Integer.parseInt(pago)*precioHab);
				
				//LE MOSTRAMOS UNA VENTANA INFORMATIVA PARA QUE SEPA EL DINERO QUE GASTARA POR ESOS DIAS DE LA HABITACION
				JOptionPane.showMessageDialog(null, "PAGO HABITACION: " + pago + " DIAS " + " = " + pagoHabitacion + "€");
				
				//A CONTINUACION LE LLEVAMOS A LA VENTANA SERVICIOS PARA QUE PUEDA CONTRATAR SERVICIOS COMPLEMENTARIOS
				VentanaServicios vs = new VentanaServicios(cliente, pagoHabitacion);
				
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