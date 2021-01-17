package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import hotel.Cliente;
import ventanas.VentanaReservaServicio;

public class VentanaMiniBar extends JFrame{

	JComboBox<String> comboMiniBar;
	JLabel miniBar;
	JButton continuar;
	static Logger logger = Logger.getLogger(VentanaMiniBar.class.getName());
	public VentanaMiniBar(Cliente cliente) {
		setLayout(new GridLayout(3, 1));
		
		comboMiniBar = new JComboBox<String>();
		
		miniBar = new JLabel("MINI BAR: ");
		continuar = new JButton("CONTINUAR");
		
		comboMiniBar.addItem("VODKA ---> 30€");
		comboMiniBar.addItem("GINEBRA ---> 30€");
		comboMiniBar.addItem("WHISKEY ---> 50€");
		comboMiniBar.addItem("TEQUILA ---> 45€");
		comboMiniBar.addItem("RON ---> 30€");
		comboMiniBar.addItem("ELECCION DE DOS (DIFERENTES) ---> 90€");
		comboMiniBar.addItem("ELECCION DE TRES (DIFERENTES) ---> 140€");
		comboMiniBar.addItem("TODOS ---> 180€");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboMiniBar.getSelectedItem().equals("VODKA ---> 30€")) {
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 30, "VODKA");
				}else if (comboMiniBar.getSelectedItem().equals("GINEBRA ---> 30€")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 30,"GINEBRA");
				}else if (comboMiniBar.getSelectedItem().equals("WHISKEY ---> 50€")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "WHISKEY");
				}else if (comboMiniBar.getSelectedItem().equals("TEQUILA ---> 45€")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 45, "TEQUILA");
				}else if (comboMiniBar.getSelectedItem().equals("RON ---> 30€")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 30, "RON");
				}else if (comboMiniBar.getSelectedItem().equals("ELECCION DE DOS (DIFERENTES) ---> 90€")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "ELECCION DE DOS");
				}else if (comboMiniBar.getSelectedItem().equals("ELECCION DE TRES (DIFERENTES) ---> 140€")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 140, "ELECCION DE TRES");
				}else if (comboMiniBar.getSelectedItem().equals("TODOS ---> 180€")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 180, "TODOS");
				}else {
					logger.info("TIENES QUE ELEGIR UN SERVICIO");
					VentanaDeporte vd = new VentanaDeporte(cliente);
				}
				
				dispose();
			}
		});
		
		add(miniBar);
		add(comboMiniBar);
		add(continuar);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio Mini Bar");
		setSize(800, 200);
		setVisible(true);

	}
}
