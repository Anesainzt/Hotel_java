package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hotel.BD;
import hotel.Cliente;
import ventanas.VentanaReservaServicio;

public class VentanaDeporte extends JFrame{

	JComboBox<String> comboDeporte;
	JLabel deporte;
	JButton elegir;
	
	BD bd;
	public VentanaDeporte(Cliente cliente) {
		setLayout(new GridLayout(3, 1));
		
		
		comboDeporte = new JComboBox<String>();
		
		deporte = new JLabel("DEPORTE: ");
		elegir = new JButton("ELEGIR PISTA");
		
		comboDeporte.addItem("(15€) PISTA PADDLE ---> 09:00-09:50");
		comboDeporte.addItem("(15€) PISTA PADDLE ---> 10:00-10:50");
		comboDeporte.addItem("(15€) PISTA PADDLE ---> 11:00-11:50");
		comboDeporte.addItem("(15€) PISTA PADDLE ---> 12:00-12:50");
		comboDeporte.addItem("(10€) PISCINA NATACION ---> 09:00-09:50");
		comboDeporte.addItem("(10€) PISCINA NATACION ---> 10:00-10:50");
		comboDeporte.addItem("(10€) PISCINA NATACION ---> 11:00-11:50");
		comboDeporte.addItem("(10€) PISCINA NATACION ---> 12:00-12:50");
		comboDeporte.addItem("(20€) CAMPO BALONCESTO ---> 09:00-09:50");
		comboDeporte.addItem("(20€) CAMPO BALONCESTO ---> 10:00-10:50");
		comboDeporte.addItem("(20€) CAMPO BALONCESTO ---> 11:00-11:50");
		comboDeporte.addItem("(20€) CAMPO BALONCESTO ---> 12:00-12:50");
		comboDeporte.addItem("(15€) CAMPO FUTBOL-SALA ---> 09:00-09:50");
		comboDeporte.addItem("(15€) CAMPO FUTBOL-SALA ---> 10:00-10:50");
		comboDeporte.addItem("(15€) CAMPO FUTBOL-SALA ---> 11:00-11:50");
		comboDeporte.addItem("(15€) CAMPO FUTBOL-SALA ---> 12:00-12:50");
		
		comboDeporte.addItem("(30€) CLASE PADDLE ---> 17:00-19:00");
		comboDeporte.addItem("(15€) CLASE NATACION ---> 17:00-19:00");
		comboDeporte.addItem("(30€) CLASE BALONCESTO ---> 17:00-19:00");
		comboDeporte.addItem("(20€) CLASE FUTBOL-SALA ---> 17:00-19:00");
		
		elegir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboDeporte.getSelectedItem().equals("(15€) PISTA PADDLE ---> 09:00-09:50")){
					bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "PISTA PADDLE");
				}else if (comboDeporte.getSelectedItem().equals("(15€) PISTA PADDLE ---> 10:00-10:50")){
					bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "PISTA PADDLE");
				}else if (comboDeporte.getSelectedItem().equals("(15€) PISTA PADDLE ---> 11:00-11:50")){
					bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "PISTA PADDLE");
				}else if (comboDeporte.getSelectedItem().equals("(15€) PISTA PADDLE ---> 12:00-12:50")){
					bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "PISTA PADDLE");
				} else if (comboDeporte.getSelectedItem().equals("(10€) PISCINA NATACION ---> 09:00-09:50")){
					bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 10, "PISCINA NATACION");
				}else if (comboDeporte.getSelectedItem().equals("(10€) PISCINA NATACION ---> 10:00-10:50")){
					bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 10, "PISCINA NATACION");
				}else if (comboDeporte.getSelectedItem().equals("(10€) PISCINA NATACION ---> 11:00-11:50")){
					bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 10, "PISCINA NATACION");
				}else if (comboDeporte.getSelectedItem().equals("(10€) PISCINA NATACION ---> 12:00-12:50")){
					bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 10, "PISCINA NATACION");
				}else if (comboDeporte.getSelectedItem().equals("(20€) CAMPO BALONCESTO ---> 09:00-09:50")){
					bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 20, "CAMPO BALONCESTO");
				}else if (comboDeporte.getSelectedItem().equals("(20€) CAMPO BALONCESTO ---> 10:00-10:50")){
					bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 20, "CAMPO BALONCESTO");
				}else if (comboDeporte.getSelectedItem().equals("(20€) CAMPO BALONCESTO ---> 11:00-11:50")){
					bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 20, "CAMPO BALONCESTO");
				}else if (comboDeporte.getSelectedItem().equals("(20€) CAMPO BALONCESTO ---> 12:00-12:50")){
					bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 20, "CAMPO BALONCESTO");
				}else if (comboDeporte.getSelectedItem().equals("(15€) CAMPO FUTBOL-SALA ---> 09:00-09:50")){
					bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "CAMPO FUTBO-SALA");
				}else if (comboDeporte.getSelectedItem().equals("(15€) CAMPO FUTBOL-SALA ---> 10:00-10:50")){
					bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "CAMPO FUTBO-SALA");
				}else if (comboDeporte.getSelectedItem().equals("(15€) CAMPO FUTBOL-SALA ---> 11:00-11:50")){
					bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "CAMPO FUTBO-SALA");
				}else if (comboDeporte.getSelectedItem().equals("(15€) CAMPO FUTBOL-SALA ---> 12:00-12:50")){
					bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "CAMPO FUTBO-SALA");	
				}
				//SIEMPRE HAY UNA CLASE CADA DIA SIN LIMITE DE PARTICIPANTES
				else if (comboDeporte.getSelectedItem().equals("(30€) CLASE PADDLE ---> 17:00-19:00")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 30, "CLASE PADDLE");
				}else if (comboDeporte.getSelectedItem().equals("(15€) CLASE NATACION ---> 17:00-19:00")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "CLASE NATACION");
				}else if (comboDeporte.getSelectedItem().equals("(30€) CLASE BALONCESTO ---> 17:00-19:00")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 30, "CLASE BALONCESTO");
				}else if (comboDeporte.getSelectedItem().equals("(30€) CLASE FUTBOL-SALA ---> 17:00-19:00")){
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 20, "CLASE FUTBOL-SALA");
				}else {
					System.out.println("TIENES QUE ELEGIR UN SERVICIO");
					VentanaDeporte vd = new VentanaDeporte(cliente);
				}
				
				dispose();
			}
		});
		
		add(deporte);
		add(comboDeporte);
		add(elegir);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio Deportes");
		setSize(800, 200);
		setVisible(true);

	}
}
