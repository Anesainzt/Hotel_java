package hotel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class VentanaCreacionRegistro extends JFrame{
	JLabel login;
	JTextField l;
	JLabel password;
	JTextField p;
	JLabel newPassword;
	JTextField np;
	JButton continuar;
	
	public VentanaCreacionRegistro(Cliente cliente) {
		
		setLayout(new GridLayout(4, 2));
		
		login = new JLabel("USUARIO (Introducir e-mail)");
		l = new JTextField();
		password = new JLabel("CONREASEÑA");
		p = new JTextField();
		newPassword = new JLabel("REPETIR CONTRASEÑA");
		np = new JTextField();
		
		continuar = new JButton("CONTINUAR");
		
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//VentanaEleccionHabitacion veh = new VentanaEleccionHabitacion(cliente);
				
				Cliente nuevo;
				
				if (cliente != null) {
					nuevo = cliente;
				} else {
					nuevo = new Cliente();
				}
				
				nuevo.setLogin(l.getText());
				nuevo.setPassword(p.getText());
				nuevo.setNewPassword(np.getText());
				
				int contador = 1;
				try {
					Scanner sc = new Scanner(new FileInputStream("LoginPassword"));
					while(sc.hasNext()) {
						contador = contador + 1;
						String linea = sc.nextLine();
					}
					
				}catch(FileNotFoundException e1) {
					System.err.println("ERROR");
				}
				
				PrintWriter pw = null;
				try {
				    pw = new PrintWriter(new BufferedWriter(new FileWriter("LoginPassword", true)));
				    pw.print("");
				    if(nuevo.getPassword().equals(nuevo.getNewPassword())) {
				    	pw.println(contador + ";" + nuevo.getLogin() + ";" + nuevo.getPassword());
				    }else {
				    	System.err.println("LAS CONREASEÑAS NO COINCIDEN");
				    	VentanaCreacionRegistro vcr = new VentanaCreacionRegistro(cliente);
				    }
				    
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