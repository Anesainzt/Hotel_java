package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import hotel.Cliente;

public class VentanaComida extends JFrame{

	JComboBox<String> comboComida;
	JLabel comida;
	JButton continuar;
	
	public VentanaComida(Cliente cliente, int pago) {
		setLayout(new GridLayout(3, 1));
		
		comboComida = new JComboBox<String>();
		
		comida = new JLabel("COMIDA: ");
		continuar = new JButton("ELEGIR RESTAURANTE");
		
		comboComida.addItem("MCDONALDS ---> 30€");
		comboComida.addItem("BURGER KING ---> 30€");
		comboComida.addItem("FOSTERS HOLLYWOOD ---> 40€");
		comboComida.addItem("POMODORO ---> 45€");
		comboComida.addItem("FOODOO ---> 50€");
		comboComida.addItem("DONGA ---> 60€");
		comboComida.addItem("MENU DEL DIA HOTEL ---> 150€");
		comboComida.addItem("BUFFET HOTEL ---> 110€");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		add(comida);
		add(comboComida);
		add(continuar);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio Comida");
		setSize(800, 200);
		setVisible(true);

	}
	
}
