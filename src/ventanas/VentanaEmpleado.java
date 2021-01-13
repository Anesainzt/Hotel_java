package ventanas;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import hotel.*;

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
		Cocina,
		Deporte,
		AtencionCliente,
		Seguridad,
		Limpieza
	}
	
	JCalendar calendario;
	
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
    	Border informacionBorder = BorderFactory.createTitledBorder("DOCUMENTOS");
    	informacion.setBorder(informacionBorder);
    	informacion.setLayout(new GridLayout(1, 5));
    	
    	//ASIER
    	
    	JLabel nombre = new JLabel("NOMBRE");
    	
    	informacion.add(nombre);
    	
    	JPanel trabajo = new JPanel();
    	Border trabajoBorder = BorderFactory.createTitledBorder("DEPARTAMENTO");
    	trabajo.setBorder(trabajoBorder);
    	
    	
    	
    	String departamento = empleado.getDepartamento();
    	
    	dpt = DepartamentoTrabajo.valueOf(departamento);
    	switch(dpt) {
    		
    	case Cocina:
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
	    			
	        			sc2 = new Scanner(new FileInputStream("menus/Menu " + dias[numeroDia -1] + ".txt"));
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
	        			
	        			sc2 = new Scanner(new FileInputStream("menus/Menu " + dias[numeroDia -1] + ".txt"));
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
	        			
	        			sc2 = new Scanner(new FileInputStream("menus/Menu " + dias[numeroDia -1] + ".txt"));
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
	        			
	        			sc2 = new Scanner(new FileInputStream("menus/Menu " + dias[numeroDia -1] + ".txt"));
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
	        			
	        			sc2 = new Scanner(new FileInputStream("menus/Menu " + dias[numeroDia -1] + ".txt"));
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
	        			
	        			sc2 = new Scanner(new FileInputStream("menus/Menu " + dias[numeroDia -1] + ".txt"));
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
	        			
	        			sc2 = new Scanner(new FileInputStream("menus/Menu " + dias[numeroDia -1] + ".txt"));
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
	        
    	case Limpieza:
    		
    		modelo = (DefaultTableModel)limpiezaHabitacion.getModel();
    		modelo.addColumn("Habitacion");
    		modelo.addColumn("Limpiado");
    		
	        
	    default:
    		
    		break;
	    	
	        
    	}
    	JPanel main = new JPanel();
    	main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(documentos);
		main.add(informacion);
		main.add(trabajo);
    	
    	add(main);
    	
    	
		//nombre = new JLabel(empleado.getNombre());
		//apellido = new JLabel(empleado.getApellido());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ventana para empleados");
		setSize(800, 1000);
		setVisible(true);
	}
	
	public static void main (String args[]) {
		Empleado e = new Empleado();
		VentanaEmpleado ve = new VentanaEmpleado(e);
	}
	
}
