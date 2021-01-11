package teses;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import hotel.Empleado;

class EmpleadoTest {

	Empleado empleado = new Empleado("Asier", "Martinez", "12345678S", 987.04, "10:00", "17:00", "asier.mm@opendeusto.es", "Asierm27", "Cocina", false, "Ander");
	
	@Test
	void getNombre() {
		assertEquals("Asier", Empleado.getNombre());
	}
	
	@Test
	void getApellido() {
		assertEquals("Martinez", Empleado.getApellido());
	}
	
	@Test
	void getDni() {
		assertEquals("12345678S", Empleado.getDni());
	}
	
	@Test
	void getSalario() {
		assertEquals("987.04", "" + Empleado.getSalario());
	}
	
	@Test
	void getHoraEntrada() {
		assertEquals("10:00", Empleado.getHoraEntrada());
	}
	
	@Test
	void getHoraSalida() {
		assertEquals("17:00", Empleado.getHoraSalida());
	}
	
	@Test
	void getUsuario() {
		assertEquals("asier.mm@opendeusto.es", Empleado.getUsuario());
	}
	
	@Test
	void getPassword() {
		assertEquals("Asierm27", Empleado.getPassword());
	}
	
	@Test
	void getDepartamento() {
		assertEquals("Cocina", Empleado.getDepartamento());
	}
	
	@Test
	void isJefe() {
		assertEquals(false, Empleado.isJefe());
	}

	@Test
	void getUsuarioJefe() {
		assertEquals("Ander", Empleado.getUsuarioJefe());
	}
	
}

