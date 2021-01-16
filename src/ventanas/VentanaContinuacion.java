package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import hotel.BD;
import hotel.BDException;
import hotel.Cliente;

public class VentanaContinuacion extends JFrame{
	
	BD bd;
	
	JButton elegirNuevoServicio;
	JButton continuar;
	
	public VentanaContinuacion(Cliente cliente) {
		bd = new BD();
		try {
			bd.connect();
		} catch (BDException e2) {
			e2.printStackTrace();
		}
		setLayout(new GridLayout(2, 1));
		
		elegirNuevoServicio = new JButton("ELEGIR NUEVO SERVICIO");
		continuar = new JButton("CONTINUAR");
		
		elegirNuevoServicio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BufferedWriter bw;
				try {
					bw = new BufferedWriter(new FileWriter("horaPista"));
					bw.write("");
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				bd.restartPistas();
				
				VentanaServicios vs = new VentanaServicios(cliente);
				dispose();
			}
		});
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaFactura vf = new VentanaFactura(cliente);
				dispose();
				try {
					bd.disconnect();
				} catch (BDException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		add(elegirNuevoServicio);
		add(continuar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Continuacion");
		setSize(800, 200);
		setVisible(true);
		
	}

}
