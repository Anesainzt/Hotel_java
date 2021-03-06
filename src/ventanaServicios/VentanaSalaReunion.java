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

public class VentanaSalaReunion extends JFrame{
	//VENTANA PARA MOSTRAR LOS SERVICIOS SE SALA DE REUNIONES
	JComboBox<String> comboSalaReunion;
	JLabel salaReunion;
	JButton continuar;
	BD bd;
	static Logger logger = Logger.getLogger(VentanaSalaReunion.class.getName());
	public VentanaSalaReunion(Cliente cliente) {
		setLayout(new GridLayout(3, 1));
		//CONECTAMOS CON LA BASE DE DATOS
		bd = new BD();
		bd.connect();
		
		comboSalaReunion = new JComboBox<String>();
		
		salaReunion = new JLabel("SALA REUNION: ");
		continuar = new JButton("ELEGIR SALA");
		//AGREGAMOS AL COMBO TODAS LAS  POSIBLES ELECCIONES
		comboSalaReunion.addItem("(80�) SALA CONVENCION (100 personas) ---> 09:00-09:50");
		comboSalaReunion.addItem("(80�) SALA CONVENCION (100 personas) ---> 10:00-10:50");
		comboSalaReunion.addItem("(80�) SALA CONVENCION (100 personas) ---> 11:00-11:50");
		comboSalaReunion.addItem("(50�) SALA JUNTA (15 personas) ---> 09:00-09:50");
		comboSalaReunion.addItem("(50�) SALA JUNTA (15 personas) ---> 10:00-10:50");
		comboSalaReunion.addItem("(50�) SALA JUNTA (15 personas) ---> 11:00-11:50");
		comboSalaReunion.addItem("(30�) SALA PETIT COMIT� (3 personas) ---> 09:00-09:50");
		comboSalaReunion.addItem("(30�) SALA PETIT COMIT� (3 personas) ---> 10:00-10:50");
		comboSalaReunion.addItem("(30�) SALA PETIT COMIT� (3 personas) ---> 11:00-11:50");
		comboSalaReunion.addItem("(120�) SALA CONVENCION EQUIPADA ---> 09:00-09:50");
		comboSalaReunion.addItem("(120�) SALA CONVENCION EQUIPADA ---> 10:00-10:50");
		comboSalaReunion.addItem("(120�) SALA CONVENCION EQUIPADA ---> 11:00-11:50");
		comboSalaReunion.addItem("(70�) SALA JUNTA EQUIPADA ---> 09:00-09:50");
		comboSalaReunion.addItem("(70�) SALA JUNTA EQUIPADA ---> 10:00-10:50");
		comboSalaReunion.addItem("(70�) SALA JUNTA EQUIPADA ---> 11:00-11:50");
		comboSalaReunion.addItem("(50�) SALA PETIT COMIT� EQUIPADA ---> 09:00-09:50");
		comboSalaReunion.addItem("(50�) SALA PETIT COMIT� EQUIPADA ---> 10:00-10:50");
		comboSalaReunion.addItem("(50�) SALA PETIT COMIT� EQUIPADA ---> 11:00-11:50");
		//AL ELEGIR UNA SE GUARDA LA HORA EN UN FICHERO Y CONTINUAMOS CON LA RESERVA
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboSalaReunion.getSelectedItem().equals("(80�) SALA CONVENCION (100 personas) ---> 09:00-09:50")) {
					bd.escribirFichero("horaPista", "09:00-09:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "SALA CONVENCION");
				}else if(comboSalaReunion.getSelectedItem().equals("(80�) SALA CONVENCION (100 personas) ---> 10:00-10:50")) {
					bd.escribirFichero("horaPista", "10:00-10:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "SALA CONVENCION");
				}else if(comboSalaReunion.getSelectedItem().equals("(80�) SALA CONVENCION (100 personas) ---> 11:00-11:50")) {
					bd.escribirFichero("horaPista", "11:00-11:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "SALA CONVENCION");
				    
				}else if(comboSalaReunion.getSelectedItem().equals("(50�) SALA JUNTA (15 personas) ---> 09:00-09:50")) {
					bd.escribirFichero("horaPista", "09:00-09:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "SALA JUNTA");
				}else if(comboSalaReunion.getSelectedItem().equals("(50�) SALA JUNTA (15 personas) ---> 10:00-10:50")) {
					bd.escribirFichero("horaPista", "10:00-10:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "SALA JUNTA");
				}else if(comboSalaReunion.getSelectedItem().equals("(50�) SALA JUNTA (15 personas) ---> 11:00-11:50")) {
					bd.escribirFichero("horaPista", "11:00-11:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "SALA JUNTA");
				    
				}else if(comboSalaReunion.getSelectedItem().equals("(30�) SALA PETIT COMIT� (3 personas) ---> 09:00-09:50")) {
					bd.escribirFichero("horaPista", "09:00-09:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 30, "SALA PETIT COMIT�");
				}else if(comboSalaReunion.getSelectedItem().equals("(30�) SALA PETIT COMIT� (3 personas) ---> 10:00-10:50")) {
					bd.escribirFichero("horaPista", "10:00-10:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 30, "SALA PETIT COMIT�");
				}else if(comboSalaReunion.getSelectedItem().equals("(30�) SALA PETIT COMIT� (3 personas) ---> 11:00-11:50")) {
					bd.escribirFichero("horaPista", "11:00-11:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 30, "SALA PETIT COMIT�");
				    
				}else if(comboSalaReunion.getSelectedItem().equals("(120�) SALA CONVENCION EQUIPADA ---> 09:00-09:50")) {
					bd.escribirFichero("horaPista", "09:00-09:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 120, "SALA CONVENCION EQUIPADA");
				}else if(comboSalaReunion.getSelectedItem().equals("(120�) SALA CONVENCION EQUIPADA ---> 10:00-10:50")) {
					bd.escribirFichero("horaPista", "10:00-10:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 120, "SALA CONVENCION EQUIPADA");
				}else if(comboSalaReunion.getSelectedItem().equals("(120�) SALA CONVENCION EQUIPADA ---> 11:00-11:50")) {
					bd.escribirFichero("horaPista", "11:00-11:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 120, "SALA CONVENCION EQUIPADA");
				    
				}else if(comboSalaReunion.getSelectedItem().equals("(70�) SALA JUNTA EQUIPADA ---> 09:00-09:50")) {
					bd.escribirFichero("horaPista", "09:00-09:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 70, "SALA JUNTA EQUIPADA");
				}else if(comboSalaReunion.getSelectedItem().equals("(70�) SALA JUNTA EQUIPADA ---> 10:00-10:50")) {
					bd.escribirFichero("horaPista", "10:00-10:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 70, "SALA JUNTA EQUIPADA");
				}else if(comboSalaReunion.getSelectedItem().equals("(70�) SALA JUNTA EQUIPADA ---> 11:00-11:50")) {
					bd.escribirFichero("horaPista", "11:00-11:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 70, "SALA JUNTA EQUIPADA");
				    
				}else if (comboSalaReunion.getSelectedItem().equals("(50�) SALA PETIT COMIT� EQUIPADA ---> 09:00-09:50")) {
					bd.escribirFichero("horaPista", "09:00-09:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "SALA PETIT COMIT� EQUIPADA");
				}else if (comboSalaReunion.getSelectedItem().equals("(50�) SALA PETIT COMIT� EQUIPADA ---> 10:00-10:50")) {
					bd.escribirFichero("horaPista", "10:00-10:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "SALA PETIT COMIT� EQUIPADA");
				}else if (comboSalaReunion.getSelectedItem().equals("(50�) SALA PETIT COMIT� EQUIPADA ---> 11:00-11:50")) {
					bd.escribirFichero("horaPista", "11:00-11:50");
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "SALA PETIT COMIT� EQUIPADA");
				}else {
					logger.info("TIENES QUE ELEGIR UN SERVICIO");
					VentanaDeporte vd = new VentanaDeporte(cliente);
				}
				
				dispose();
			}
		});
		
		add(salaReunion);
		add(comboSalaReunion);
		add(continuar);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio Sala Reunion");
		setSize(800, 200);
		setVisible(true);

	}
}
