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

public class VentanaDeporte extends JFrame{

	JComboBox<String> comboDeporte;
	JLabel deporte;
	JButton elegir;
	
	public VentanaDeporte(Cliente cliente, int pago) {
		setLayout(new GridLayout(3, 1));
		
		comboDeporte = new JComboBox<String>();
		
		deporte = new JLabel("DEPORTE: ");
		elegir = new JButton("ELEGIR PISTA");
		
		comboDeporte.addItem("PISTA TENNIS ---> 15€/hora");
		comboDeporte.addItem("PISTA PADDLE ---> 15€/hora");
		comboDeporte.addItem("PISCINA NATACION ---> 10€/hora");
		comboDeporte.addItem("CAMPO FUTBOL ---> 20€/hora");
		comboDeporte.addItem("CAMPO BALONCESTO ---> 20€/hora");
		comboDeporte.addItem("PISTA ATLETISMO ---> 10€/hora");
		comboDeporte.addItem("CAMPO FUTBOL-SALA ---> 15€/hora");
		
		comboDeporte.addItem("CLASE TENNIS ---> 30€/hora");
		comboDeporte.addItem("CLASE PADDLE ---> 30€/hora");
		comboDeporte.addItem("CLASE NATACION ---> 15€/hora");
		comboDeporte.addItem("CLASE FUTBOL ---> 30€/hora");
		comboDeporte.addItem("CLASE BALONCESTO ---> 30€/hora");
		comboDeporte.addItem("CLASE ATLETISMO ---> 15€/hora");
		comboDeporte.addItem("CLASE FUTBOL-SALA ---> 20€/hora");
		
		elegir.addActionListener(new ActionListener() {
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
		
		add(deporte);
		add(comboDeporte);
		add(elegir);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio Deportes");
		setSize(800, 200);
		setVisible(true);

	}
}
