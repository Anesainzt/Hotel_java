package hotel;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class ClienteTest {

	Cliente c = new Cliente("Alazne", "Parra", "22764839Z", 21, "1234567890", "alazne.parra", "Armagedom", "Armagedom");
	
	@Test
	void getNombre() {
		assertEquals("Alazne", Cliente.getNombre());
	}
	
	@Test
	void getApellido() {
		assertEquals("Parra", Cliente.getApellido());
	}
	
	@Test
	void getDni() {
		assertEquals("22764839Z", Cliente.getDni());
	}
	
	@Test
	void getEdad() {
		assertEquals(21, Cliente.getEdad());
	}
	
	@Test
	void getTarjeta() {
		assertEquals("1234567890", Cliente.getTarjeta());
	}
	
	@Test
	void getLogin() {
		assertEquals("alazne.parra", Cliente.getLogin());
	}
	
	@Test
	void getPassword() {
		assertEquals("Armagedom", Cliente.getPassword());
	}
	
	@Test
	void getNewPassword() {
		assertEquals("Armagedom", Cliente.getNewPassword());
	}

}
