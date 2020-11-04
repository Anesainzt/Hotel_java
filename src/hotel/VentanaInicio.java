package hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;

import com.toedter.calendar.JCalendar;

public class VentanaInicio extends JFrame{
	
	JLabel usuario;
	JTextField u;
	JLabel password;
	JTextField p;
	JButton registro;
	JButton continuar;
	Cliente cliente;
	
	public VentanaInicio() {
		
		setLayout(new GridLayout(3, 1));
		
		usuario = new JLabel("USUARIO");
		u = new JTextField();
		password = new JLabel("CONTRASEÑA");
		p = new JTextField();
		registro = new JButton("REGISTRARSE");
		continuar = new JButton("CONTINUAR");
		
		//EL BOTON REGISTRO TE LLEVA A LA VENTANA REGISTRO PARA RECOGER TUS DATOS DE REGISTRO
		registro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro vr = new VentanaRegistro(cliente);
				dispose();
			}
		});
		
		//CUANDO LE DES A CONTINUAR, LA BASE DE DATOS SABRA SI ERES CLIENTE O EMPLEADO.
		continuar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//CON LA BASE DE DATOS SABREMOS SI ES UN EMPLEADO O UN CLIENTE
			}
		});
		
		add(usuario);
		add(u);
		add(password);
		add(p);
		add(registro);
		add(continuar);
					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Identificación del cliente");
		setSize(800, 200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		VentanaInicio vi = new VentanaInicio();
		
	}

}
