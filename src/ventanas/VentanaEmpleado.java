package ventanas;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import hotel.*;
import ventanas.VentanaLogo.FondoPanel;

public class VentanaEmpleado extends JFrame{
	
	
	
	public enum DiaSemana {
        Lunes,
        Martes,
        Miercoles,
        Jueves,
        Viernes,
        Sabado,
        Domingo
    }
	
	public enum DepartamentoTrabajo{
		cocina,
		deporte,
		atencionCliente,
		seguridad,
		limpieza
	}
	
	JCalendar calendario;
	BD bd;
	
	//Cocina
	JLabel lunes;
	JLabel lunesMenu;
	JLabel martes;
	JLabel martesMenu;
	JLabel miercoles;
	JLabel miercolesMenu;
	JLabel jueves;
	JLabel juevesMenu;
	JLabel viernes;
	JLabel viernesMenu;
	JLabel sabado;
	JLabel sabadoMenu;
	JLabel domingo;
	JLabel domingoMenu;
	JTextArea menuDia;
	DiaSemana dia;
	DepartamentoTrabajo dpt;
	
	//Limpieza
	JTable limpiezaHabitacion;
	DefaultTableModel modelo;
	
	public VentanaEmpleado(Empleado empleado) {
		
		bd = new BD();
		try {
			bd.connect();
		} catch (BDException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel documentos = new JPanel();
    	Border documentosBorder = BorderFactory.createTitledBorder("DOCUMENTOS");
    	documentos.setBorder(documentosBorder);
    	documentos.setLayout(new GridLayout(1, 5));
		
    	JButton BOE = new JButton("BOE");
    	BOE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File("BOE.pdf");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}
			}
		});
    	
    	JButton nomina = new JButton("NOMINA");
    	nomina.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    	
    	JButton justificante = new JButton("JUSTIFICANTE");
    	justificante.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    	
    	JButton calendarioAnual = new JButton("CALENDARIO ANUAL");
    	calendarioAnual.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if (Desktop.isDesktopSupported()) {
    				try {
    					File myFile = new File("calendarioAnual.pdf");
    					Desktop.getDesktop().open(myFile);
    				} catch (IOException ex) {
    					// no application registered for PDFs
    				}
    			}
    		}
    	});
    	
    	JButton salir = new JButton("SALIR");
    	salir.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    	
    	documentos.add(BOE);
    	documentos.add(justificante);
    	documentos.add(nomina);
    	documentos.add(calendarioAnual);
    	documentos.add(salir);
    	
    	JPanel informacion = new JPanel();
    	Border informacionBorder = BorderFactory.createTitledBorder("INFORMACION");
    	informacion.setBorder(informacionBorder);
    	informacion.setLayout(new GridLayout(3, 2));
    	
    	JLabel nombre = new JLabel("NOMBRE: ");
    	JLabel nombreEmpleado = new JLabel(empleado.getNombre());
    	JLabel apellido = new JLabel("APELLIDO: ");
    	JLabel apellidoEmpleado = new JLabel(empleado.getApellido());
    	JLabel dpto = new JLabel("DEPARTAMENTO: ");
    	JLabel departamentoEmpleado = new JLabel(empleado.getDepartamento());
    	
    	informacion.add(nombre);
    	informacion.add(nombreEmpleado);
    	informacion.add(apellido);
    	informacion.add(apellidoEmpleado);
    	informacion.add(dpto);
    	informacion.add(departamentoEmpleado);
    	
    	JPanel trabajo = new JPanel();
    	Border trabajoBorder = BorderFactory.createTitledBorder("DEPARTAMENTO");
    	trabajo.setBorder(trabajoBorder);
    	
    	String departamento = empleado.getDepartamento();
    	
    	if (departamento.contains("deporte")) {
			departamento = "deporte";
		} else if (departamento.contains("atencion")) {
			departamento = "atencionCliente";
		}
    	
    	dpt = DepartamentoTrabajo.valueOf(departamento);
    	switch(dpt) {
    		
    	case cocina:
    		lunes = new JLabel("MENU LUNES: ");
    		martes = new JLabel("MENU MARTES: ");
	    	miercoles = new JLabel("MENU MIERCOLES: ");
	    	jueves = new JLabel("MENU JUEVES : ");
	    	viernes = new JLabel("MENU VIERNES : ");
	    	sabado = new JLabel("MENU SABADO : ");
	    	domingo = new JLabel("MENU DOMINGO : ");
	    	menuDia = new JTextArea();
	    	
	    	String[] dias={"Domingo","Lunes","Martes", "Miércoles","Jueves","Viernes","Sábado"};
	        Date hoy=new Date();
	        int numeroDia=0;
	        Calendar cal= Calendar.getInstance();
	        cal.setTime(hoy);
	        numeroDia=cal.get(Calendar.DAY_OF_WEEK);
	        dia = DiaSemana.valueOf(dias[numeroDia -1]);
	        String menu = "";
	       
	        switch(dia) {
	        
	        	case Lunes:
	        		trabajo.add(lunes);
	        		try {
	        			Scanner sc2;
	    			
	        			sc2 = new Scanner(new FileInputStream("src/menu/Menu " + dias[numeroDia -1] + ".txt"));
	        			while(sc2.hasNext()) {
	    				 
	        				menu = menu + sc2.nextLine();
	        				menu = menu + "\r\n";
	    				 
	        			}
	        			menuDia = new JTextArea(menu);
	        			trabajo.add(menuDia);
	        			if (empleado.isJefe() == false) {
	        				menuDia.setEditable(false);
	        			} else {
	        				menuDia.setEditable(true);
	        			}
	        		} catch (FileNotFoundException e2) {
	        			// 	TODO Auto-generated catch block
	        			e2.printStackTrace();
	        		}
	        		break;
	        
	        	case Martes:
	        		trabajo.add(martes);
	        		try {
	        			Scanner sc2;
	        			
	        			sc2 = new Scanner(new FileInputStream("src/menu/Menu " + dias[numeroDia -1] + ".txt"));
	        			while(sc2.hasNext()) {
	        				 
	        				 menu = menu + sc2.nextLine();
	        				 menu = menu + "\r\n";
	        				 
	        			}
	        			menuDia = new JTextArea(menu);
	        			trabajo.add(menuDia);
	        			if (empleado.isJefe() == false) {
							menuDia.setEditable(false);
						} else {
							menuDia.setEditable(true);
						}
	        		} catch (FileNotFoundException e2) {
	        			// TODO Auto-generated catch block
	        			e2.printStackTrace();
	        		}
	        		break;
	        		
	        	case Miercoles:
	        		trabajo.add(miercoles);
	        		try {
	        			Scanner sc2;
	        			
	        			sc2 = new Scanner(new FileInputStream("src/menu/Menu " + dias[numeroDia -1] + ".txt"));
	        			while(sc2.hasNext()) {
	        				 
	        				 menu = menu + sc2.nextLine();
	        				 menu = menu + "\r\n";
	        				 
	        			}
	        			menuDia = new JTextArea(menu);
	        			trabajo.add(menuDia);
	        			if (empleado.isJefe() == false) {
							menuDia.setEditable(false);
						} else {
							menuDia.setEditable(true);
						}
	        		} catch (FileNotFoundException e2) {
	        			// TODO Auto-generated catch block
	        			e2.printStackTrace();
	        		}
	        		break;
	        		
	        	case Jueves:
	        		trabajo.add(jueves);
	        		try {
	        			Scanner sc2;
	        			
	        			sc2 = new Scanner(new FileInputStream("src/menu/Menu " + dias[numeroDia -1] + ".txt"));
	        			while(sc2.hasNext()) {
	        				 
	        				 menu = menu + sc2.nextLine();
	        				 menu = menu + "\r\n";
	        				 
	        			}
	        			menuDia = new JTextArea(menu);
	        			trabajo.add(menuDia);
	        			if (empleado.isJefe() == false) {
							menuDia.setEditable(false);
						} else {
							menuDia.setEditable(true);
						}
	        		} catch (FileNotFoundException e2) {
	        			// TODO Auto-generated catch block
	        			e2.printStackTrace();
	        		}
	        		break;
	        		
	        	case Viernes:
	        		trabajo.add(viernes);
	        		try {
	        			Scanner sc2;
	        			
	        			sc2 = new Scanner(new FileInputStream("src/menu/Menu " + dias[numeroDia -1] + ".txt"));
	        			while(sc2.hasNext()) {
	        				 
	        				 menu = menu + sc2.nextLine();
	        				 menu = menu + "\r\n";
	        				 
	        			}
	        			menuDia = new JTextArea(menu);
	        			trabajo.add(menuDia);
	        			if (empleado.isJefe() == false) {
							menuDia.setEditable(false);
						} else {
							menuDia.setEditable(true);
						}
	        		} catch (FileNotFoundException e2) {
	        			// TODO Auto-generated catch block
	        			e2.printStackTrace();
	        		}
	        		break;
	        		
	        	case Sabado:
	        		trabajo.add(sabado);
	        		try {
	        			Scanner sc2;
	        			
	        			sc2 = new Scanner(new FileInputStream("src/menu/Menu " + dias[numeroDia -1] + ".txt"));
	        			while(sc2.hasNext()) {
	        				 
	        				 menu = menu + sc2.nextLine();
	        				 menu = menu + "\r\n";
	        				 
	        			}
	        			menuDia = new JTextArea(menu);
	        			trabajo.add(menuDia);
	        			if (empleado.isJefe() == false) {
							menuDia.setEditable(false);
						} else {
							menuDia.setEditable(true);
						}
	        		} catch (FileNotFoundException e2) {
	        			// TODO Auto-generated catch block
	        			e2.printStackTrace();
	        		}
	        		break;
	        		
	        	case Domingo:
	        		trabajo.add(domingo);
	        		try {
	        			Scanner sc2;
	        			
	        			sc2 = new Scanner(new FileInputStream("src/menu/Menu " + dias[numeroDia -1] + ".txt"));
	        			while(sc2.hasNext()) {
	        				 
	        				 menu = menu + sc2.nextLine();
	        				 menu = menu + "\r\n";
	        				 
	        			}
	        			menuDia = new JTextArea(menu);
	        			trabajo.add(menuDia);
	        			if (empleado.isJefe() == false) {
							menuDia.setEditable(false);
						} else {
							menuDia.setEditable(true);
						}
	        		} catch (FileNotFoundException e2) {
	        			// TODO Auto-generated catch block
	        			e2.printStackTrace();
	        		}
	        		break;
	        }
	        
    	case limpieza:
    		ArrayList<Integer> numHab = new ArrayList<Integer>();
    		limpiezaHabitacion = new JTable();
    		//habitaciones que esten ocupadas hoy
    		
    		numHab = bd.updateOcupadasHoy();
    		
    		modelo = (DefaultTableModel)limpiezaHabitacion.getModel();
    		
    		modelo.addColumn("HABITACIONES");
    		String[] tabla = new String[1];
    		String[] tabla1 = new String[1];
    		tabla[0] = "HABITACIONES";
    		modelo.addRow(tabla);
    		for(int i = 0; i < numHab.size(); i++) {
    			tabla1[0] = String.valueOf(numHab.get(i));
    			modelo.addRow(tabla1);
    		}
    		limpiezaHabitacion.setVisible(true);
    		trabajo.add(limpiezaHabitacion);
    		break;
	        
    	case seguridad:
    		
    		JButton primeraPlanta = new JButton("PRIMERA PLANTA");
    		JButton segundaPlanta = new JButton("SEGUNDA PLANTA");
    		JButton terceraPlanta = new JButton("TERCERA PLANTA");
    		JButton cuartaPlanta = new JButton("CUARTA PLANTA");
    		JButton quintaPlanta = new JButton("QUINTA PLANTA");
    		JButton sextaPlanta = new JButton("SEXTA PLANTA");
    		
    		trabajo.setLayout(new GridLayout(2, 3));
    		trabajo.add(primeraPlanta);
    		trabajo.add(segundaPlanta);
    		trabajo.add(terceraPlanta);
    		trabajo.add(cuartaPlanta);
    		trabajo.add(quintaPlanta);
    		trabajo.add(sextaPlanta);
    		   		
    		primeraPlanta.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					VentanaMapa vm = new VentanaMapa("/imagen/primeraPlanta.jpg", empleado);
				}
			});
    		segundaPlanta.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/segundaPlanta.jpg", empleado);
    			}
    		});
    		terceraPlanta.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/terceraPlanta.jpg", empleado);
    			}
    		});
    		cuartaPlanta.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/cuartaPlanta.jpg", empleado);
    			}
    		});
    		quintaPlanta.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/quintaPlanta.jpg", empleado);
    			}
    		});
    		sextaPlanta.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/sextaPlanta.jpg", empleado);
    			}
    		});
    		
    		break;
    		
    	case deporte:
    		JPanel izq = new JPanel();
    		JPanel drch = new JPanel();
    		Border pnlIzqBorder = BorderFactory.createTitledBorder("PISTAS RESERVADAS");
    		Border pnlDrchBorder = BorderFactory.createTitledBorder("CLASES DE HOY");
    		drch.setLayout(new GridLayout(2,4));
        	izq.setBorder(pnlIzqBorder);
        	drch.setBorder(pnlDrchBorder);
    		JTable reservas  = new JTable();
    		JScrollPane scroll = new JScrollPane(reservas);
    		modelo = (DefaultTableModel)reservas.getModel();
    		modelo.addColumn("Fecha Reserva");
    		modelo.addColumn("Hora");
    		modelo.addColumn("Numero de pista");
    		modelo.addColumn("Tipo de pista");
    		
    		bd.pistasReservadasHoy(modelo);
    		
    		izq.add(reservas);
    		
    		JTextArea paddel = new JTextArea();
    		JLabel paddelTitulo = new JLabel("PADDEL");
    		JTextArea natacion = new JTextArea();
    		JLabel natacionTitulo = new JLabel("NATACION");
    		JTextArea baloncesto = new JTextArea();
    		JLabel baloncestoTitulo = new JLabel("BALONCESTO");
    		JTextArea futbolSala = new JTextArea();
    		JLabel futbolSalaTitulo = new JLabel("  FUTBOL-SALA");
    		
    		List<JTextArea> lista = bd.clasesHoy(paddel, natacion, futbolSala, baloncesto);

    		drch.add(paddelTitulo);
    		drch.add(natacionTitulo);
    		drch.add(baloncestoTitulo);
    		drch.add(futbolSalaTitulo);
    		
    		for (JTextArea text : lista) {
				drch.add(text);
			}
    		
    		
    		
    		trabajo.add(izq);
    		trabajo.add(drch);
    		break;
    		
	    default:
    		break;
	    	
	        
    	}
    	JPanel main = new JPanel();
    	main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(documentos);
		main.add(informacion);
		main.add(trabajo);
    	
    	add(main);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ventana para empleados");
		setSize(800, 500);
		setVisible(true);
	}
	
}
