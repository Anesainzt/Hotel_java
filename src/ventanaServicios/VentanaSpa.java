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

public class VentanaSpa extends JFrame{
	//VENTANA PARA ELECCION DE RESERVA DE SPA
	JComboBox<String> comboSpa;
	JLabel spa;
	JButton continuar;
	BD bd;
	static Logger logger = Logger.getLogger(VentanaSpa.class.getName());
	public VentanaSpa(Cliente cliente) {
		setLayout(new GridLayout(3, 1));
		//CONECTAMOS CON LA BASE DE DATOS
		bd = new BD();
		
		bd.connect();
		
		comboSpa = new JComboBox<String>();
		
		spa = new JLabel("SPA: ");
		continuar = new JButton("CONTINUAR");
		//AGREGAMOS TODAS LAS POSIBLES ELECCIONES
		comboSpa.addItem("(50�) MASAJE FACIAL ---> 09:00-09:50");
		comboSpa.addItem("(50�) MASAJE FACIAL ---> 10:00-10:50");
		comboSpa.addItem("(50�) MASAJE FACIAL ---> 11:00-11:50");
		comboSpa.addItem("(50�) MASAJE FACIAL ---> 12:00-12:50");
		comboSpa.addItem("(90�) MASAJE CORPORAL ---> 09:00-09:50");
		comboSpa.addItem("(90�) MASAJE CORPORAL ---> 10:00-10:50");
		comboSpa.addItem("(90�) MASAJE CORPORAL ---> 11:00-11:50");
		comboSpa.addItem("(90�) MASAJE CORPORAL ---> 12:00-12:50");
		comboSpa.addItem("(130�) MASAJE TOTAL ---> 09:00-09:50");
		comboSpa.addItem("(130�) MASAJE TOTAL ---> 10:00-10:50");
		comboSpa.addItem("(130�) MASAJE TOTAL ---> 11:00-11:50");
		comboSpa.addItem("(130�) MASAJE TOTAL ---> 12:00-12:50");
		comboSpa.addItem("(150�) JACUZZI ---> 09:00-09:50");
		comboSpa.addItem("(150�) JACUZZI ---> 11:00-11:50");
		comboSpa.addItem("(60�) SALES MINERALES ---> 09:00-09:50");
		comboSpa.addItem("(60�) SALES MINERALES ---> 10:00-10:50");
		comboSpa.addItem("(60�) SALES MINERALES ---> 11:00-11:50");
		comboSpa.addItem("(60�) SALES MINERALES ---> 12:00-12:50");
		comboSpa.addItem("(80�) MASAJE PIEDRAS ---> 09:00-09:50");
		comboSpa.addItem("(80�) MASAJE PIEDRAS ---> 10:00-10:50");
		comboSpa.addItem("(80�) MASAJE PIEDRAS ---> 11:00-11:50");
		comboSpa.addItem("(80�) MASAJE PIEDRAS ---> 12:00-12:50");
		comboSpa.addItem("(90�) TRATAMIENTO EST�TICO ---> 09:00-09:50");
		comboSpa.addItem("(90�) TRATAMIENTO EST�TICO ---> 10:00-10:50");
		comboSpa.addItem("(90�) TRATAMIENTO EST�TICO ---> 11:00-11:50");
		comboSpa.addItem("(90�) TRATAMIENTO EST�TICO ---> 12:00-12:50");
		//AL ELEGIR UNA SE GUARDA LA HORA EN UN FICHERO Y CONTINUAMOS CON LA RESERVA
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			    if(comboSpa.getSelectedItem().equals("(50�) MASAJE FACIAL ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "MASAJE FACIAL");
			    }else if(comboSpa.getSelectedItem().equals("(50�) MASAJE FACIAL ---> 10:00-10:50")){
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "MASAJE FACIAL");
			    }else if(comboSpa.getSelectedItem().equals("(50�) MASAJE FACIAL ---> 11:00-11:50")){
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "MASAJE FACIAL");
			    }else if(comboSpa.getSelectedItem().equals("(50�) MASAJE FACIAL ---> 12:00-12:50")){
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "MASAJE FACIAL");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(90�) MASAJE CORPORAL ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "MASAJE CORPORAL");
			    }else if(comboSpa.getSelectedItem().equals("(90�) MASAJE CORPORAL ---> 10:00-10:50")) {
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "MASAJE CORPORAL");
			    }else if(comboSpa.getSelectedItem().equals("(90�) MASAJE CORPORAL ---> 11:00-11:50")) {
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "MASAJE CORPORAL");
			    }else if(comboSpa.getSelectedItem().equals("(90�) MASAJE CORPORAL ---> 12:00-12:50")) {
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "MASAJE CORPORAL");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(130�) MASAJE TOTAL ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 130, "MASAJE TOTAL");	
			    }else if(comboSpa.getSelectedItem().equals("(130�) MASAJE TOTAL ---> 10:00-10:50")) {
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 130, "MASAJE TOTAL");	
			    }else if(comboSpa.getSelectedItem().equals("(130�) MASAJE TOTAL ---> 11:00-11:50")) {
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 130, "MASAJE TOTAL");	
			    }else if(comboSpa.getSelectedItem().equals("(130�) MASAJE TOTAL ---> 12:00-12:50")) {
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 130, "MASAJE TOTAL");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(150�) JACUZZI ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 150, "JACUZZI");
			    }else if(comboSpa.getSelectedItem().equals("(150�) JACUZZI ---> 11:00-11:50")) {
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 150, "JACUZZI");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(60�) SALES MINERALES ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 60, "SALES MINERALES");
			    }else if(comboSpa.getSelectedItem().equals("(60�) SALES MINERALES ---> 10:00-10:50")) {
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 60, "SALES MINERALES");
			    }else if(comboSpa.getSelectedItem().equals("(60�) SALES MINERALES ---> 11:00-11:50")) {
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 60, "SALES MINERALES");
			    }else if(comboSpa.getSelectedItem().equals("(60�) SALES MINERALES ---> 12:00-12:50")) {
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 60, "SALES MINERALES");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(80�) MASAJE PIEDRAS ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "MASAJE PIEDRAS");
			    }else if(comboSpa.getSelectedItem().equals("(80�) MASAJE PIEDRAS ---> 10:00-10:50")) {
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "MASAJE PIEDRAS");
			    }else if(comboSpa.getSelectedItem().equals("(80�) MASAJE PIEDRAS ---> 11:00-11:50")) {
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "MASAJE PIEDRAS");
			    }else if(comboSpa.getSelectedItem().equals("(80�) MASAJE PIEDRAS ---> 12:00-12:50")) {
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "MASAJE PIEDRAS");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(90�) TRATAMIENTO EST�TICO ---> 09:00-09:50")){
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "TRATAMIENTO EST�TICO");
			    }else if(comboSpa.getSelectedItem().equals("(90�) TRATAMIENTO EST�TICO ---> 10:00-10:50")){
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "TRATAMIENTO EST�TICO");
			    }else if(comboSpa.getSelectedItem().equals("(90�) TRATAMIENTO EST�TICO ---> 11:00-11:50")){
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "TRATAMIENTO EST�TICO");
			    }else if(comboSpa.getSelectedItem().equals("(90�) TRATAMIENTO EST�TICO ---> 12:00-12:50")){
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "TRATAMIENTO EST�TICO");
			    }else {
			    	logger.info("TIENES QUE ELEGIR UN SERVICIO");
					VentanaDeporte vd = new VentanaDeporte(cliente);
			    }
				
				dispose();
			}
		});
		
		
		add(spa);
		add(comboSpa);
		add(continuar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio SPA");
		setSize(800, 200);
		setVisible(true);
	}

}
