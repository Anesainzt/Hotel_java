package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import hotel.BD;
import hotel.Cliente;
import ventanas.VentanaReservaServicio;

public class VentanaDeporte extends JFrame{
	//VENTANA PARA MOSTRAR LAS CLASES Y PISTAS QUE PUEDE RESERVAR Y SUS RESPECTIVOS PRECIOS Y HORAS
	JComboBox<String> comboDeporte;
	JLabel deporte;
	JButton elegir;
	static Logger logger = Logger.getLogger(VentanaDeporte.class.getName());
	BD bd;
	public VentanaDeporte(Cliente cliente) {
		setLayout(new GridLayout(3, 1));
		//NOS CONECTAMOS A LA BASE DE DATOS PARA PODER ESCRIBIR EN EL METODO DE LOS FICHEROS
		bd = new BD();
		
		bd.connect();
		
		comboDeporte = new JComboBox<String>();
		
		deporte = new JLabel("DEPORTE: ");
		elegir = new JButton("ELEGIR PISTA");
		//AÑADIMOS AL COMBO LAS SELECCIONES
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
		//AL ELEGIR UNA, SE ESCRIBE EL HORARIO EN EL FICHERO Y SE LE LLEVA A UNA VENTANA PARA RESERVAR
		elegir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboDeporte.getSelectedItem().equals("(15€) PISTA PADDLE ---> 09:00-09:50")){
					bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "PADDLE");
				}else if (comboDeporte.getSelectedItem().equals("(15€) PISTA PADDLE ---> 10:00-10:50")){
					bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "PADDLE");
				}else if (comboDeporte.getSelectedItem().equals("(15€) PISTA PADDLE ---> 11:00-11:50")){
					bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "PADDLE");
				}else if (comboDeporte.getSelectedItem().equals("(15€) PISTA PADDLE ---> 12:00-12:50")){
					bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "PADDLE");
				} else if (comboDeporte.getSelectedItem().equals("(10€) PISCINA NATACION ---> 09:00-09:50")){
					bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 10, "NATACION");
				}else if (comboDeporte.getSelectedItem().equals("(10€) PISCINA NATACION ---> 10:00-10:50")){
					bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 10, "NATACION");
				}else if (comboDeporte.getSelectedItem().equals("(10€) PISCINA NATACION ---> 11:00-11:50")){
					bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 10, "NATACION");
				}else if (comboDeporte.getSelectedItem().equals("(10€) PISCINA NATACION ---> 12:00-12:50")){
					bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 10, "NATACION");
				}else if (comboDeporte.getSelectedItem().equals("(20€) CAMPO BALONCESTO ---> 09:00-09:50")){
					bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 20, "BALONCESTO");
				}else if (comboDeporte.getSelectedItem().equals("(20€) CAMPO BALONCESTO ---> 10:00-10:50")){
					bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 20, "BALONCESTO");
				}else if (comboDeporte.getSelectedItem().equals("(20€) CAMPO BALONCESTO ---> 11:00-11:50")){
					bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 20, "BALONCESTO");
				}else if (comboDeporte.getSelectedItem().equals("(20€) CAMPO BALONCESTO ---> 12:00-12:50")){
					bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 20, "BALONCESTO");
				}else if (comboDeporte.getSelectedItem().equals("(15€) CAMPO FUTBOL-SALA ---> 09:00-09:50")){
					bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "FUTBOL-SALA");
				}else if (comboDeporte.getSelectedItem().equals("(15€) CAMPO FUTBOL-SALA ---> 10:00-10:50")){
					bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "FUTBOL-SALA");
				}else if (comboDeporte.getSelectedItem().equals("(15€) CAMPO FUTBOL-SALA ---> 11:00-11:50")){
					bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "FUTBOL-SALA");
				}else if (comboDeporte.getSelectedItem().equals("(15€) CAMPO FUTBOL-SALA ---> 12:00-12:50")){
					bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 15, "FUTBOL-SALA");	
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
					logger.info("TIENES QUE ELEGIR UN SERVICIO");
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
