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
	protected static String departamento;
	protected static boolean jefe;
	protected static String usuarioJefe;
	
	public Empleado(String nombre, String apellido, String dni, double salario, String horaEntrada, String horaSalida, String usuario, String password, String departamento, boolean jefe, String usuarioJefe) {
		
		Empleado.nombre = nombre;
		Empleado.apellido = apellido;
		Empleado.dni = dni;
		Empleado.salario = salario;
		Empleado.horaEntrada = horaEntrada;
		Empleado.horaSalida = horaSalida;
		Empleado.usuario = usuario;
		Empleado.password = password;
		Empleado.departamento = departamento;
		Empleado.jefe = jefe;
		Empleado.usuarioJefe = usuarioJefe;
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
		Empleado.departamento = "";
		Empleado.jefe = false;
		Empleado.usuarioJefe = "";
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

	public void setHoraSalida(String horaSalida) {
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

	public static String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		Empleado.departamento = departamento;
	}

	public static boolean isJefe() {
		return jefe;
	}

	public void setJefe(boolean jefe) {
		Empleado.jefe = jefe;
	}

	public static String getUsuarioJefe() {
		return usuarioJefe;
	}

	public void setUsuarioJefe(String usuarioJefe) {
		Empleado.usuarioJefe = usuarioJefe;
	}
	
	
}