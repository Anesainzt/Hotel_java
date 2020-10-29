package hotel;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class VentanaRegistro extends JFrame{
	JLabel nombre;
	JTextField n;
	JLabel apellidos;
	JTextField a;
	JLabel DNI;
	JTextField D;
	JLabel edad;
	JTextField e;
	JLabel tarjeta;
	JTextField t;
	JButton continuar;
	
	public VentanaRegistro(Cliente cliente) {
		
		setLayout(new GridLayout(6, 2));
		
		nombre = new JLabel("NOMBRE");
		n = new JTextField();
		apellidos = new JLabel("APELLIDOS");
		a = new JTextField();
		DNI = new JLabel("DNI");
		D = new JTextField();
		edad = new JLabel("EDAD");
		e = new JTextField();
		tarjeta = new JLabel("TARJETA");
		t = new JTextField();
		continuar = new JButton("CONTINUAR");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente nuevo;
				VentanaCreacionRegistro vcr = new VentanaCreacionRegistro(cliente);
				
				if (cliente != null) {
					nuevo = cliente;
				} else {
					nuevo = new Cliente();
				}
				
				nuevo.setNombre(n.getText());
				nuevo.setApellido(a.getText());
				nuevo.setDNI(D.getText());
				nuevo.setTarjeta(t.getText());
				
				int contador = 1;
				try {
					Scanner sc = new Scanner(new FileInputStream("datos"));
					while(sc.hasNext()) {
						contador = contador + 1;
						String linea = sc.nextLine();
					}
					
				}catch(FileNotFoundException e1) {
					System.err.println("ERROR");
				}
				
				PrintWriter pw = null;
				try {
				    pw = new PrintWriter(new BufferedWriter(new FileWriter("datos", true)));
				    pw.print("");
				    pw.println(contador + ";" + nuevo.getNombre() + ";" + nuevo.getApellido() + ";" + nuevo.getDNI() + ";" + nuevo.getTarjeta());
				} catch (IOException e1) {
				    System.err.println(e1);
				} finally {
				    if (pw != null) {
				        pw.close();
				    }
				}
			}
		});
		
		
		
		add(nombre);
		add(n);
		add(apellidos);
		add(a);
		add(DNI);
		add(D);
		add(edad);
		add(e);
		add(tarjeta);
		add(t);
		add(continuar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro del cliente");
		setSize(800, 200);
		setVisible(true);
		
	}

}
