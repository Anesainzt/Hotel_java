package ventanas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		JLabel hab = new JLabel("HABITACION");
		JLabel di = new JLabel("DIAS");
		
		JPanel datosHabitacion = new JPanel();
    	Border datosHabitacionBorder = BorderFactory.createTitledBorder("HABITACION");
    	datosHabitacion.setBorder(datosHabitacionBorder);
    	datosHabitacion.setLayout(new GridLayout(2, 4));
    	datosHabitacion.setBackground(Color.LIGHT_GRAY);
    	
    	datosHabitacion.add(hab);
    	datosHabitacion.add(di);
    	datosHabitacion.add(precioTotal);
    	
    	datosHabitacion.add(habitacion);
    	datosHabitacion.add(cantDias);
    	datosHabitacion.add(precioTotHabitacion);
    	
    	HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
    	
		hashmap = cliente.getHashmap();
    	
		ArrayList<String> comida = new ArrayList<String>();
		ArrayList<String> deporte = new ArrayList<String>();
		ArrayList<String> miniBar = new ArrayList<String>();
		ArrayList<String> salaReunion = new ArrayList<String>();
		ArrayList<String> spa = new ArrayList<String>();
		comida = cliente.getComida();
		deporte = cliente.getDeporte();
		miniBar = cliente.getMiniBar();
		salaReunion = cliente.getSalaReunion();
		spa = cliente.getSpa();
		
		int mcdonalds = 0;
		int burgerking = 0;
		int fostershollywood = 0;
		int pomodoro = 0;
		int foodoo = 0;
		int donga = 0;
		int menudeldiahotel = 0;
		int buffethotel = 0;
		
		int pmcdonalds = 0;
		int pburgerking = 0;
		int pfostershollywood = 0;
		int ppomodoro = 0;
		int pfoodoo = 0;
		int pdonga = 0;
		int pmenudeldiahotel = 0;
		int pbuffethotel = 0;
		
		for(int i = 0; i < comida.size(); i++) {
			if(comida.get(i).equals("MCDONALDS")) {
				mcdonalds += 1;
			}else if(comida.get(i).equals("BURGER KING")) {
				burgerking += 1;
			}else if(comida.get(i).equals("FOSTERS HOLLYWOOD")) {
				fostershollywood += 1;
			}else if(comida.get(i).equals("POMODORO")) {
				pomodoro += 1;
			}else if(comida.get(i).equals("FOODOO")) {
				foodoo += 1;
			}else if(comida.get(i).equals("DONGA")) {
				donga += 1;
			}else if(comida.get(i).equals("MENU DEL DIA HOTEL")) {
				menudeldiahotel += 1;
			}else {
				buffethotel += 1;
			}
		}
		
		int masajefacial = 0;
		int masajecorporal = 0;
		int masajetotal = 0;
		int jacuzzi = 0;
		int salesminerales = 0;
		int masajepiedras = 0;
		int tratamientoestetico = 0;
		
		int pmasajefacial = 0;
		int pmasajecorporal = 0;
		int pmasajetotal = 0;
		int pjacuzzi = 0;
		int psalesminerales = 0;
		int pmasajepiedras = 0;
		int ptratamientoestetico = 0;
		
		for(int i = 0; i < spa.size(); i++) {
			if(spa.get(i).equals("MASAJE FACIAL")) {
				masajefacial += 1;
			}else if(spa.get(i).equals("MASAJE CORPORAL")) {
				masajecorporal += 1;
			}else if(spa.get(i).equals("MASAJE TOTAL")) {
				masajetotal += 1;
			}else if(spa.get(i).equals("JACUZZI")) {
				jacuzzi += 1;
			}else if(spa.get(i).equals("SALES MINERALES")) {
				salesminerales += 1;
			}else if(spa.get(i).equals("MASAJE PIEDRAS")) {
				masajepiedras += 1;
			}else {
				tratamientoestetico += 1;
			}
		}
		
		for (Entry<String, Integer> entry : hashmap.entrySet()) {
            if(entry.getKey().equals("MASAJE FACIAL") || entry.getKey().equals("MASAJE CORPORAL") || entry.getKey().equals("MASAJE TOTAL") || entry.getKey().equals("JACUZZI") || entry.getKey().equals("SALES MINERALES") || entry.getKey().equals("MASAJE PIEDRAS") || entry.getKey().equals("TRATAMIENTO ESTÉTICO")) {
            	if(entry.getKey().equals("MASAJE FACIAL")) {
            		pmasajefacial = entry.getValue();
            	}else if(entry.getKey().equals("MASAJE CORPORAL")) {
            		pmasajecorporal = entry.getValue();
            	}else if(entry.getKey().equals("MASAJE TOTAL")) {
            		pmasajetotal = entry.getValue();
            	}else if(entry.getKey().equals("JACUZZI")) {
            		pjacuzzi = entry.getValue();
            	}else if(entry.getKey().equals("SALES MINERALES")) {
            		psalesminerales = entry.getValue();
            	}else if(entry.getKey().equals("MASAJE PIEDRAS")) {
            		pmasajepiedras = entry.getValue();
            	}else {
            		ptratamientoestetico = entry.getValue();
            	}
            }else if(entry.getKey().equals("SALA CONVENCION") || entry.getKey().equals("SALA JUNTA") || entry.getKey().equals("SALA PETIT COMITÉ") || entry.getKey().equals("SALA CONVENCION EQUIPADA") || entry.getKey().equals("SALA JUNTA EQUIPADA") || entry.getKey().equals("SALA PETIT COMITÉ EQUIPADA")) {
            	
            }else if(entry.getKey().equals("VODKA") || entry.getKey().equals("GINEBRA") || entry.getKey().equals("WHISKEY") || entry.getKey().equals("TEQUILA") || entry.getKey().equals("RON") || entry.getKey().equals("ELECCION DE DOS") || entry.getKey().equals("ELECCION DE TRES") || entry.getKey().equals("TODOS")) {
            	
            }else if(entry.getKey().equals("MCDONALDS") || entry.getKey().equals("BURGER KING") || entry.getKey().equals("FOSTERS HOLLYWOOD") || entry.getKey().equals("POMODORO") || entry.getKey().equals("FOODOO") || entry.getKey().equals("DONGA") || entry.getKey().equals("MENU DEL DIA HOTEL") || entry.getKey().equals("BUFFET HOTEL")) {
            	if(entry.getKey().equals("MCDONALDS")) {
            		pmcdonalds = entry.getValue();
            	}else if(entry.getKey().equals("BURGER KING")) {
            		pburgerking = entry.getValue();
            	}else if(entry.getKey().equals("FOSTERS HOLLYWOOD")) {
            		pfostershollywood = entry.getValue();
            	}else if(entry.getKey().equals("POMODORO")) {
            		ppomodoro = entry.getValue();
            	}else if(entry.getKey().equals("FOODOO")) {
            		pfoodoo = entry.getValue();
            	}else if(entry.getKey().equals("DONGA")) {
            		pdonga = entry.getValue();
            	}else if(entry.getKey().equals("MENU DEL DIA HOTEL")) {
            		pmenudeldiahotel = entry.getValue();
            	}else {
            		pbuffethotel = entry.getValue();
            	}
            }else{
            	
            }
        }
		
		int precComida = mcdonalds*pmcdonalds + burgerking*pburgerking + fostershollywood*pfostershollywood + pomodoro*ppomodoro + foodoo*pfoodoo + donga*pdonga + menudeldiahotel*pmenudeldiahotel + buffethotel*pbuffethotel;
		int precDeporte = 0;
		int precMiniBar = 0;
		int precSalaReunion = 0;
		int precSpa = masajefacial*pmasajefacial + masajecorporal*pmasajecorporal + masajetotal*pmasajetotal + jacuzzi*pjacuzzi + salesminerales*psalesminerales + masajepiedras*pmasajepiedras + tratamientoestetico*ptratamientoestetico;
		
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
    	datosServiciosExtra.setLayout(new GridLayout(21, 3));
    	
    	datosServiciosExtra.add(cantidad);
    	datosServiciosExtra.add(productos);
    	datosServiciosExtra.add(precio);
    	
    	datosServiciosExtra.add(cantidadComida);
    	datosServiciosExtra.add(descripcionComida);
    	datosServiciosExtra.add(pComida);
    	
    	JLabel cantMcDonalds = new JLabel("" + mcdonalds);
    	cantMcDonalds.setForeground(Color.GRAY);
        JLabel nomMcDonalds = new JLabel("McDonalds");
        nomMcDonalds.setForeground(Color.GRAY);
        JLabel precMcDonalds = new JLabel("" + mcdonalds*30);
        precMcDonalds.setForeground(Color.GRAY);
        
    	datosServiciosExtra.add(cantMcDonalds);
    	datosServiciosExtra.add(nomMcDonalds);
    	datosServiciosExtra.add(precMcDonalds);
    	
    	JLabel cantBurguerKing = new JLabel("" + burgerking);
    	cantBurguerKing.setForeground(Color.GRAY);
    	JLabel nomBurguerKing = new JLabel("Burger King");
    	nomBurguerKing.setForeground(Color.GRAY);
    	JLabel precBurguerKing = new JLabel("" + burgerking*30);
    	precBurguerKing.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantBurguerKing);
    	datosServiciosExtra.add(nomBurguerKing);
    	datosServiciosExtra.add(precBurguerKing);
    	
    	JLabel cantFostersHollywood = new JLabel("" + fostershollywood);
    	cantFostersHollywood.setForeground(Color.GRAY);
    	JLabel nomFostersHollywood = new JLabel("Fosters Hollywood");
    	nomFostersHollywood.setForeground(Color.GRAY);
    	JLabel precFostersHollywood = new JLabel("" + fostershollywood*40);
    	precFostersHollywood.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantFostersHollywood);
    	datosServiciosExtra.add(nomFostersHollywood);
    	datosServiciosExtra.add(precFostersHollywood);
    	
    	JLabel cantPomodoro = new JLabel("" + pomodoro);
    	cantPomodoro.setForeground(Color.GRAY);
    	JLabel nomPomodoro = new JLabel("Pomodoro");
    	nomPomodoro.setForeground(Color.GRAY);
    	JLabel precPomodoro = new JLabel("" + pomodoro*45);
    	precPomodoro.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantPomodoro);
    	datosServiciosExtra.add(nomPomodoro);
    	datosServiciosExtra.add(precPomodoro);
    	
    	JLabel cantFoodoo = new JLabel("" + foodoo);
    	cantFoodoo.setForeground(Color.GRAY);
    	JLabel nomFoodoo = new JLabel("Foodoo");
    	nomFoodoo.setForeground(Color.GRAY);
    	JLabel precFoodoo = new JLabel("" + foodoo*50);
    	precFoodoo.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantFoodoo);
    	datosServiciosExtra.add(nomFoodoo);
    	datosServiciosExtra.add(precFoodoo);
    	
    	JLabel cantDonga = new JLabel("" + donga);
    	cantDonga.setForeground(Color.GRAY);
    	JLabel nomDonga = new JLabel("Donga");
    	nomDonga.setForeground(Color.GRAY);
    	JLabel precDonga = new JLabel("" + donga*60);
    	precDonga.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantDonga);
    	datosServiciosExtra.add(nomDonga);
    	datosServiciosExtra.add(precDonga);
    	
    	JLabel cantMenu = new JLabel("" + menudeldiahotel);
    	cantMenu.setForeground(Color.GRAY);
    	JLabel nomMenu = new JLabel("Menu hotel");
    	nomMenu.setForeground(Color.GRAY);
    	JLabel precMenu = new JLabel("" + menudeldiahotel*150);
    	precMenu.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantMenu);
    	datosServiciosExtra.add(nomMenu);
    	datosServiciosExtra.add(precMenu);
    	
    	JLabel cantBuffet = new JLabel("" + buffethotel);
    	cantBuffet.setForeground(Color.GRAY);
    	JLabel nomBuffet = new JLabel("Buffet hotel");
    	nomBuffet.setForeground(Color.GRAY);
    	JLabel precBuffet = new JLabel("" + buffethotel*110);
    	precBuffet.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantBuffet);
    	datosServiciosExtra.add(nomBuffet);
    	datosServiciosExtra.add(precBuffet);
    	
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
    	
    	JLabel cantMasajeFacial = new JLabel("" + masajefacial);
    	cantMasajeFacial.setForeground(Color.GRAY);
    	JLabel nomMasajeFacial = new JLabel("Masaje facial");
    	nomMasajeFacial.setForeground(Color.GRAY);
    	JLabel precMasajeFacial = new JLabel("" + masajefacial*50);
    	precMasajeFacial.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantMasajeFacial);
    	datosServiciosExtra.add(nomMasajeFacial);
    	datosServiciosExtra.add(precMasajeFacial);
    	
    	JLabel cantMasajeCorporal = new JLabel("" + masajecorporal);
    	cantMasajeCorporal.setForeground(Color.GRAY);
    	JLabel nomMasajeCorporal = new JLabel("Masaje corporal");
    	nomMasajeCorporal.setForeground(Color.GRAY);
    	JLabel precMasajeCorporal = new JLabel("" + masajecorporal*90);
    	precMasajeCorporal.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantMasajeCorporal);
    	datosServiciosExtra.add(nomMasajeCorporal);
    	datosServiciosExtra.add(precMasajeCorporal);
    	
    	JLabel cantMasajeTotal = new JLabel("" + masajetotal);
    	cantMasajeTotal.setForeground(Color.GRAY);
    	JLabel nomMasajeTotal = new JLabel("Masaje total");
    	nomMasajeTotal.setForeground(Color.GRAY);
    	JLabel precMasajeTotal = new JLabel("" + masajetotal*130);
    	precMasajeTotal.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantMasajeTotal);
    	datosServiciosExtra.add(nomMasajeTotal);
    	datosServiciosExtra.add(precMasajeTotal);
		
		JLabel cantJacuzzi = new JLabel("" + jacuzzi);
    	cantJacuzzi.setForeground(Color.GRAY);
    	JLabel nomJacuzzi = new JLabel("Jacuzzi");
    	nomJacuzzi.setForeground(Color.GRAY);
    	JLabel precJacuzzi = new JLabel("" + jacuzzi*150);
    	precJacuzzi.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantJacuzzi);
    	datosServiciosExtra.add(nomJacuzzi);
    	datosServiciosExtra.add(precJacuzzi);
		
    	JLabel cantSalesMinerales = new JLabel("" + salesminerales);
    	cantSalesMinerales.setForeground(Color.GRAY);
    	JLabel nomSalesMinerales = new JLabel("Sales Minerales");
    	nomSalesMinerales.setForeground(Color.GRAY);
    	JLabel precSalesMinerales = new JLabel("" + salesminerales*60);
    	precSalesMinerales.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantSalesMinerales);
    	datosServiciosExtra.add(nomSalesMinerales);
    	datosServiciosExtra.add(precSalesMinerales);
    	
    	JLabel cantMasajePiedras = new JLabel("" + masajepiedras);
    	cantMasajePiedras.setForeground(Color.GRAY);
    	JLabel nomMasajePiedras = new JLabel("Masaje Piedras");
    	nomMasajePiedras.setForeground(Color.GRAY);
    	JLabel precMasajePiedras = new JLabel("" + masajepiedras*80);
    	precMasajePiedras.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantMasajePiedras);
    	datosServiciosExtra.add(nomMasajePiedras);
    	datosServiciosExtra.add(precMasajePiedras);
    	
    	JLabel cantTratamientoEstetico = new JLabel("" + tratamientoestetico);
    	cantTratamientoEstetico.setForeground(Color.GRAY);
    	JLabel nomTratamientoEstetico = new JLabel("Tratamiento estetico");
    	nomTratamientoEstetico.setForeground(Color.GRAY);
    	JLabel precTratamientoEstetico = new JLabel("" + tratamientoestetico*90);
    	precTratamientoEstetico.setForeground(Color.GRAY);
    	
    	datosServiciosExtra.add(cantTratamientoEstetico);
    	datosServiciosExtra.add(nomTratamientoEstetico);
    	datosServiciosExtra.add(precTratamientoEstetico);
    	
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
