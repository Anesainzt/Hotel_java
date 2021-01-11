package ventanas;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;

import hotel.*;

public class VentanaEmpleado extends JFrame{
	
	public VentanaEmpleado(Empleado empleado) {
		
		JPanel documentos = new JPanel();
    	Border documentosBorder = BorderFactory.createTitledBorder("DOCUMENTOS");
    	documentos.setBorder(documentosBorder);
    	documentos.setLayout(new GridLayout(1, 5));
		
    	JButton BOE = new JButton("BOE");
    	BOE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File("BOE.pdf");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}
			}
		});
    	
    	JButton nomina = new JButton("NOMINA");
    	nomina.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    	
    	JButton justificante = new JButton("JUSTIFICANTE");
    	justificante.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    	
    	JButton calendarioAnual = new JButton("CALENDARIO ANUAL");
    	calendarioAnual.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if (Desktop.isDesktopSupported()) {
    				try {
    					File myFile = new File("calendarioAnual.pdf");
    					Desktop.getDesktop().open(myFile);
    				} catch (IOException ex) {
    					// no application registered for PDFs
    				}
    			}
    		}
    	});
    	
    	JButton salir = new JButton("SALIR");
    	salir.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    	
    	documentos.add(BOE);
    	documentos.add(justificante);
    	documentos.add(nomina);
    	documentos.add(calendarioAnual);
    	documentos.add(salir);
    	
    	JPanel informacion = new JPanel();
    	Border informacionBorder = BorderFactory.createTitledBorder("DOCUMENTOS");
    	informacion.setBorder(informacionBorder);
    	informacion.setLayout(new GridLayout(1, 5));
    	
    	//ASIER
    	
    	JLabel nombre = new JLabel("NOMBRE");
    	
    	informacion.add(nombre);
    	
    	JPanel trabajo = new JPanel();
    	Border trabajoBorder = BorderFactory.createTitledBorder("DOCUMENTOS");
    	trabajo.setBorder(trabajoBorder);
    	trabajo.setLayout(new GridLayout(1, 5));
    	
    	//ASIER
    	
    	JLabel algoRelevante = new JLabel("trabajo");
    	
    	trabajo.add(algoRelevante);
    	
    	JPanel main = new JPanel();
    	main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(documentos);
		main.add(informacion);
		main.add(trabajo);
    	
    	add(main);
    	
    	
		//nombre = new JLabel(empleado.getNombre());
		//apellido = new JLabel(empleado.getApellido());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ventana para empleados");
		setSize(800, 200);
		setVisible(true);
	}
	
	public static void main (String args[]) {
		Empleado e = new Empleado();
		VentanaEmpleado ve = new VentanaEmpleado(e);
	}
	
}
