package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import hotel.Cliente;
import ventanas.VentanaReservaServicio;

public class VentanaSalaReunion extends JFrame{

	JComboBox<String> comboSalaReunion;
	JLabel salaReunion;
	JButton continuar;
	
	public VentanaSalaReunion(Cliente cliente) {
		setLayout(new GridLayout(3, 1));
		
		comboSalaReunion = new JComboBox<String>();
		
		salaReunion = new JLabel("SALA REUNION: ");
		continuar = new JButton("ELEGIR SALA");
		
		comboSalaReunion.addItem("SALA CONVENCION (100 personas) ---> 80€");
		comboSalaReunion.addItem("SALA JUNTA (15 personas) ---> 50€");
		comboSalaReunion.addItem("SALA PETIT COMITÉ (3 personas) ---> 30€");
		comboSalaReunion.addItem("SALA CONVENCION EQUIPADA ---> 120€");
		comboSalaReunion.addItem("SALA JUNTA EQUIPADA ---> 70€");
		comboSalaReunion.addItem("SALA PETIT COMITÉ EQUIPADA ---> 50€");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboSalaReunion.getSelectedItem().equals("SALA CONVENCION (100 personas) ---> 80€")) {
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 80, "SALA CONVENCION");
				}else if(comboSalaReunion.getSelectedItem().equals("SALA JUNTA (15 personas) ---> 50€")) {
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "SALA JUNTA");
				}else if(comboSalaReunion.getSelectedItem().equals("SALA PETIT COMITÉ (3 personas) ---> 30€")) {
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 30, "SALA PETIT COMITÉ");
				}else if(comboSalaReunion.getSelectedItem().equals("SALA CONVENCION EQUIPADA ---> 120€")) {
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 120, "SALA CONVENCION EQUIPADA");
				}else if(comboSalaReunion.getSelectedItem().equals("SALA JUNTA EQUIPADA ---> 70€")) {
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 70, "SALA JUNTA EQUIPADA");
				}else if (comboSalaReunion.getSelectedItem().equals("SALA PETIT COMITÉ EQUIPADA ---> 50€")) {
				    VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, 50, "SALA PETIT COMITÉ EQUIPADA");
				}else {
					System.out.println("TIENES QUE ELEGIR UN SERVICIO");
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
