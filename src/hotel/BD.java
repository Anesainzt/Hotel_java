package hotel;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import ventanas.VentanaContinuacion;
import ventanas.VentanaReservaPista;

public class BD extends JFrame{
	private Connection conn = null; 
	
	public void escribirFichero(String fichero, String texto) {
		PrintWriter pw = null;
		try {
		    pw = new PrintWriter(new BufferedWriter(new FileWriter(fichero, true)));
		    pw.print(texto);
		    
		} catch (IOException e1) {
		    System.err.println(e1);
		} finally {
		    if (pw != null) {
		        pw.close();
		    }
		}
	}
	
	public void connect() throws BDException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:hotelJava.db");
		} catch (ClassNotFoundException e) {
			throw new BDException("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new BDException("Error conectando a la BD", e);
		}
	}
	
	public void disconnect() throws BDException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new BDException("Error cerrando la conexión con la BD", e);
		}
	}
	
	public void registro(Cliente nuevo) {
		try {			
			PreparedStatement pstmt = conn.prepareStatement("UPDATE cliente SET nombre = ?, apellido = ?, dni = ?, tarjeta = ? WHERE usuario = '"+ nuevo.getLogin() +"' AND contraseya = '"+ nuevo.getPassword() +"';");
			
			pstmt.setString(1, nuevo.getNombre());
			pstmt.setString(2, nuevo.getApellido());
			pstmt.setString(3, nuevo.getDni());
			pstmt.setString(4, nuevo.getTarjeta());
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		} 	
	}
	
	public void ponerAlDiaBD() {
		
		try(Statement stmt = (Statement) conn.createStatement();){
			JCalendar calendario = new JCalendar();
			String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
	    	String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
	    	String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
	    	String hoy = "";
			
			if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
				hoy = year + "0" + mes + "0" + dia;
	    	} else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
	    		hoy = year + "0" + mes + "" + dia;
	    	} else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
	    		hoy = year + "" + mes + "0" + dia;
	    	} else {
	    		hoy = year + "" + mes + "" + dia;
	    	}
			
			
			ResultSet rs = stmt.executeQuery("SELECT fechaSalida FROM historialregistros WHERE libre = 1;");
			while(rs.next()) {
				
				String fechaBDtext = rs.getString("fechaSalida");
				String[] campos = fechaBDtext.split("-");
				Integer fechaBD = Integer.parseInt(campos[0] + "" + campos[1] + "" +  campos[2]);
				Integer fechaHoy = Integer.parseInt(hoy);

				if (fechaBD < fechaHoy) {
					PreparedStatement pstmt = conn.prepareStatement("UPDATE historialregistros SET libre = ? WHERE fechaSalida = ?");
					
					pstmt.setInt(1, 0);
					pstmt.setString(2, fechaBDtext);
					pstmt.executeUpdate();
				}
				
			}
			
			ResultSet rs2 = stmt.executeQuery("SELECT fechaReserva FROM reservapista WHERE libre = 1;");
			while(rs.next()) {
				
				String fechaBDtext = rs2.getString("fechaReserva");
				String[] campos = fechaBDtext.split("-");
				Integer fechaBD = Integer.parseInt(campos[0] + "" + campos[1] + "" +  campos[2]);
				Integer fechaHoy = Integer.parseInt(hoy);

				if (fechaBD < fechaHoy) {
					PreparedStatement pstmt = conn.prepareStatement("UPDATE reservapista SET libre = ? WHERE fechaReserva = ?");
					
					pstmt.setInt(1, 0);
					pstmt.setString(2, fechaBDtext);
					pstmt.executeUpdate();
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void restartHabitacion() {
		try {
			PreparedStatement pstmt = conn.prepareStatement("UPDATE habitacion SET libre = ?");
			
			pstmt.setInt(1, 0);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Empleado empleado(String usu, String password) {
		Empleado emp = new Empleado();
		
		try(Statement stmt = (Statement) conn.createStatement()) {	
			
			ResultSet empleado = stmt.executeQuery("SELECT nombre, apellido, contraseya, usuario, departamento, salario, usuario_jefe, jefeBit FROM empleado WHERE (usuario = '" + usu + "' AND contraseya = '"+ password +"');");
			
			while(empleado.next()) {						
				String nombreBD = empleado.getString("nombre");
				String apellidoBD = empleado.getString("apellido");
				String contraseya = empleado.getString("contraseya");
				String usuario = empleado.getString("usuario");
				String departamento = empleado.getString("departamento");
				double salario = Double.parseDouble(empleado.getString("salario"));
				boolean jefe = false;
				if (empleado.getString("jefeBit") == "1") {
					jefe = true;
				}
				String usuarioJefe = empleado.getString("usuario_jefe");
				
				emp.setNombre(nombreBD);
				emp.setApellido(apellidoBD);
				emp.setPassword(contraseya);
				emp.setUsuario(usuario);
				emp.setDepartamento(departamento);
				emp.setSalario(salario);
				emp.setJefe(jefe);
				emp.setUsuarioJefe(usuarioJefe);
				
			}
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		} 
		return emp;
	}
	
public void pistasReservadasHoy(DefaultTableModel modelo) {
		
		JCalendar calendario = new JCalendar();
		String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
    	String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
    	String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
    	String hoy = "";
		
    	if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
			hoy = year + "-0" + mes + "-0" + dia;
    	} else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
    		hoy = year + "-0" + mes + "-" + dia;
    	} else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
    		hoy = year + "-" + mes + "-0" + dia;
    	} else {
    		hoy = year + "-" + mes + "-" + dia;
    	}
    	
		try(Statement stmt = (Statement) conn.createStatement()) {	
			
			String [] tabla = new String[5];
			
			ResultSet res = stmt.executeQuery("SELECT fechaReserva, hora, num_pista, usuario, tipo FROM reservapista WHERE fechaReserva = '"+ hoy +"'");
			while (res.next()) {
				
				String fila = res.getString("fechaReserva");
				tabla[0] = fila;
				fila = res.getString("hora");
				tabla[1] = fila;
				fila = res.getString("num_pista");
				tabla[2] = fila;
				fila = res.getString("usuario");
				tabla[3] = fila;
				fila = res.getString("tipo");
				tabla[4] = fila;
				modelo.addRow(tabla);
				
			}
			
			
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		}
	}
	
	public Cliente cliente(String usu, String password) {
		Cliente cl = new Cliente();
		try(Statement stmt = (Statement) conn.createStatement()) {
			
			ResultSet cliente = stmt.executeQuery("SELECT nombre, apellido, dni, contraseya, usuario FROM cliente WHERE (usuario = '" + usu + "' AND contraseya = '"+ password +"');");
			while(cliente.next()) {
				String nombreBD = cliente.getString("nombre");
				String apellidoBD = cliente.getString("apellido");
				String dniBD = cliente.getString("dni");
				String contraseya = cliente.getString("contraseya");
				String usuario = cliente.getString("usuario");
				
				cl.setNombre(nombreBD);
				cl.setApellido(apellidoBD);
				cl.setDni(dniBD);
				cl.setPassword(contraseya);
				cl.setLogin(usuario);
				
			}
			
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		}
		return cl;
	}
	
	public void historial(Cliente cliente, DefaultTableModel modelo) {
		try(Statement stmt = (Statement) conn.createStatement()) {	
			
			Integer numFilas = 0 ;
			ResultSet res1 = stmt.executeQuery("SELECT COUNT(usuario) numero FROM historialregistros WHERE usuario = '"+ cliente.getLogin() +"'");
			
			while (res1.next()) {
				numFilas = res1.getInt("numero");
			}
			
			String [] tabla = new String[3];
			
			
			int i = 0;
			ResultSet res2 = stmt.executeQuery("SELECT fechaEntrada, fechaSalida, tipo FROM historialregistros WHERE usuario = '"+ cliente.getLogin() +"'");
			while(res2.next()) {
				
				String fila = res2.getString("fechaEntrada");
				tabla[0] = fila;
				fila = res2.getString("fechaSalida");
				tabla[1] = fila;
				fila = res2.getString("tipo");
				tabla[2] = fila;
				modelo.addRow(tabla);
				if (i != numFilas) {
					i = i + 1;
				}
			}
			
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		}
	}
	
	public void calendario(String type, String dia, String mes, String year, String fechaInc) {
		try(Statement stmt = (Statement) conn.createStatement()) {
			
			String tipo = type;
			
			ResultSet res = stmt.executeQuery("SELECT fechaSalida, fechaEntrada, num_habitacion FROM historialregistros WHERE tipo = '"+ tipo +"' AND libre = 1");
			while(res.next()) {
				String fechaSalidaBD = res.getString("fechaSalida");
				String fechaEntradaBD = res.getString("fechaEntrada");
				int numero = res.getInt("num_habitacion");
				
				String[] partSalidaBD = fechaSalidaBD.split("-");
				
				String salidaBD = partSalidaBD[0] +partSalidaBD[1] +partSalidaBD[2];
				int compSalidaBD = Integer.parseInt(salidaBD);
				
				String salidaSelect = "";
				if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
					salidaSelect = year + "-0" + mes + "-0" + dia;
		    	 } else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
		    		 salidaSelect = year + "-0" + mes + "-" + dia;
		    	 } else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
		    		 salidaSelect = year + "-" + mes + "-0" + dia;
		    	 } else {
		    		 salidaSelect = year + "-" + mes + "-" + dia;
		    	 }
				
				String[] camposSalidaSelect = salidaSelect.split("-");
				
				String numSalidaSelect = camposSalidaSelect[0] + camposSalidaSelect[1] + camposSalidaSelect[2];
				
				int compSalidaSelect = Integer.parseInt(numSalidaSelect);
				
				String[] partEntradaBD = fechaEntradaBD.split("-");
				
				String entradaBD = partEntradaBD[0] +partEntradaBD[1] +partEntradaBD[2];
				
				int compEntradaBD = Integer.parseInt(entradaBD);
				
				String[] partEntrada = fechaInc.split("-");
				
				String entradaSelect = partEntrada[0] +partEntrada[1] +partEntrada[2];
				int compEntradaSelect = Integer.parseInt(entradaSelect);
				
				if ((compEntradaSelect < compEntradaBD && compSalidaSelect < compEntradaBD) || (compEntradaSelect > compSalidaBD && compSalidaSelect > compSalidaBD)){
				
					PreparedStatement pstmt = conn.prepareStatement("UPDATE habitacion SET libre = ? WHERE num_habitacion = ?");
						
					pstmt.setInt(1, 0);
					pstmt.setInt(2, numero);
					pstmt.executeUpdate();
					
				} else {
					PreparedStatement pstmt = conn.prepareStatement("UPDATE habitacion SET libre = ? WHERE num_habitacion = ?");
					
					pstmt.setInt(1, 1);
					pstmt.setInt(2, numero);
					pstmt.executeUpdate();
				}
			}
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public List<JButton> habitacion(JButton boton, String fechaEntrada, String fechaSalida, String tipo, JPanel habitaciones, Cliente cliente) {
		List<JButton> b = new ArrayList<JButton>();
		try(Statement stmt = (Statement) conn.createStatement()) {
			
			ResultSet res1 = stmt.executeQuery("SELECT num_habitacion, libre FROM habitacion WHERE tipo = '"+ tipo +"'");
			while (res1.next()) {
				String numero = res1.getString("num_habitacion");
				int libre = res1.getInt("libre");
				boton = new JButton(numero);
				if (libre == 0) {
					boton.setBackground(Color.GREEN);
					boton.setEnabled(true);
					
				} else {
					boton.setBackground(Color.RED);
					boton.setEnabled(false);	
				}
				b.add(boton);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public void servicio(String fechaEntrada, String fechaSalida, String tipo, String numero, Cliente cliente) {
		try(Statement stmt = (Statement) conn.createStatement()) {	
			
			int res2 = stmt.executeUpdate("INSERT INTO historialregistros VALUES('"+ fechaEntrada +"', '"+ fechaSalida +"', '"+ tipo +"', "+ Integer.parseInt(numero) +", '"+ cliente.getLogin() +"', 1);");
			
			
		} catch (SQLException e2) {
			e2.printStackTrace();;
		}
	}
	
	public ArrayList<Integer> updateOcupadasHoy(){
		ArrayList<Integer> habitacion = new ArrayList<Integer>();
		try(Statement stmt = (Statement) conn.createStatement();){
			JCalendar calendario = new JCalendar();
			String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
	    	String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
	    	String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
	    	String hoy = "";
			
			if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
				hoy = year + "0" + mes + "0" + dia;
	    	} else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
	    		hoy = year + "0" + mes + "" + dia;
	    	} else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
	    		hoy = year + "" + mes + "0" + dia;
	    	} else {
	    		hoy = year + "" + mes + "" + dia;
	    	}
			
			ResultSet rs = stmt.executeQuery("SELECT fechaEntrada, fechaSalida, num_habitacion FROM historialregistros WHERE libre = 1;");
			while(rs.next()) {
				String fechaEntradaBDtext = rs.getString("fechaEntrada");
				String fechaSalidaBDtext = rs.getString("fechaSalida");
				String[] campos = fechaSalidaBDtext.split("-");
				String[] campos1 = fechaEntradaBDtext.split("-");
				Integer fechaSalidaBD = Integer.parseInt(campos[0] + "" + campos[1] + "" +  campos[2]);
				Integer fechaEntradaBD = Integer.parseInt(campos1[0] + "" + campos1[1] + "" +  campos1[2]);
				Integer fechaHoy = Integer.parseInt(hoy);
				
				if(fechaHoy > fechaEntradaBD && fechaHoy < fechaSalidaBD) {
					habitacion.add(Integer.parseInt(rs.getString("num_habitacion")));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return habitacion;		
	}
	
	public List<Integer> getHabitacionesOcupadas(){
		List<Integer> listaHabitacion = null;
		try (Statement stmt = (Statement) conn.createStatement()){
			
			ResultSet num_habitacion = stmt.executeQuery("SELECT num_habitacion FROM habitacion WHERE libre = 1;");
			while (num_habitacion.next()) {
				listaHabitacion.add(num_habitacion.getInt("num_habitacion"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaHabitacion;
	}
	
	public String getHoraReserva() {
		
    	String linea = null;
		Scanner sc1 = null;
		String hora = "";
		try {
			sc1 = new Scanner(new FileInputStream("horaPista"));

			while(sc1.hasNext()) {
				linea = sc1.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return linea;
	}
	
	public void eleccionDePistasLibres(String fecha, String hora, String tipo){
		
		try (Statement stmt = (Statement) conn.createStatement()){
			ResultSet rs = stmt.executeQuery("SELECT num_pista, tipo FROM reservapista WHERE fechaReserva = '"+ fecha +"' AND hora = '"+ hora +"' AND libre = 1");
			while(rs.next()) {
				int numero = rs.getInt("num_pista");
				String tipoPista = rs.getString("tipo");
				
				PreparedStatement pstmt = conn.prepareStatement("UPDATE pista SET libre = ? WHERE num_pista = ? AND tipo = ?");
				pstmt.setInt(1, 1);
				pstmt.setInt(2, numero);
				pstmt.setString(3, tipoPista);
				pstmt.execute();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<JButton> botonesReservarPista(String tipo){
		List<JButton> listaBotones = new ArrayList<JButton>();
		JButton boton;
		String t = null;
		if (tipo.contains("PADDLE") == true) {
    		t = "PADDLE";
		}else if(tipo.contains("NATACION") == true){
			t = "NATACION";
		}else if(tipo.contains("BALONCESTO") == true){
			t = "BALONCESTO";
		}else {
			t = "FUTBOL-SALA";
		}
		try (Statement stmt = (Statement) conn.createStatement()){
			
			ResultSet rs = stmt.executeQuery("SELECT num_pista, libre FROM pista WHERE tipo = '"+ t +"'");
			
			while(rs.next()) {
				int numero = rs.getInt("num_pista");
				int libre = rs.getInt("libre");
				
				boton = new JButton("" + numero);
				if (libre == 0) {
					boton.setBackground(Color.GREEN);
					boton.setEnabled(true);
					
				} else {
					boton.setBackground(Color.RED);
					boton.setEnabled(false);	
				}
				listaBotones.add(boton);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaBotones;
	}
	
	public void registrarReservaPista(Cliente cliente, String fecha, String hora, String num, String tipo) {
		String t = null;
		if (tipo.contains("PADDLE") == true) {
    		t = "PADDLE";
		}else if(tipo.contains("NATACION") == true){
			t = "NATACION";
		}else if(tipo.contains("BALONCESTO") == true){
			t = "BALONCESTO";
		}else {
			t = "FUTBOL-SALA";
		}
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO reservapista VALUES(?, ?, ?, ?, ?, ?);");
			
			pstmt.setString(1, fecha);
			pstmt.setString(2, hora);
			pstmt.setInt(3, Integer.parseInt(num));
			pstmt.setString(4, t);
			pstmt.setInt(5, 1);
			pstmt.setString(6, cliente.getLogin());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void restartPistas() {
		try {
			PreparedStatement pstmt = conn.prepareStatement("UPDATE pista SET libre = ?;");
			pstmt.setInt(1, 0);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void eleccionClaseDeporte(Cliente cliente, String fecha, String tipo) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO clases VALUES(?, ?, ?);");
			
			pstmt.setString(1, fecha);
			pstmt.setString(2, tipo);
			pstmt.setString(3, cliente.getLogin());

			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<JTextArea> clasesHoy(JTextArea paddel, JTextArea natacion, JTextArea futbolSala, JTextArea baloncesto) {
		
		List<JTextArea> textosClases = new ArrayList<JTextArea>();
		
		JCalendar calendario = new JCalendar();
		String year = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
    	String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
    	String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
    	String hoy = "";
		String text = "";
    	if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) < 10) {
			hoy = year + "-0" + mes + "-0" + dia;
    	} else if (Integer.parseInt(mes) < 10 && Integer.parseInt(dia) >= 10) {
    		hoy = year + "-0" + mes + "-" + dia;
    	} else if (Integer.parseInt(mes) >= 10 && Integer.parseInt(dia) < 10) {
    		hoy = year + "-" + mes + "-0" + dia;
    	} else {
    		hoy = year + "-" + mes + "-" + dia;
    	}
		try (Statement stmt = (Statement) conn.createStatement()){
			
			ResultSet res1 = stmt.executeQuery("SELECT usuario FROM clases WHERE fechaClase = '"+ hoy +"' AND tipo = 'CLASE PADDEL'");
			while(res1.next()) {
				text =  text + res1.getString("usuario");
				text = text + "\n";
			}
			paddel.setText(text);
			text = "";
			textosClases.add(paddel);
			ResultSet res2 = stmt.executeQuery("SELECT usuario FROM clases WHERE fechaClase = '"+ hoy +"' AND tipo = 'CLASE NATACION'");
			while(res1.next()) {
				text =  text + res1.getString("usuario");
				text = text + "\n";
			}
			natacion.setText(text);
			text = "";
			textosClases.add(natacion);
			ResultSet res3 = stmt.executeQuery("SELECT usuario FROM clases WHERE fechaClase = '"+ hoy +"' AND tipo = 'CLASE BALONCESTO'");
			while(res1.next()) {
				text =  text + res1.getString("usuario");
				text = text + "\n";
			}
			baloncesto.setText(text);
			text = "";
			textosClases.add(baloncesto);
			ResultSet res4 = stmt.executeQuery("SELECT usuario FROM clases WHERE fechaClase = '"+ hoy +"' AND tipo = 'CLASE FUTBOL_SALA'");
			while(res1.next()) {
				text =  text + res1.getString("usuario");
				text = text + "\n";
			}
			futbolSala.setText(text);
			textosClases.add(futbolSala);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return textosClases;
		
	}
	
}
