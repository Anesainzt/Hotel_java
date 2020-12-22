package ventanas;

import javax.swing.JFrame;

import hotel.Cliente;

public class VentanaFactura extends JFrame {
	
	public VentanaFactura(Cliente cliente) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Factura");
		pack();
		setVisible(true);
	}
	
	/*
	JLabel factura;
	JLabel nombre;
	JLabel apellidos;
	JLabel dni;
	
	JLabel cantidad;
	JLabel productos;
	JLabel precio;
	JLabel precioTotal;
	
	JLabel cantDias;
	JLabel habitacion;
	JLabel precioHabitacion;
	JLabel precioTotHabitacion;
	
	JLabel cantComida;
	JLabel servicioComida;
	JLabel precioComida;
	JLabel precioTotComida;
	
	JLabel cantSpa;
	JLabel servicioSpa;
	JLabel precioSpa;
	JLabel precioTotSpa;
	
	JLabel cantDeporte;
	JLabel servicioDeporte;
	JLabel precioDeporte;
	JLabel precioTotDeporte;
	
	JLabel cantMiniBar;
	JLabel servicioMiniBar;
	JLabel precioMiniBar;
	JLabel precioTotMiniBar;
	
	JLabel cantSala;
	JLabel servicioSalaReunion;
	JLabel precioSala;
	JLabel precioTotSala;
	
	JLabel subtotal;
	JLabel iva;
	JLabel total;
	JButton salir;
	
	public VentanaFactura(){
		setLayout(new GridLayout(9, 4));		
		
		factura = new JLabel("     FACTURA");
		nombre = new JLabel("NOMBRE");
		apellidos = new JLabel("APELLIDO");
		dni = new JLabel("DNI");
		
		cantidad = new JLabel("     CANTIDAD");
		productos = new JLabel("PRODUCTOS");
		precio = new JLabel("PRECIO");
		precioTotal = new JLabel("PRECIO TOTAL");
		
		cantDias = new JLabel("     DIAS HAB.");
		habitacion = new JLabel("TIPO HAB.");
		precioHabitacion = new JLabel("PRECIO HAB.");
		precioTotHabitacion = new JLabel("PRECIO TOTAL HAB.");
		
		cantComida = new JLabel("     11");
		servicioComida = new JLabel("SERVICIO COMIDA");
		precioComida = new JLabel("     12");
		precioTotComida = new JLabel("     13");
		
		cantSpa = new JLabel("     21");
		servicioSpa = new JLabel("SERVICIO SPA");
		precioSpa = new JLabel("     22");
		precioTotSpa = new JLabel("     23");
		
		cantDeporte = new JLabel("     31");
		servicioDeporte = new JLabel("SERVICIO DEPORTE");
		precioDeporte = new JLabel("     32");
		precioTotDeporte = new JLabel("     33");
		
		cantMiniBar = new JLabel("     41");
		servicioMiniBar = new JLabel("SERVICIO MINI-BAR");
		precioMiniBar = new JLabel("     42");
		precioTotMiniBar = new JLabel("     43");
		
		cantSala = new JLabel("     51");
		servicioSalaReunion = new JLabel("SERVICIO SALA REUNION");
		precioSala = new JLabel("     52");
		precioTotSala = new JLabel("     53");
		
		subtotal = new JLabel("     X");
		iva = new JLabel("     Y");
		total = new JLabel("     Z");	
		salir = new JButton("SALIR");
		
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		

		add(factura);
		add(nombre);
		add(apellidos);
		add(dni);
		
		add(cantidad);
		add(productos);
		add(precio);
		add(precioTotal);
		
		add(cantDias);
		add(habitacion);
		add(precioHabitacion);
		add(precioTotHabitacion);
		
		add(cantComida);
		add(servicioComida);
		add(precioComida);
		add(precioTotComida);
		
		add(cantSpa);
		add(servicioSpa);
		add(precioSpa);
		add(precioTotSpa);
		
		add(cantDeporte);
		add(servicioDeporte);
		add(precioDeporte);
		add(precioTotDeporte);
		
		add(cantMiniBar);
		add(servicioMiniBar);
		add(precioMiniBar);
		add(precioTotMiniBar);
		
		add(cantSala);
		add(servicioSalaReunion);
		add(precioSala);
		add(precioTotSala);
		
		
		add(subtotal);
		add(iva);
		add(total);
		add(salir);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Factura");
		pack();
		setVisible(true);
		
	}
	*/
}
