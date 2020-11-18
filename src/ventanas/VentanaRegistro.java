package ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

import hotel.Cliente;

public class VentanaRegistro extends JFrame{
	JLabel login;
	JTextField l;
	JLabel password;
	JTextField p;
	JLabel newPassword;
	JTextField np;
	JButton continuar;
	
	public VentanaRegistro(Cliente cliente) {
		
		setLayout(new GridLayout(4, 2));
		
		login = new JLabel("USUARIO (Introducir e-mail)");
		l = new JTextField();
		password = new JLabel("CONREASEÑA");
		p = new JTextField();
		newPassword = new JLabel("REPETIR CONTRASEÑA");
		np = new JTextField();
		
		continuar = new JButton("CONTINUAR");
		
		//EL USUARIO INTRODUCE UN USUARIO Y UNA CONTRASEÑA PARA LA PROXIMA VEZ
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Cliente nuevo;
				
				if (cliente != null) {
					nuevo = cliente;
				} else {
					nuevo = new Cliente();
				}
				
				//SI LOS DATOS ESTAN VACIOS NO SE PODRÁ CONTINUAR
				if(l.getText().length() == 0 || p.getText().length() == 0 || np.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "DEBES RELLENAR TODOS LOS DATOS");
					VentanaRegistro vcr = new VentanaRegistro(cliente);
					dispose();
				}else {
					//SI LAS CONTRASEÑAS SON IGUALES...
					if(p.getText().equals(np.getText())) {
						
						VentanaCreacionRegistro veh = new VentanaCreacionRegistro(cliente);
						nuevo.setLogin(l.getText());
						nuevo.setPassword(p.getText());
						nuevo.setNewPassword(np.getText());
						dispose();
				    }else {
				    	//EN CASO CONTRARIO DEBERA REPETIRLAS
				    	JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
				    	dispose();
				    	VentanaRegistro vcr = new VentanaRegistro(cliente);
				    }
					
				}
				
				//FICHERO IGUAL QUE EL DE DATOS
				
				try {
					Scanner sc = new Scanner(new FileInputStream("LoginPassword"));
					while(sc.hasNext()) {
						String linea = sc.nextLine();
					}
					
				}catch(FileNotFoundException e1) {
					System.err.println("ERROR");
				}
				
				PrintWriter pw = null;
				try {
				    pw = new PrintWriter(new BufferedWriter(new FileWriter("LoginPassword", true)));
				    pw.print("");
				    pw.println(nuevo.getLogin() + ";" + nuevo.getPassword());
				    
				} catch (IOException e1) {
				    System.err.println(e1);
				} finally {
				    if (pw != null) {
				        pw.close();
				    }
				}
			}
		});
		
		add(login);
		add(l);
		add(password);
		add(p);
		add(newPassword);
		add(np);
		add(continuar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro del cliente");
		setSize(800, 200);
		setVisible(true);
		
	}

}