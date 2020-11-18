package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hotel.Cliente;

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
