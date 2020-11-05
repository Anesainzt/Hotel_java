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
	JLabel dni;
	JTextField d;
	JLabel tarjeta;
	JTextField t;
	JButton continuar;
	
	public VentanaRegistro(Cliente cliente) {
		
		setLayout(new GridLayout(5, 2));
		
		nombre = new JLabel("NOMBRE");
		n = new JTextField();
		apellidos = new JLabel("APELLIDOS");
		a = new JTextField();
		dni = new JLabel("DNI");
		d = new JTextField();
		tarjeta = new JLabel("TARJETA");
		t = new JTextField();
		continuar = new JButton("CONTINUAR");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente nuevo;
				
				if (cliente != null) {
					nuevo = cliente;
				} else {
					nuevo = new Cliente();
				}

				//SI LOS DATOS ESTAN VACIOS, NO TE DEJA CONTINUAR, DEBES RELLENAR TODOS LOS DATOS
				if(n.getText().length() == 0 || a.getText().length() == 0 || d.getText().length() == 0 || t.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "DEBES RELLENAR TODOS LOS DATOS");
					VentanaRegistro vr = new VentanaRegistro(cliente);
					dispose();
				}else {
					//AL RELLENAR LOS DATOS, TE LLEVA A LA VENTANA PARA QUE GUARDES TU USUARIO Y CONTRASEÑA
					VentanaCreacionRegistro vcr = new VentanaCreacionRegistro(cliente);
					nuevo.setNombre(n.getText());
					nuevo.setApellido(a.getText());
					nuevo.setDni(d.getText());
					nuevo.setTarjeta(t.getText());
					dispose();
				}
				
				int contador = 1;
				
				//GUARDAMOS EN UN FICHERO LOS DATOS DEL CLIENTE
				try {
					//FICHERO DATOS, MIRAMOS SI HAY UNA LINEA SIGUIENTE PARA ESCRIBIR Y AÑADIMOS UN CONTADOR
					Scanner sc = new Scanner(new FileInputStream("datos"));
					while(sc.hasNext()) {
						contador = contador + 1;
						String linea = sc.nextLine();
					}
				//SI NO ENCUENTRA EL FICHERO DATOS ENTRA EN LA EXCEPCION
				}catch(FileNotFoundException e1) {
					System.err.println("ERROR");
				}
				
				//UNA VEZ ENCONTRADO EL FICHERO ESCRIBIMOS LOS DATOS
				PrintWriter pw = null;
				try {
				    pw = new PrintWriter(new BufferedWriter(new FileWriter("datos", true)));
				    pw.print("");
				    pw.println(contador + ";" + nuevo.getNombre() + ";" + nuevo.getApellido() + ";" + nuevo.getDni() + ";" + nuevo.getTarjeta());
				
				//SI NO SE PUEDE ESCRIBIR ENTRA EN LA EXCEPCION
				} catch (IOException e1) {
				    System.err.println(e1);
				    
				//SIEMPRE HAY QUE CERRAR EL FICHERO DESPUES DE ESCRIBIR
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
		add(dni);
		add(d);
		add(tarjeta);
		add(t);
		add(continuar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro del cliente");
		setSize(800, 200);
		setVisible(true);
		
	}

}