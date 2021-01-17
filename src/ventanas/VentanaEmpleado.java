package ventanas;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JCalendar;
import hotel.*;

public class VentanaEmpleado extends JFrame{
	
	
	//HACEMOS UN ENUM PARA CADA CASO DE LA DIA DE LA SEMANA EN Cocina
	public enum DiaSemana {
        Lunes,
        Martes,
        Miercoles,
        Jueves,
        Viernes,
        Sabado,
        Domingo
    }
	//HACEMSO UN ENUM PARA CADA DEPARTAMENTO DE EMPLEADOS
	public enum DepartamentoTrabajo{
		cocina,
		deporte,
		atencionCliente,
		seguridad,
		limpieza
	}
	
	JCalendar calendario;
	BD bd;
	
	//MENUS QUE TIENEN LOS COCINEROS
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
	//DEPORTE
	DefaultTableModel modelo2;
	
	public VentanaEmpleado(Empleado empleado) {
		
		bd = new BD();
		bd.connect();
		
		//CREAMSO LA PRIMERA PARTE DE VENTANAEMPLEADO, LA CUAL TIENEN TODOS LOS EMPLEADOS
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
    			VentanaMapa vm = new VentanaMapa("/imagen/Nomina.png", empleado);
    			dispose();
    		}
    	});
    	
    	JButton justificante = new JButton("JUSTIFICANTE");
    	justificante.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File("JustificanteEnfermedad.pdf");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}
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
    	
    	//INFORMACION DEL EMPLEADO
    	
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
    	
    	//DEPENDE DE QUE DEPARTAMENTO SEA SE ANYADIRAN DISTINTAS COSAS
    	
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
	        break;
    	case limpieza:
    		ArrayList<Integer> numHab = new ArrayList<Integer>();
    		limpiezaHabitacion = new JTable();
    		//NUMERO DE LAS HABITACION QUE ESTEN OCUPADAS HOY
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
					dispose();
				}
			});
    		segundaPlanta.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/segundaPlanta.jpg", empleado);
    				dispose();
    			}
    		});
    		terceraPlanta.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/terceraPlanta.jpg", empleado);
    				dispose();
    			}
    		});
    		cuartaPlanta.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/cuartaPlanta.jpg", empleado);
    				dispose();
    			}
    		});
    		quintaPlanta.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/quintaPlanta.jpg", empleado);
    				dispose();
    			}
    		});
    		sextaPlanta.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/sextaPlanta.jpg", empleado);
    				dispose();
    			}
    		});
    		
    		break;
    		
    	case deporte:
    		JPanel izq = new JPanel();
    		JPanel drch = new JPanel();
    		Border pnlIzqBorder = BorderFactory.createTitledBorder("PISTAS RESERVADAS");
    		Border pnlDrchBorder = BorderFactory.createTitledBorder("CLASES DE HOY");
        	izq.setBorder(pnlIzqBorder);
        	drch.setBorder(pnlDrchBorder);
    		JTable reservas  = new JTable();
    		JScrollPane scroll = new JScrollPane(reservas);
    		modelo = (DefaultTableModel)reservas.getModel();
    		modelo.addColumn("Fecha Reserva");
    		modelo.addColumn("Hora");
    		modelo.addColumn("Numero de pista");
    		modelo.addColumn("Tipo de pista");
    		//NOS DEVUELVE LAS PISTAS CON SU NUMERO Y MODELO QUE ESTAN RESERVADAS HOY
    		bd.pistasReservadasHoy(modelo);
    		izq.add(scroll);
    		
    		JTable clases  = new JTable();
    		JScrollPane scroll2 = new JScrollPane(clases);
    		modelo2 = (DefaultTableModel)clases.getModel();
    		modelo2.addColumn("Usuario");
    		modelo2.addColumn("Tipo de clase");
    		//NOS DEVUELVE LOS USUARIOS QUE SE AHN APUNTADO A UNA CLASE Y DE QUÉ VA ESA CLASE
    		bd.clasesHoy(modelo2);
    		drch.add(scroll2);
    		
    		
    		trabajo.add(izq);
    		trabajo.add(drch);
    		trabajo.setLayout(new BoxLayout(trabajo, BoxLayout.X_AXIS));
    		break;
    		
    	case atencionCliente:
    		
    		JButton pricipios = new JButton("PRINCIPIOS DE \nATENCION AL CLIENTE");
    		pricipios.addActionListener(new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				if (Desktop.isDesktopSupported()) {
    				    try {
    				        File myFile = new File("AtencionAlCliente.pdf");
    				        Desktop.getDesktop().open(myFile);
    				    } catch (IOException ex) {
    				        // no application registered for PDFs
    				    }
    				}
    			}
    		});
    		trabajo.add(pricipios);
    		
    		JButton primeraPlanta2 = new JButton("PRIMERA PLANTA");
    		JButton segundaPlanta2 = new JButton("SEGUNDA PLANTA");
    		JButton terceraPlanta2 = new JButton("TERCERA PLANTA");
    		JButton cuartaPlanta2 = new JButton("CUARTA PLANTA");
    		JButton quintaPlanta2 = new JButton("QUINTA PLANTA");
    		JButton sextaPlanta2 = new JButton("SEXTA PLANTA");
    		
    		trabajo.add(primeraPlanta2);
    		trabajo.add(segundaPlanta2);
    		trabajo.add(terceraPlanta2);
    		trabajo.add(cuartaPlanta2);
    		trabajo.add(quintaPlanta2);
    		trabajo.add(sextaPlanta2);
    		   		
    		primeraPlanta2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					VentanaMapa vm = new VentanaMapa("/imagen/primeraPlanta.jpg", empleado);
					dispose();
				}
			});
    		segundaPlanta2.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/segundaPlanta.jpg", empleado);
    				dispose();
    			}
    		});
    		terceraPlanta2.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/terceraPlanta.jpg", empleado);
    				dispose();
    			}
    		});
    		cuartaPlanta2.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/cuartaPlanta.jpg", empleado);
    				dispose();
    			}
    		});
    		quintaPlanta2.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/quintaPlanta.jpg", empleado);
    				dispose();
    			}
    		});
    		sextaPlanta2.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent arg0) {
    				VentanaMapa vm = new VentanaMapa("/imagen/sextaPlanta.jpg", empleado);
    				dispose();
    			}
    		});
    		
    		
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
		setSize(1000, 700);
		setVisible(true);
	}
	
}
