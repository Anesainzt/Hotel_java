package ventanaServicios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import hotel.BD;
import hotel.BDException;
import hotel.Cliente;
import ventanas.VentanaContinuacion;
import ventanas.VentanaReservaServicio;

public class VentanaReservaPista extends JFrame{
	//VENTANA PARA RESERVAR LA PISTA DEL DEPORTE QUE HA SELECCIONADO
	JButton boton;
	JButton vueltaDeporte;
	JButton vueltaFecha;
	JButton continuarSinPista;
	JPanel pistas;
	JPanel cambioEleccion;
	BD bd;
	List<JButton> botones;
	
	public VentanaReservaPista(Cliente cliente, String fecha, String tipo, int precio) {
		//CONECTAMOS CON LA BASE DE DATOS
		bd= new BD();
		try {
			bd.connect();
		} catch (BDException e1) {
			e1.printStackTrace();
		}
		//OBTENEMOS LA HORA A LA QUE HA ESCOGIDO LA PISTA
		String hora = bd.getHoraReserva("horaPista");
		//LE MOSTRAMOS LAS PISTAS PARA QUE SELECCIONE ALGUNA LIBRE
		bd.eleccionDePistasLibres(fecha, hora, tipo);
		
		
		pistas = new JPanel();
    	Border pistasBorder = BorderFactory.createTitledBorder("PISTAS");
    	pistas.setBorder(pistasBorder);
    	pistas.setLayout(new GridLayout(1, 1));
    	pistas.setSize(100, 100);
		//AL ELEGIR LA PISTA, SE GUARDA LA RESERVA Y CONTINUAMOS CON LA RESERVA
		botones = bd.botonesReservarPista(tipo);
		
		for (JButton boton : botones) {
			if(boton.getBackground() == Color.GREEN) {
				boton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String num = boton.getText();
						bd.registrarReservaPista(cliente, fecha, hora, num, tipo);
						
						VentanaContinuacion vn = new VentanaContinuacion(cliente);
						
						dispose();
					}
				});
			}
			pistas.add(boton);
		}
		
		cambioEleccion = new JPanel();
    	Border cambioEleccionBorder = BorderFactory.createTitledBorder("CAMBIO ELECCION");
    	cambioEleccion.setBorder(cambioEleccionBorder);
    	cambioEleccion.setLayout(new GridLayout(3, 1));
    	cambioEleccion.setSize(100, 100);
    	//SI ESTAN TODAS LAS PISTAS OCUPADAS PARA ESE DIA PUEDE VOLVER A ELEGIR OTRA FECHA
    	vueltaFecha = new JButton("ELEGIR NUEVA FECHA");
		
    	vueltaFecha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ESCRIBIMOS LA NUEVA INFORMACION EN LOS FICHEROS
				
				VentanaReservaServicio vc = new VentanaReservaServicio(cliente, precio, tipo);
				
				dispose();
			}
			
		});
    	//SI NO HAY PISTAS LIBRES O HA DECIDIDO CAMBIAR DE DEPORTE, PUEDE DARLE A ESTE BOTON PARA ELEGIR UNO NUEVO
    	vueltaDeporte = new JButton("ELEGIR OTRA PISTA");
    	
    	vueltaDeporte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaDeporte vn = new VentanaDeporte(cliente);
				
				bd.escribirFichero("horaPista", "");
				
				dispose();
			}
		});
    	//SI AL FINAL HA DECIDIDO NO QUERE RESERVARLO, PUEDE CONTINUAR SIN HACER LA RESERVA
    	continuarSinPista = new JButton("CONTINUAR SIN RESERVAR");
    	
    	continuarSinPista.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			
    			cliente.getHashmap().remove(tipo);
    			cliente.getDeporte().remove(cliente.getDeporte().lastIndexOf(tipo));
    			
    			VentanaContinuacion vc = new VentanaContinuacion(cliente);
    			
    			bd.escribirFichero("horaPista", "");
    			
    			dispose();
    		}
    	});
		
    	
    	
    	cambioEleccion.add(vueltaFecha);
    	cambioEleccion.add(vueltaDeporte);
    	cambioEleccion.add(continuarSinPista);
    	
    	JPanel main = new JPanel();
    	main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
    	main.add(pistas);
    	main.add(cambioEleccion);
    	
    	add(main);
    	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Reserva servicio");
		setSize(500, 500);
		setVisible(true);
	}
	
}
