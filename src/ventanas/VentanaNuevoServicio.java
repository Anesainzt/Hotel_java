package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import hotel.BD;
import hotel.BDException;
import hotel.Cliente;

public class VentanaNuevoServicio extends JFrame{

	JComboBox<String> comboReservas;
	List<String> reservas;
	BD bd;
	JPanel pnl;
	JButton elegir;
	
	static int precio = 0;
	static Logger logger = Logger.getLogger(VentanaNuevoServicio.class.getName());
	
	public static Date ParseFecha(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
        	logger.warning(ex.getMessage());
        }
        return fechaDate;
    }
	
	public VentanaNuevoServicio(Cliente cliente) {
		
		bd = new BD();
		pnl = new JPanel();
		try {
			bd.connect();
		} catch (BDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		comboReservas = new JComboBox<String>();
		reservas = new ArrayList<String>();
		reservas = bd.reservasHabitacionPosibles(cliente);
		elegir = new JButton("Elegir");
		
		
		for (String string : reservas) {
			comboReservas.addItem(string);
		}
		
		elegir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    
				String[] campos = comboReservas.getSelectedItem().toString().split("; ");
				
				String textBaseDatos = (campos[0] + ";" + campos[1] + ";" + campos[2] + ";" + Integer.parseInt(campos[3]));
				String textFechas = (campos[0] + ";" + campos[1]);
				bd.escribirFichero("baseDeDatos", textBaseDatos);
				bd.escribirFichero("fechas", textFechas);
				
				if (campos[2] == "VIP") {
					precio = 200;
				} else if(campos[2] == "DOBLE"){
					precio = 100;
				} else if(campos[2] == "INDIVIDUAL") {
					precio = 80;
				} else {
					precio = 130;
				}
				
				Date fechaEntrada = ParseFecha(campos[0]);
				Date fechaSalida = ParseFecha(campos[1]);
				long diff = fechaSalida.getTime() - fechaEntrada.getTime();
				
				String dias = Long.toString((diff / (1000L*60L*60L*24L)));
				
				bd.escribirFichero("datosFactura.txt", ";" + campos[2] + ";" + precio + ";" + dias);
				VentanaServicios vn = new VentanaServicios(cliente);
				
				dispose();
				
			}
		});
		
		pnl.add(comboReservas);
		pnl.add(elegir);
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		add(pnl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Elegir Reserva");
		setSize(500, 100);
		setVisible(true);
	
	}
}
