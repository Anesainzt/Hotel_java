package hotel;

import java.util.ArrayList;

public class Cliente extends Ticket{
	protected static String nombre;
	protected static String apellido;
	protected static String dni;
	protected static int edad;
	protected static String tarjeta;
	protected static String login;
	protected static String password;
	protected static String newPassword;
	protected static ArrayList<String> ticket = new ArrayList();
	
	public Cliente(String nombre, String apellido, String dni, int edad, String tarjeta, String login, String password, String newPassword, ArrayList<String> ticket) {
		
		Cliente.nombre = nombre;
		Cliente.apellido = apellido;
		Cliente.dni = dni;
		Cliente.edad = edad;
		Cliente.tarjeta = tarjeta;
		Cliente.login = login;
		Cliente.password = password;
		Cliente.newPassword = newPassword;
		Cliente.ticket = ticket;
		
	}


	public Cliente() {
		
		Cliente.nombre = "";
		Cliente.apellido = "";
		Cliente.dni = "";
		Cliente.edad = 0;
		Cliente.tarjeta = "";
		Cliente.login = "";
		Cliente.password = "";
		Cliente.newPassword = "";
		Cliente.ticket = null;
	}
	
	public Cliente(Cliente c) {
		Cliente.nombre = c.nombre;
		Cliente.apellido = c.apellido;
		Cliente.dni = c.dni;
		Cliente.edad = c.edad;
		Cliente.tarjeta = c.tarjeta;
		Cliente.login = c.login;
		Cliente.password = c.password;
		Cliente.newPassword = c.newPassword;
		Cliente.ticket = c.ticket;
	}

	public static String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		Cliente.nombre = nombre;
	}

	public static String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		Cliente.apellido = apellido;
	}
	
	public static String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		Cliente.dni = dni;
	}
	
	public static int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		Cliente.edad = edad;
	}
	
	public static String getTarjeta() {
		return tarjeta;
	}
	
	public void setTarjeta(String tarjeta) {
		Cliente.tarjeta = tarjeta;
	}
	
	public static String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		Cliente.login = login;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		Cliente.password = password;
	}
	
	public static String getNewPassword() {
		return newPassword;
	}
	
	public void setNewPassword(String newPassword) {
		Cliente.newPassword = newPassword;
	}


	public static ArrayList<String> getTicket() {
		return ticket;
	}


	public static void setTicket(ArrayList<String> ticket) {
		Cliente.ticket = ticket;
	}
	
	
}