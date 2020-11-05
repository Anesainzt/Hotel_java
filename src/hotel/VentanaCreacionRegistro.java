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
		password = new JLabel("CONREASE�A");
		p = new JTextField();
		newPassword = new JLabel("REPETIR CONTRASE�A");
		np = new JTextField();
		
		continuar = new JButton("CONTINUAR");
		
		//EL USUARIO INTRODUCE UN USUARIO Y UNA CONTRASE�A PARA LA PROXIMA VEZ
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Cliente nuevo;
				
				if (cliente != null) {
					nuevo = cliente;
				} else {
					nuevo = new Cliente();
				}
				
				//SI LOS DATOS ESTAN VACIOS NO SE PODR� CONTINUAR
				if(l.getText().length() == 0 || p.getText().length() == 0 || np.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "DEBES RELLENAR TODOS LOS DATOS");
					VentanaCreacionRegistro vcr = new VentanaCreacionRegistro(cliente);
					dispose();
				}else {
					//SI LAS CONTRASE�AS SON IGUALES...
					if(p.getText().equals(np.getText())) {
						//CUANDO RELLENE LOS DATOS LE LLEVARA A LA ELECCION DE LA HABITACION QUE DESEA RESERVAR
						VentanaEleccionHabitacion veh = new VentanaEleccionHabitacion(cliente);
						nuevo.setLogin(l.getText());
						nuevo.setPassword(p.getText());
						nuevo.setNewPassword(np.getText());
						dispose();
				    }else {
				    	//EN CASO CONTRARIO DEBERA REPETIRLAS
				    	JOptionPane.showMessageDialog(null, "LAS CONTRASE�AS NO COINCIDEN");
				    	dispose();
				    	VentanaCreacionRegistro vcr = new VentanaCreacionRegistro(cliente);
				    }
					
				}
				
				//FICHERO IGUAL QUE EL DE DATOS
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
				    pw.println(contador + ";" + nuevo.getLogin() + ";" + nuevo.getPassword());
				    
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