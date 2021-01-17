package teses;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import hotel.Cliente;

class ClienteTest {
	
	//PARA RELLENAR EL HASHMAP DENTRO DEL CLIENTE C2 TIENES QUE METERLE VALORES
	public HashMap<String,Integer> hash(HashMap<String,Integer> hashmap1) {
		hashmap1.put("COMIDA", 30);
		hashmap1.put("MASAJE CORPORAL", 90);
		hashmap1.put("SALA PETIT COMITÉ EQUIPADA", 50);
		hashmap1.put("ELECCION DE TRES", 140);
		return hashmap1;
	}
	static HashMap<String,Integer> hashmap1 =  new HashMap<String,Integer>();
	
	//EL ARRAYLIST FUNCIONA PARECIDO A UN HASHMAP 
	//PRIMERO LE METES VALORES Y LUEGO LE METES EL ARRAYCOMIDA A CLIENTE C2
	public ArrayList<String> arraycomida( ArrayList<String> arraycomida ){
		arraycomida.add("POMODORO");
		return arraycomida;	
	}
	static ArrayList<String> arraycomida = new ArrayList<String>();
	
	//LE METES DENTRO DE CLIENTE LOS VALORES QUE LE HAYAS AÑADIDO A ARRAYDEPORTES
	public ArrayList<String> arraydeportes( ArrayList<String> arraydeportes ){
		arraydeportes.add("CAMPO BALONCESTO");
		return arraydeportes;	
	}
	static ArrayList<String> arraydeportes = new ArrayList<String>();
	
	//LE METES DENTRO DE CLIENTE LOS VALORES QUE LE HAYAS AÑADIDO A ARRAYMINIBAR
	public ArrayList<String> arrayminibar( ArrayList<String> arrayminibar ){
		arrayminibar.add("RON");
		arrayminibar.add("TEQUILA");
		return arrayminibar;	
	}
	static ArrayList<String> arrayminibar = new ArrayList<String>();
	
	//LE METES DENTRO DE CLIENTE LOS VALORES QUE LE HAYAS AÑADIDO A ARRAYSALAREUNION
	public ArrayList<String> arraysalareunion( ArrayList<String> arraysalareunion ){
		arraysalareunion.add("SALA PETIT COMITÉ EQUIPADA");
		arraysalareunion.add("SALA PETIT COMITÉ EQUIPADA");
		return arraysalareunion;	
	}
	static ArrayList<String> arraysalareunion = new ArrayList<String>();
	
	//LE METES DENTRO DE CLIENTE LOS VALORES QUE LE HAYAS AÑADIDO A ARRAYSPA
	public ArrayList<String> arrayspa( ArrayList<String> arrayspa ){
		arrayspa.add("JACUZZI");
		arrayspa.add("SALES MINERALES");
		arrayspa.add("TRATAMIENTO ESTÉTICO");
		return arrayspa;	
	}
	static ArrayList<String> arrayspa = new ArrayList<String>();
	
	
	//CREAS DOS CLIENTES UNO VACIO Y OTRO LLENO
	Cliente c1 = new Cliente();
	Cliente c2 = new Cliente("Alazne", "Parra", "22764839Z", "1999-03-17", "1234567890", "alazne.parra", "Armagedom", "Armagedom", hash(hashmap1), arraycomida(arraycomida), arraydeportes(arraydeportes), arrayminibar(arrayminibar), arraysalareunion(arraysalareunion), arrayspa(arrayspa));
	
	
	//COMPRUEBAS LOS GETTERS Y SETTERS
	//COMPARA LOS DATOS DE C2 CON EL DATO QUE LE METES
	@Test
	void getNombre() {
		assertEquals("Alazne", Cliente.getNombre());
	}
	//PARA TESTEAR UN SET PASA EL VALOR DE C2 A C1 Y LO COMPARA CON EL DATO QUE LE METES
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
	
	//COMPRUEBA SI COINCIDE EL HASHMAP QUE TIENE DENTRO CLIENTE C2 CON UN HASMAP CREADO
	@Test 
	void getHashMap() {
		HashMap<String,Integer> hashmap =  new HashMap<String,Integer>();
		hashmap.put("COMIDA", 30);
		hashmap.put("MASAJE CORPORAL", 90);
		hashmap.put("SALA PETIT COMITÉ EQUIPADA", 50);
		hashmap.put("ELECCION DE TRES", 140);
		assertEquals(hashmap, c2.getHashmap());
		
	}
	//COMPRUEBA CON EL CLIENTE VACIO PASANDOLE VALORES DEL CLIENTE LLENO SI COINCIDE CON EL HASHMAP QUE SE HA CREADO ABAJO
	@Test
	void setHashMap() {
		HashMap<String,Integer> hashmap =  new HashMap<String,Integer>();
		hashmap.put("COMIDA", 30);
		hashmap.put("MASAJE CORPORAL", 90);
		hashmap.put("SALA PETIT COMITÉ EQUIPADA", 50);
		hashmap.put("ELECCION DE TRES", 140);
	    c1.setHashmap(c2.getHashmap());
	    assertEquals(c1.getHashmap(), hashmap);
	}
	
