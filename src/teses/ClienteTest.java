package teses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import hotel.Cliente;

class ClienteTest {

	
	Cliente c = new Cliente("Alazne", "Parra", "22764839Z", "1999-03-17", "1234567890", "alazne.parra", "Armagedom", "Armagedom", null, null);
	
	
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
	void getFechaNcto() {
		assertEquals("1999-03-17", Cliente.getFechaNcto());
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

	@Test
	void getTicket() {
		assertEquals( null , Cliente.getTicket());
		
	}
	
}

