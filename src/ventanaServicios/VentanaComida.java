package ventanaServicios;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
				Cliente nuevo;
				
				if (cliente != null) {
					nuevo = cliente;
				} else {
					nuevo = new Cliente();
				}
				
				int contador = 1;
				try {
					Scanner sc = new Scanner(new FileInputStream("Servicios"));
					while(sc.hasNext()) {
						contador = contador + 1;
						String linea = sc.nextLine();
					}
					
				}catch(FileNotFoundException e1) {
					System.err.println("ERROR");
				}
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