	//COMPARA DOS LISTAS DE ARRAYLIST LA QUE ESTÁ EN CLIENTE C2 Y LA QUE ESTÁ CREADA ABAJO
	@Test 
	void getComida() {
		ArrayList<String> getcomida = new ArrayList<String>();
		getcomida.add("POMODORO");
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		for (String string : getcomida) {
			lista1.add(string);
		}
		for (String string : c2.getComida()) {
			lista2.add(string);
		}
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));	
		}

	}
	
	//COMPARA DOS LISTAS DE ARRAYLIST PASANDO EL ARRAYLIST DE C2 A C1 Y LO COMPARA CON EL DE ABAJO
	@Test 
	void setComida() {
		ArrayList<String> setcomida = new ArrayList<String>();
		setcomida.add("POMODORO");
		c1.setComida(c2.getComida());
		
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		for (String string : setcomida) {
			lista1.add(string);
		}
		for (String string : c1.getComida()) {
			lista2.add(string);
		}
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));	
		}
		
	}
	
	@Test
	void getDeporte() {
		ArrayList<String> getdeporte = new ArrayList<String>();
		getdeporte.add("CAMPO BALONCESTO");
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		for (String string : getdeporte) {
			lista1.add(string);
		}
		for (String string : c2.getDeporte()) {
			lista2.add(string);
		}
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));	
		}

	}
	@Test 
	void setDeporte() {
		ArrayList<String> setdeporte = new ArrayList<String>();
		setdeporte.add("CAMPO BALONCESTO");
		c1.setDeporte(c2.getDeporte());
		
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		for (String string : setdeporte) {
			lista1.add(string);
		}
		for (String string : c1.getDeporte()) {
			lista2.add(string);
		}
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));	
		}
	}
	
	@Test
	void getMinibar() {
		ArrayList<String> getminibar = new ArrayList<String>();
		getminibar.add("RON");
		getminibar.add("TEQUILA");
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		for (String string : getminibar) {
			lista1.add(string);
		}
		for (String string : c2.getMiniBar()) {
			lista2.add(string);
		}
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));	
		}

	}
	@Test
	void setMinibar() {
		ArrayList<String> setminibar = new ArrayList<String>();
		setminibar.add("RON");
		setminibar.add("TEQUILA");
		c1.setMiniBar(c2.getMiniBar());
		
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		for (String string : setminibar) {
			lista1.add(string);
		}
		for (String string : c1.getMiniBar()) {
			lista2.add(string);
		}
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));	
		}
		
	}
	@Test
	void getSalaReunion() {
		ArrayList<String> getsalareunion = new ArrayList<String>();
		getsalareunion.add("SALA PETIT COMITÉ EQUIPADA");
		getsalareunion.add("SALA PETIT COMITÉ EQUIPADA");
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		for (String string : getsalareunion) {
			lista1.add(string);
		}
		for (String string : c2.getSalaReunion()) {
			lista2.add(string);
		}
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));	
		}

	}
	@Test
	void setSalaReunion() {
		ArrayList<String> setsalareunion = new ArrayList<String>();
		setsalareunion.add("SALA PETIT COMITÉ EQUIPADA");
		setsalareunion.add("SALA PETIT COMITÉ EQUIPADA");
		c1.setSalaReunion(c2.getSalaReunion());
		
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		for (String string : setsalareunion) {
			lista1.add(string);
		}
		for (String string : c1.getSalaReunion()) {
			lista2.add(string);
		}
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));	
		}
		
	}
	
	@Test
	void getSpa() {
		ArrayList<String> getspa = new ArrayList<String>();
		getspa.add("JACUZZI");
		getspa.add("SALES MINERALES");
		getspa.add("TRATAMIENTO ESTÉTICO");
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		for (String string : getspa) {
			lista1.add(string);
		}
		for (String string : c2.getSpa()) {
			lista2.add(string);
		}
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));	
		}

	}
	@Test
	void setSpa() {
		ArrayList<String> setspa = new ArrayList<String>();
		setspa.add("JACUZZI");
		setspa.add("SALES MINERALES");
		setspa.add("TRATAMIENTO ESTÉTICO");
		c1.setSpa(c2.getSpa());
		
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		for (String string : setspa) {
			lista1.add(string);
		}
		for (String string : c1.getSpa()) {
			lista2.add(string);
		}
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));	
		}
		
	}
	
}