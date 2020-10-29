package hotel;

import java.io.*;

public class Cliente {
	protected String nombre;
	protected String apellido;
	protected String DNI;
	protected String edad;
	protected String tarjeta;
	protected String login;
	protected String password;
	protected String newPassword;
	
	public Cliente(String nombre, String apellido, String DNI, String edad, String tarjeta, String login, String password, String newPassword) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.edad = edad;
		this.tarjeta = tarjeta;
		this.login = login;
		this.password = password;
		this.newPassword = newPassword;
	}
	
	public Cliente() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.DNI = "";
		this.edad = "";
		this.tarjeta = "";
		this.login = "";
		this.password = "";
		this.newPassword = "";
	}
	
	public Cliente(Cliente c) {
		super();
		this.nombre = c.nombre;
		this.apellido = c.apellido;
		this.DNI = c.DNI;
		this.edad = c.edad;
		this.tarjeta = c.tarjeta;
		this.login = c.login;
		this.password = c.password;
		this.newPassword = c.newPassword;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	
	public String getEdad() {
		return edad;
	}
	
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	public String getTarjeta() {
		return tarjeta;
	}
	
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	public String getLogin() {
		return tarjeta;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNewPassword() {
		return newPassword;
	}
	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
	