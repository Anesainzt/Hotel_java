package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hotel.BD;
import hotel.BDException;
import hotel.Cliente;
import ventanas.VentanaReservaServicio;

public class VentanaSpa extends JFrame{
	
	JComboBox<String> comboSpa;
	JLabel spa;
	JButton continuar;
	BD bd;
	
	public VentanaSpa(Cliente cliente) {
		setLayout(new GridLayout(3, 1));
		
		bd = new BD();
		
		try {
			bd.connect();
		} catch (BDException e1) {
			e1.printStackTrace();
		}
		
		comboSpa = new JComboBox<String>();
		
		spa = new JLabel("SPA: ");
		continuar = new JButton("CONTINUAR");
				
		comboSpa.addItem("(50€) MASAJE FACIAL ---> 09:00-09:50");
		comboSpa.addItem("(50€) MASAJE FACIAL ---> 10:00-10:50");
		comboSpa.addItem("(50€) MASAJE FACIAL ---> 11:00-11:50");
		comboSpa.addItem("(50€) MASAJE FACIAL ---> 12:00-12:50");
		comboSpa.addItem("(90€) MASAJE CORPORAL ---> 09:00-09:50");
		comboSpa.addItem("(90€) MASAJE CORPORAL ---> 10:00-10:50");
		comboSpa.addItem("(90€) MASAJE CORPORAL ---> 11:00-11:50");
		comboSpa.addItem("(90€) MASAJE CORPORAL ---> 12:00-12:50");
		comboSpa.addItem("(130€) MASAJE TOTAL ---> 09:00-09:50");
		comboSpa.addItem("(130€) MASAJE TOTAL ---> 10:00-10:50");
		comboSpa.addItem("(130€) MASAJE TOTAL ---> 11:00-11:50");
		comboSpa.addItem("(130€) MASAJE TOTAL ---> 12:00-12:50");
		comboSpa.addItem("(150€) JACUZZI ---> 09:00-09:50");
		comboSpa.addItem("(150€) JACUZZI ---> 11:00-11:50");
		comboSpa.addItem("(60€) SALES MINERALES ---> 09:00-09:50");
		comboSpa.addItem("(60€) SALES MINERALES ---> 10:00-10:50");
		comboSpa.addItem("(60€) SALES MINERALES ---> 11:00-11:50");
		comboSpa.addItem("(60€) SALES MINERALES ---> 12:00-12:50");
		comboSpa.addItem("(80€) MASAJE PIEDRAS ---> 09:00-09:50");
		comboSpa.addItem("(80€) MASAJE PIEDRAS ---> 10:00-10:50");
		comboSpa.addItem("(80€) MASAJE PIEDRAS ---> 11:00-11:50");
		comboSpa.addItem("(80€) MASAJE PIEDRAS ---> 12:00-12:50");
		comboSpa.addItem("(90€) TRATAMIENTO ESTÉTICO ---> 09:00-09:50");
		comboSpa.addItem("(90€) TRATAMIENTO ESTÉTICO ---> 10:00-10:50");
		comboSpa.addItem("(90€) TRATAMIENTO ESTÉTICO ---> 11:00-11:50");
		comboSpa.addItem("(90€) TRATAMIENTO ESTÉTICO ---> 12:00-12:50");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			    if(comboSpa.getSelectedItem().equals("(50€) MASAJE FACIAL ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "MASAJE FACIAL");
			    }else if(comboSpa.getSelectedItem().equals("(50€) MASAJE FACIAL ---> 10:00-10:50")){
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "MASAJE FACIAL");
			    }else if(comboSpa.getSelectedItem().equals("(50€) MASAJE FACIAL ---> 11:00-11:50")){
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "MASAJE FACIAL");
			    }else if(comboSpa.getSelectedItem().equals("(50€) MASAJE FACIAL ---> 12:00-12:50")){
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "MASAJE FACIAL");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(90€) MASAJE CORPORAL ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "MASAJE CORPORAL");
			    }else if(comboSpa.getSelectedItem().equals("(90€) MASAJE CORPORAL ---> 10:00-10:50")) {
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "MASAJE CORPORAL");
			    }else if(comboSpa.getSelectedItem().equals("(90€) MASAJE CORPORAL ---> 11:00-11:50")) {
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "MASAJE CORPORAL");
			    }else if(comboSpa.getSelectedItem().equals("(90€) MASAJE CORPORAL ---> 12:00-12:50")) {
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "MASAJE CORPORAL");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(130€) MASAJE TOTAL ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 130, "MASAJE TOTAL");	
			    }else if(comboSpa.getSelectedItem().equals("(130€) MASAJE TOTAL ---> 10:00-10:50")) {
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 130, "MASAJE TOTAL");	
			    }else if(comboSpa.getSelectedItem().equals("(130€) MASAJE TOTAL ---> 11:00-11:50")) {
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 130, "MASAJE TOTAL");	
			    }else if(comboSpa.getSelectedItem().equals("(130€) MASAJE TOTAL ---> 12:00-12:50")) {
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 130, "MASAJE TOTAL");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(150€) JACUZZI ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 150, "JACUZZI");
			    }else if(comboSpa.getSelectedItem().equals("(150€) JACUZZI ---> 11:00-11:50")) {
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 150, "JACUZZI");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(60€) SALES MINERALES ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 60, "SALES MINERALES");
			    }else if(comboSpa.getSelectedItem().equals("(60€) SALES MINERALES ---> 10:00-10:50")) {
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 60, "SALES MINERALES");
			    }else if(comboSpa.getSelectedItem().equals("(60€) SALES MINERALES ---> 11:00-11:50")) {
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 60, "SALES MINERALES");
			    }else if(comboSpa.getSelectedItem().equals("(60€) SALES MINERALES ---> 12:00-12:50")) {
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 60, "SALES MINERALES");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(80€) MASAJE PIEDRAS ---> 09:00-09:50")) {
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "MASAJE PIEDRAS");
			    }else if(comboSpa.getSelectedItem().equals("(80€) MASAJE PIEDRAS ---> 10:00-10:50")) {
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "MASAJE PIEDRAS");
			    }else if(comboSpa.getSelectedItem().equals("(80€) MASAJE PIEDRAS ---> 11:00-11:50")) {
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "MASAJE PIEDRAS");
			    }else if(comboSpa.getSelectedItem().equals("(80€) MASAJE PIEDRAS ---> 12:00-12:50")) {
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "MASAJE PIEDRAS");
			    	
			    }else if(comboSpa.getSelectedItem().equals("(90€) TRATAMIENTO ESTÉTICO ---> 09:00-09:50")){
			    	bd.escribirFichero("horaPista", "09:00-09:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "TRATAMIENTO ESTÉTICO");
			    }else if(comboSpa.getSelectedItem().equals("(90€) TRATAMIENTO ESTÉTICO ---> 10:00-10:50")){
			    	bd.escribirFichero("horaPista", "10:00-10:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "TRATAMIENTO ESTÉTICO");
			    }else if(comboSpa.getSelectedItem().equals("(90€) TRATAMIENTO ESTÉTICO ---> 11:00-11:50")){
			    	bd.escribirFichero("horaPista", "11:00-11:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "TRATAMIENTO ESTÉTICO");
			    }else if(comboSpa.getSelectedItem().equals("(90€) TRATAMIENTO ESTÉTICO ---> 12:00-12:50")){
			    	bd.escribirFichero("horaPista", "12:00-12:50");
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 90, "TRATAMIENTO ESTÉTICO");
			    }else {
			    	System.out.println("TIENES QUE ELEGIR UN SERVICIO");
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
