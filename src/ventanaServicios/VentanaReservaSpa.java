package ventanaServicios;

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

public class VentanaReservaSpa extends JFrame{
	JButton boton;
	JButton vueltaSpa;
	JButton vueltaFecha;
	JButton continuarSinPista;
	JPanel pistas;
	JPanel cambioEleccion;
	BD bd;
	List<JButton> botones;
	
	public VentanaReservaSpa(Cliente cliente, String fecha, String tipo, int precio) {
		
		bd= new BD();
		try {
			bd.connect();
		} catch (BDException e1) {
			e1.printStackTrace();
		}
		
		String hora = bd.getHoraReserva("horaSpa");
		
		bd.eleccionDeSpaLibre(fecha, hora, tipo);
		
		
		pistas = new JPanel();
    	Border pistasBorder = BorderFactory.createTitledBorder("SPA");
    	pistas.setBorder(pistasBorder);
    	pistas.setLayout(new GridLayout(1, 1));
    	pistas.setSize(100, 100);
		
		botones = bd.botonesReservarSpa(tipo);
		
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
    	
    	vueltaFecha = new JButton("ELEGIR NUEVA FECHA");
		
    	vueltaFecha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ESCRIBIMOS LA NUEVA INFORMACION EN LOS FICHEROS
				
				VentanaReservaServicio vc = new VentanaReservaServicio(cliente, precio, tipo);
				
				dispose();
			}
			
		});
    	
    	vueltaSpa = new JButton("ELEGIR OTRA SESION");
    	
    	vueltaSpa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaSpa vs = new VentanaSpa(cliente);
				
				bd.escribirFichero("horaSpa", "");
				
				dispose();
			}
		});
    	
    	continuarSinPista = new JButton("CONTINUAR SIN RESERVAR");
    	
    	continuarSinPista.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			
    			cliente.getHashmap().remove(tipo);
    			cliente.getSpa().remove(cliente.getSpa().lastIndexOf(tipo));
    			
    			VentanaContinuacion vc = new VentanaContinuacion(cliente);
    			
    			bd.escribirFichero("horaSpa", "");
    			
    			dispose();
    		}
    	});
		
    	
    	
    	cambioEleccion.add(vueltaFecha);
    	cambioEleccion.add(vueltaSpa);
    	cambioEleccion.add(continuarSinPista);
    	
    	JPanel main = new JPanel();
    	main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
    	main.add(pistas);
    	main.add(cambioEleccion);
    	
    	add(main);
    	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Reserva pista servicio");
		setSize(500, 500);
		setVisible(true);
	}
	
}
