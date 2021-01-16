package hotel;

import java.util.ArrayList;
import java.util.HashMap;

public class Cliente{
	protected static String nombre;
	protected static String apellido;
	protected static String dni;
	protected static String fecha_ncto;
	protected static String tarjeta;
	protected static String login;
	protected static String password;
	protected static String newPassword;
	protected static HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
	protected static ArrayList<String> comida = new ArrayList<String>();
	protected static ArrayList<String> deporte = new ArrayList<String>();
	protected static ArrayList<String> miniBar = new ArrayList<String>();
	protected static ArrayList<String> salaReunion = new ArrayList<String>();
	protected static ArrayList<String> spa = new ArrayList<String>();
	
	public Cliente(String nombre, String apellido, String dni, String fecha_ncto, String tarjeta, String login, String password, String newPassword, HashMap<String, Integer> hashmap, ArrayList<String> comida, ArrayList<String> deporte, ArrayList<String> miniBar, ArrayList<String> salaReunion, ArrayList<String> spa) {
		
		Cliente.nombre = nombre;
		Cliente.apellido = apellido;
		Cliente.dni = dni;
		Cliente.fecha_ncto = fecha_ncto;
		Cliente.tarjeta = tarjeta;
		Cliente.login = login;
		Cliente.password = password;
		Cliente.newPassword = newPassword;
		Cliente.hashmap = hashmap;
		Cliente.comida = comida;
		Cliente.deporte = deporte;
		Cliente.miniBar = miniBar;
		Cliente.salaReunion = salaReunion;
		Cliente.spa = spa;
	}


	public Cliente() {
		
		Cliente.nombre = "";
		Cliente.apellido = "";
		Cliente.dni = "";
		Cliente.fecha_ncto = "";
		Cliente.tarjeta = "";
		Cliente.login = "";
		Cliente.password = "";
		Cliente.newPassword = "";
		Cliente.hashmap = new HashMap <String, Integer>();
		Cliente.comida = new ArrayList <String>();
		Cliente.deporte = new ArrayList <String>();
		Cliente.miniBar = new ArrayList <String>();
		Cliente.salaReunion = new ArrayList <String>();
		Cliente.spa = new ArrayList <String>();
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
	
	public static String getFechaNcto() {
		return fecha_ncto;
	}
	
	public void setFechaNcto(String fecha_ncto) {
		Cliente.fecha_ncto = fecha_ncto;
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

	public static HashMap<String, Integer> getHashmap() {
		return hashmap;
	}

	public static void setHashmap(HashMap<String, Integer> hashmap) {
		Cliente.hashmap = hashmap;
	}
	
	public static ArrayList<String> getComida() {
		return comida;
	}
	
	public static void setComida(ArrayList<String> comida) {
		Cliente.comida = comida;
	}
		
	public static ArrayList<String> getDeporte() {
		return deporte;
	}
	
	public static void setDeporte(ArrayList<String> deporte) {
		Cliente.deporte = deporte;
	}
	
	public static ArrayList<String> getMiniBar() {
		return miniBar;
	}
	
	public static void setMiniBar(ArrayList<String> miniBar) {
		Cliente.miniBar = miniBar;
	}
	
	public static ArrayList<String> getSalaReunion() {
		return salaReunion;
	}
	
	public static void setSalaReunion(ArrayList<String> salaReunion) {
		Cliente.salaReunion = salaReunion;
	}
	
	public static ArrayList<String> getSpa() {
		return spa;
	}
	
	public static void setSpa(ArrayList<String> spa) {
		Cliente.spa = spa;
	}
	
}