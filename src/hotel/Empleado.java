package hotel;

public class Empleado {
	protected static String nombre;
	protected static String apellido;
	protected static String dni;
	protected static double salario;
	protected static String horaEntrada;
	protected static String horaSalida;
	protected static String usuario;
	protected static String password;	
	
	public Empleado(String nombre, String apellido, String dni, double salario, String horaEntrada, String horaSalida, String usuario, String password) {
		
		Empleado.nombre = nombre;
		Empleado.apellido = apellido;
		Empleado.dni = dni;
		Empleado.salario = salario;
		Empleado.horaEntrada = horaEntrada;
		Empleado.horaSalida = horaSalida;
		Empleado.usuario = usuario;
		Empleado.password = password;
	}
	
	public Empleado() {
		
		Empleado.nombre = "";
		Empleado.apellido = "";
		Empleado.dni = "";
		Empleado.salario = 0;
		Empleado.horaEntrada = "";
		Empleado.horaSalida = "";
		Empleado.usuario = "";
		Empleado.password = "";
	}
	
	public Empleado(Empleado e) {
		
		Empleado.nombre = e.nombre;
		Empleado.apellido = e.apellido;
		Empleado.dni = e.dni;
		Empleado.salario = e.salario;
		Empleado.horaEntrada = e.horaEntrada;
		Empleado.horaSalida = e.horaSalida;
		Empleado.usuario = e.usuario;
		Empleado.password = e.password;
	}

	public static String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		Empleado.nombre = nombre;
	}

	public static String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		Empleado.apellido = apellido;
	}

	public static String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		Empleado.dni = dni;
	}

	public static double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		Empleado.salario = salario;
	}

	public static String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		Empleado.horaEntrada = horaEntrada;
	}

	public static String getHoraSalida() {
		return horaSalida;
	}

	public void setHora_salida(String horaSalida) {
		Empleado.horaSalida = horaSalida;
	}

	public static String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		Empleado.usuario = usuario;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Empleado.password = password;
	}
	
}