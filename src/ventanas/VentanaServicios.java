package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import hotel.BD;
import hotel.Cliente;
import ventanaServicios.VentanaComida;
import ventanaServicios.VentanaDeporte;
import ventanaServicios.VentanaMiniBar;
import ventanaServicios.VentanaSalaReunion;
import ventanaServicios.VentanaSpa;

public class VentanaServicios extends JFrame {
	
	static Logger logger = Logger.getLogger(VentanaServicios.class.getName());
	JRadioButton spa, buffet, deportes, miniBar, salaReunion, sinServicioExtra;
	ButtonGroup bg;
	JButton contratar;
	BD bd;
	
	public VentanaServicios(Cliente cliente) {
		
		bd = new BD();
		bd.connect();
		
		setLayout(new GridLayout(7, 1));
		
		bg = new ButtonGroup();
		
		spa = new JRadioButton("SPA");
		buffet = new JRadioButton("Buffet"); 
		deportes = new JRadioButton("Deportes");
		miniBar = new JRadioButton("Minibar"); 
		salaReunion = new JRadioButton("Sala de reunion");
		sinServicioExtra = new JRadioButton("Sin Servicio Extra");
		
		bg.add(spa);
		bg.add(buffet);
		bg.add(deportes);
		bg.add(miniBar);
		bg.add(salaReunion);
		bg.add(sinServicioExtra);
		
		contratar = new JButton("CONTINUAR");
		
		contratar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(spa.isSelected()) {
					VentanaSpa vc = new VentanaSpa(cliente);
				}else if(buffet.isSelected()) {
					VentanaComida vc = new VentanaComida(cliente);
				}else if(deportes.isSelected()) {
					VentanaDeporte vc = new VentanaDeporte(cliente);
				}else if(miniBar.isSelected()) {
					VentanaMiniBar vc = new VentanaMiniBar(cliente);
				}else if(salaReunion.isSelected()) {
					VentanaSalaReunion vc = new VentanaSalaReunion(cliente);
				}else if(sinServicioExtra.isSelected()) {
					VentanaContinuacion vc = new VentanaContinuacion(cliente);
				}else {
					logger.info("TIENES QUE ELEGIR");
					VentanaServicios vs = new VentanaServicios(cliente);
				}
				dispose();
			}
			
		});
		
		add(spa);
		add(buffet);
		add(deportes);
		add(miniBar);	
		add(salaReunion);
		add(sinServicioExtra);
		add(contratar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio");
		setSize(800, 200);
		setVisible(true);
		
	}

}
