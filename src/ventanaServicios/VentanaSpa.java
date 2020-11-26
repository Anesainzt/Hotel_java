package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import hotel.Cliente;
import ventanas.VentanaReservaServicio;

public class VentanaSpa extends JFrame{
	
	JComboBox<String> comboSpa;
	JLabel spa;
	JButton continuar;
	
	public VentanaSpa(Cliente cliente, int pago) {
		setLayout(new GridLayout(3, 1));
		
		comboSpa = new JComboBox<String>();
		
		spa = new JLabel("SPA: ");
		continuar = new JButton("CONTINUAR");
				
		comboSpa.addItem("MASAJE FACIAL ---> 50€");
		comboSpa.addItem("MASAJE CORPORAL ---> 90€");
		comboSpa.addItem("MASAJE TOTAL ---> 130€");
		comboSpa.addItem("JACUZZI ---> 150€");
		comboSpa.addItem("SALES MINERALES ---> 60€");
		comboSpa.addItem("MASAJE PIEDRAS ---> 80€");
		comboSpa.addItem("TRATAMIENTO ESTETICO ---> 90€");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			    if(comboSpa.getSelectedItem().equals("MASAJE FACIAL ---> 50€")) {
			    	JOptionPane.showMessageDialog(null, pago + 50);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 50);
			    }else if(comboSpa.getSelectedItem().equals("MASAJE CORPORAL ---> 90€")) {
			    	JOptionPane.showMessageDialog(null, pago + 90);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 90);
			    }else if(comboSpa.getSelectedItem().equals("MASAJE TOTAL ---> 130€")) {
			    	JOptionPane.showMessageDialog(null, pago + 130);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 130);
			    }else if(comboSpa.getSelectedItem().equals("JACUZZI ---> 150€")) {
			    	JOptionPane.showMessageDialog(null, pago + 150);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 150);
			    }else if(comboSpa.getSelectedItem().equals("SALES MINERALES ---> 60€")) {
			    	JOptionPane.showMessageDialog(null, pago + 60);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 60);
			    }else if(comboSpa.getSelectedItem().equals("MASAJE PIEDRAS ---> 80€")) {
			    	JOptionPane.showMessageDialog(null, pago + 80);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 80);
			    }else{
			    	JOptionPane.showMessageDialog(null, pago + 90);
			    	VentanaReservaServicio vrs = new VentanaReservaServicio(cliente, pago + 90);
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
