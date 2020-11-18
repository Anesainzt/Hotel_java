package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import hotel.Cliente;

public class VentanaServicios extends JFrame {
	
	JRadioButton spa, buffet, deportes, miniBar, salaReunion, sinServicioExtra;
	ButtonGroup bg;
	JButton contratar;
	
	public VentanaServicios(Cliente cliente, int dinero) {
		
		setLayout(new GridLayout(6, 1));
		
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
					String s = "SPA";
					//VentanaHoraServicio vhs = new VentanaHoraServicio(cliente, s);
				}else if(buffet.isSelected()) {
					String b = "Buffet";
					//VentanaHoraServicio vhs = new VentanaHoraServicio(cliente, b);
				}else if(deportes.isSelected()) {
					String d = "Deportes";
					//VentanaHoraServicio vhs = new VentanaHoraServicio(cliente, d);
				}else if(miniBar.isSelected()) {
					String mb = "MiniBar";
					//VentanaHoraServicio vhs = new VentanaHoraServicio(cliente, mb);
				}else if(salaReunion.isSelected()) {
					String mb = "Sala de reunion";
				}else if(sinServicioExtra.isSelected()) {
					String mb = "Sin Servicio extra";
				}
			}
		});
		
		add(spa);
		add(buffet);
		add(deportes);
		add(miniBar);
		add(contratar);	
		add(salaReunion);
		add(sinServicioExtra);	
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro del cliente");
		setSize(800, 200);
		setVisible(true);
		
	}

}
