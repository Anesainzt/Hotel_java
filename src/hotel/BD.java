package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		
	public void delete() throws BDException {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM user")) {
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new BDException("No se pudo elimiar el usuario con id ", e);
		}
	}

}
