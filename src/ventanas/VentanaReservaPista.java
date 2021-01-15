package ventanas;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import hotel.BD;
import hotel.Cliente;
import ventanaServicios.VentanaDeporte;

public class VentanaReservaPista extends JFrame{

	JButton boton;
	JButton vueltaDeporte;
	JButton vueltaFecha;
	JPanel pistas;
	JPanel cambioEleccion;
	BD bd;
	
	public VentanaReservaPista(Cliente cliente, String fecha, String tipo, int precio) {
		
		String hora = bd.getHoraReserva();
		
		bd.eleccionDePistasLibres(fecha, hora, tipo);
		
		pistas = new JPanel();
    	Border pistasBorder = BorderFactory.createTitledBorder("PISATAS");
    	pistas.setBorder(pistasBorder);
    	pistas.setLayout(new GridLayout(1, 1));
		
		List<JButton> botones = bd.botonesReservarPista(tipo);
		
		for (JButton boton : botones) {
			if(boton.getBackground() == Color.GREEN) {
				boton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
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
    	cambioEleccion.setLayout(new GridLayout(2, 1));
    	
    	vueltaFecha = new JButton("ELEGIR NUEVA FECHA");
		
    	vueltaFecha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ESCRIBIMOS LA NUEVA INFORMACION EN LOS FICHEROS
				
				VentanaReservaServicio vc = new VentanaReservaServicio(cliente, precio, tipo);
				
				dispose();
			}
			
		});
    	
    	vueltaDeporte = new JButton("ELEGIR OTRA PISTA");
    	
    	vueltaDeporte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				VentanaDeporte vn = new VentanaDeporte(cliente);
				
				bd.escribirFichero("horaPista", "");
				
				dispose();
			}
		});
		
    	cambioEleccion.add(vueltaFecha);
    	cambioEleccion.add(vueltaDeporte);
    	
    	add(pistas);
    	add(cambioEleccion);
    	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Reserva pista servicio");
		setSize(1200, 500);
		setVisible(true);
	}
	
}
