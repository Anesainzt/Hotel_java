package ventanas;
import javax.swing.*;

import com.toedter.calendar.JCalendar;
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
	
	JCalendar calendario;
	JTextField fecha;
	JButton fechaSeleccion;
	Date d1;
	Date d2;
	Date hoy;
	
	
	public VentanaReservaServicio(Cliente cliente, int precioHab) {
		
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
			Scanner sc1 = new Scanner(new FileInputStream("Habitacion"));
			
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
			fi = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicio);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	Date ff = null;
		try {
			ff = new SimpleDateFormat("dd/MM/yyyy").parse(fechaFin);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
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
		    	fecha.setText(dia + "-" + mes + "-" + year);
		    	d1 = calendario.getDate();
		    	
		    	//CREAMOS LA RESTRICCION DE NO PODER VOLVER A ESCOGER LA FECHA INICIO PARA LA FECHA FINAL
		    	int minYear = Integer.parseInt(year);
		    	int minMes = Integer.parseInt(mes);
		    	int minDia = Integer.parseInt(dia);
		    	
		    	//SE RESTA 1900 PORQUE LA LIBRERÍA EMPIEZA A CONTAR DESDE 1900
		    	//SE RESTA 1 AL MES PORQUE EMPIEZA A CONTAR DESDE 0 Y ANTES LE HEMOS SUMADO 1 PARA ESCRIBIR BIEN LA FECHA
		    	Date minNoche = new Date(Date.UTC(minYear-1900, minMes-1, minDia +1, 0, 0, 0));
		    	
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