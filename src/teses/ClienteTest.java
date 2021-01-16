package teses;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import hotel.Cliente;

class ClienteTest {

	Cliente c1 = new Cliente();
	Cliente c2 = new Cliente("Alazne", "Parra", "22764839Z", "1999-03-17", "1234567890", "alazne.parra", "Armagedom", "Armagedom", null, null, null, null, null, null);
	
	
	@Test
	void getNombre() {
		assertEquals("Alazne", Cliente.getNombre());
	}
	@Test
	void setNombre() {
	    String nombre = "Alazne";
	    c1.setNombre(c2.getNombre());
	    assertEquals(c1.getNombre(), nombre);
	}
	
	@Test
	void getApellido() {
		assertEquals("Parra", Cliente.getApellido());
	}
	@Test
	public void setApellido() {
	    String apellido = "Parra";
	    c1.setApellido(c2.getApellido());
	    assertEquals(c1.getApellido(), apellido);
	}
	
	@Test
	void getDni() {
		assertEquals("22764839Z", Cliente.getDni());
	}
	@Test
	public void setDni() {
	    String dni = "22764839Z";
	    c1.setDni(c2.getDni());
	    assertEquals(c1.getDni(), dni);
	}
	
	
	@Test
	void getFechaNcto() {
		assertEquals("1999-03-17", Cliente.getFechaNcto());
	}
	@Test
	public void setFechaNcto() {
	    String fechancto = "1999-03-17";
	    c1.setFechaNcto(c2.getFechaNcto());
	    assertEquals(c1.getFechaNcto(), fechancto);
	}
	
	@Test
	void getTarjeta() {
		assertEquals("1234567890", Cliente.getTarjeta());
	}
	@Test
	public void setTarjeta() {
	    String tarjeta = "1234567890";
	    c1.setTarjeta(c2.getTarjeta());
	    assertEquals(c1.getTarjeta(), tarjeta);
	}
	
	@Test
	void getLogin() {
		assertEquals("alazne.parra", Cliente.getLogin());
	}
	@Test
	public void setLogin() {
	    String login = "alazne.parra";
	    c1.setLogin(c2.getLogin());
	    assertEquals(c1.getLogin(), login);
	}
	
	@Test
	void getPassword() {
		assertEquals("Armagedom", Cliente.getPassword());
	}
	@Test
	public void setPassword() {
	    String password = "Armagedom";
	    c1.setPassword(c2.getPassword());
	    assertEquals(c1.getPassword(), password);
	}
	
	@Test
	void getNewPassword() {
		assertEquals("Armagedom", Cliente.getNewPassword());
	}
	@Test
	void setNewPassword() {
	    String newpassword = "Armagedom";
	    c1.setNewPassword(c2.getNewPassword());
	    assertEquals(c1.getNewPassword(), newpassword);
	}
	
	@Test 
	void getHashMap() {
		HashMap<String,Integer> hashmap = new HashMap<String,Integer>();
		assertEquals(hashmap.put("COMIDA", 30), Cliente.getHashmap());
		assertEquals(hashmap.put("MASAJE CORPORAL", 90), Cliente.getHashmap());
		assertEquals(hashmap.put("SALA PETIT COMITÉ EQUIPADA", 50), Cliente.getHashmap());
		assertEquals(hashmap.put("ELECCION DE TRES (DIFERENTES)", 140), Cliente.getHashmap());
	}
	@Test
	void setHashMap() {
		HashMap<String,Integer> hashmap =  new HashMap<String,Integer>();
		hashmap.put("COMIDA", 30);
		hashmap.put("MASAJE CORPORAL", 90);
		hashmap.put("SALA PETIT COMITÉ EQUIPADA", 50);
		hashmap.put("ELECCION DE TRES (DIFERENTES)", 140);
	    c1.setHashmap(c2.getHashmap());
	    assertEquals(c1.getHashmap(), null);
	}
	
}