package hotel;

public class Cliente {
	protected static String nombre;
	protected static String apellido;
	protected static String dni;
	protected static int edad;
	protected static String tarjeta;
	protected static String login;
	protected static String password;
	protected static String newPassword;
	
	public Cliente(String nombre, String apellido, String dni, int edad, String tarjeta, String login, String password, String newPassword) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
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
		this.dni = "";
		this.edad = 0;
		this.tarjeta = "";
		this.login = "";
		this.password = "";
		this.newPassword = "";
	}
	
	public Cliente(Cliente c) {
		this.nombre = c.nombre;
		this.apellido = c.apellido;
		this.dni = c.dni;
		Cliente.edad = c.edad;
		this.tarjeta = c.tarjeta;
		this.login = c.login;
		this.password = c.password;
		this.newPassword = c.newPassword;
	}

	public static String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public static String getDni() {
		return dni;
	}
	
	public void setDni(String xni) {
		this.dni = dni;
	}
	
	public static int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
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
		this.login = login;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static String getNewPassword() {
		return newPassword;
	}
	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}