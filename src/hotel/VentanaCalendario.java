package hotel;
import javax.swing.*;

import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class VentanaCalendario extends JFrame{
	
	JCalendar calendario;
	JTextField fecha;
	JButton fechaInicio;
	JButton fechaFin;
	Date d1;
	Date d2;
	Date hoy;
	
	
	public VentanaCalendario(Cliente cliente) {
		
		setLayout(new GridLayout(2, 1));
		
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
		        
		        //LEEMOS EL FICHERO HABITACION DONDE ANTERIORMENTE HABIAMOS GUARDADO LOS DATOS DE LA HABITACION ESCOGIDA
		        ArrayList<String> nuevosDatos = new ArrayList<String>();
				ArrayList<String> datosFicheros = new ArrayList<String>();
				String linea = null;
				String[] campos = null;
				String dinero = null;
				
				try {
					Scanner sc1 = new Scanner(new FileInputStream("Habitacion"));
					
					while(sc1.hasNext()) {
						linea = sc1.nextLine();
						campos = linea.split(";");
						nuevosDatos.add(linea);
						//IMPORTANTE LA VARIABLE DINERO PARA GUARDAR EL DINERO DE LA HABITACION POR NOCHE
						dinero = campos[2];
					}
					
				}catch(FileNotFoundException e1) {
					System.err.println("ERROR");
				}finally{
					//borrar fichero
				}
				
				//EL DINERO DE LA VARIABLE ANTERIOR LA CONVERTIMOS A INT PARA PODER TRABAJAR CON ELLA
				int d = Integer.parseInt(dinero);
				
				//CON LA VARIABLE PAGO CONVIERTES LA DIFERENCIA DE FECHAS DE LONG A STRING
				String pago = Long.toString((diff / (1000L*60L*60L*24L)));
				
				//LA VARIABLE STRING PAGO ANTERIOR LA CONVIERTES A INT Y LA MULTIPLICAS POR EL PAGO POR NOCHE DE HABITACION
				//Y YA TENEMOS LO QUE PAGA POR LA HABITACION TOTAL DE TODOS LOS DIAS
				int pagoHabitacion = (Integer.parseInt(pago)*d);
				
				//LE MOSTRAMOS UNA VENTANA INFORMATIVA PARA QUE SEPA EL DINERO QUE GASTARA POR ESOS DIAS DE LA HABITACION
				JOptionPane.showMessageDialog(null, "PAGO HABITACION: " + pago + " DIAS " + " = " + pagoHabitacion + "€");
				
				//A CONTINUACION LE LLEVAMOS A LA VENTANA SERVICIOS PARA QUE PUEDA CONTRATAR SERVICIOS COMPLEMENTARIOS
				VentanaServicios vs = new VentanaServicios(cliente);
		        
		        dispose();		       
			}
		});
		
		JPanel p = new JPanel();
		
		JPanel pfecha = new JPanel();
		pfecha.add(new JLabel("Fecha Seleccionada"));
		pfecha.add(fecha);
		
		pfecha.add(fechaInicio);
		pfecha.add(fechaFin);
		
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