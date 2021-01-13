package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
	private Connection conn = null; 
	
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
	
}
