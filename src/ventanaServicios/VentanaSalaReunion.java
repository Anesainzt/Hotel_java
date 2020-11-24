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

public class VentanaSalaReunion extends JFrame{

	JComboBox<String> comboSalaReunion;
	JLabel salaReunion;
	JButton continuar;
	
	public VentanaSalaReunion(Cliente cliente, int pago) {
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
		
		add(salaReunion);
		add(comboSalaReunion);
		add(continuar);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Servicio Sala Reunion");
		setSize(800, 200);
		setVisible(true);

	}
}
