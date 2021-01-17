package teses;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import hotel.Empleado;

class EmpleadoTest {

	//CREAS DOS CLIENTES UNO VACIO (SETTERS) Y OTRO LLENO (GETTERS)
	Empleado empleado1 = new Empleado();
	Empleado empleado2 = new Empleado("Asier", "Martinez", "12345678S", 987.04, "10:00", "17:00", "asier.mm@opendeusto.es", "Asierm27", "Cocina", false, "Ander");
	
	//COMPRUEBAS LOS GETTERS Y SETTERS
	@Test
	void getNombre() {
		assertEquals("Asier", Empleado.getNombre());
	}
	
	@Test
	public void setNombre() {
	    String nombre = "Asier";
	    empleado1.setNombre(empleado2.getNombre());
	    assertEquals(empleado1.getNombre(), nombre);
	}
	
	@Test
	void getApellido() {
		assertEquals("Martinez", Empleado.getApellido());
	}
	
	@Test
	public void setApellido() {
	    String apellido = "Martinez";
	    empleado1.setApellido(empleado2.getApellido());
	    assertEquals(empleado1.getApellido(), apellido);
	}
	
	@Test
	void getDni() {
		assertEquals("12345678S", Empleado.getDni());
	}
	
	@Test
	public void setDni() {
	    String dni = "12345678S";
	    empleado1.setDni(empleado2.getDni());
	    assertEquals(empleado1.getDni(), dni);
	}
	
	@Test
	void getSalario() {
		assertEquals("987.04", "" + Empleado.getSalario());
	}
	
	@Test
	public void setSalario() {
	    double salario = 987.04;
	    empleado1.setSalario(empleado2.getSalario());
	    assertEquals("" + empleado1.getSalario(), "" + salario);
	}
	
	@Test
	void getHoraEntrada() {
		assertEquals("10:00", Empleado.getHoraEntrada());
	}
	
	@Test
	public void setEntrada() {
	    String horaentrada = "10:00";
	    empleado1.setHoraEntrada(empleado2.getHoraEntrada());
	    assertEquals(empleado1.getHoraEntrada(), horaentrada);
	}
	
	@Test
	void getHoraSalida() {
		assertEquals("17:00", Empleado.getHoraSalida());
	}
	
	@Test
	public void setHoraSalida() {
	    String horaSalida = "17:00";
	    empleado1.setHoraSalida(empleado2.getHoraSalida());
	    assertEquals(empleado1.getHoraSalida(), horaSalida);
	}
	
	@Test
	void getUsuario() {
		assertEquals("asier.mm@opendeusto.es", Empleado.getUsuario());
	}
	@Test
	void setUsuario() {
	    String usuario = "asier.mm@opendeusto.es";
	    empleado1.setUsuario(empleado2.getUsuario());
	    assertEquals(empleado1.getUsuario(), usuario);
	}
	
	@Test
	void getPassword() {
		assertEquals("Asierm27", Empleado.getPassword());
	}
	@Test
	void setPassword() {
	    String password = "Asierm27";
	    empleado1.setPassword(empleado2.getPassword());
	    assertEquals(empleado1.getPassword(), password);
	}
	
	@Test
	void getDepartamento() {
		assertEquals("Cocina", Empleado.getDepartamento());
	}
	@Test
	void setDepartamento() {
	    String departamento = "Cocina";
	    empleado1.setDepartamento(empleado2.getDepartamento());
	    assertEquals(empleado1.getDepartamento(), departamento);
	}
	
	@Test
	void isJefe() {
		assertEquals(false, Empleado.isJefe());
	}
	@Test
	void setJefe() {
	    boolean jefe = false;
	    empleado1.setJefe(empleado2.isJefe());
	    assertEquals(empleado1.isJefe(), jefe);
	}

	@Test
	void getUsuarioJefe() {
		assertEquals("Ander", Empleado.getUsuarioJefe());
	}
	@Test
	void setUsuarioJefe() {
	    String usuario = "Ander";
	    empleado1.setUsuarioJefe(empleado2.getUsuarioJefe());
	    assertEquals(empleado1.getUsuarioJefe(), usuario);
	}
	
}

