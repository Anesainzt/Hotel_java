package ventanas;

import javax.swing.*;

import hotel.*;

public class VentanaEmpleado extends JFrame{

	JLabel nombre;
	JLabel apellido;
	JPanel pnl;
	
	public VentanaEmpleado(Empleado empleado) {
		
		nombre = new JLabel(empleado.getNombre());
		apellido = new JLabel(empleado.getApellido());
		pnl = new JPanel();
		
		
		
		pnl.add(nombre);
		pnl.add(apellido);
		add(pnl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ventana para empleados");
		setSize(800, 200);
		setVisible(true);
	}
	
}
