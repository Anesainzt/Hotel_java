package teses;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import hotel.Cliente;

class ClienteTest {

	
	Cliente c = new Cliente("Alazne", "Parra", "22764839Z", "1999-03-17", "1234567890", "alazne.parra", "Armagedom", "Armagedom", null);
	
	
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
	
	@Test public void testHashMap() {
		HashMap<String,Integer> hashmap = new HashMap<String,Integer>();
		assertEquals(null, hashmap.put("COMIDA", 30));
		assertEquals(null, hashmap.put("MASAJE CORPORAL", 90));
		assertEquals(null, hashmap.put("SALA PETIT COMITÉ EQUIPADA", 50));
		assertEquals(null, hashmap.put("ELECCION DE TRES (DIFERENTES)", 140));
	
		assertEquals((Integer)30, hashmap.put("COMIDA", 30));
		assertEquals((Integer)90, hashmap.put("MASAJE CORPORAL", 90));
		assertEquals((Integer)50, hashmap.put("SALA PETIT COMITÉ EQUIPADA", 50));
		assertEquals((Integer)140, hashmap.put("ELECCION DE TRES (DIFERENTES)", 140));
		
	}
	
}

