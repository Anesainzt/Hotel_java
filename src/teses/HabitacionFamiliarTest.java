package teses;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import hotel.HabitacionFamiliar;

class HabitacionFamiliarTest {

	HabitacionFamiliar f1 = new HabitacionFamiliar();
	HabitacionFamiliar f2 = new HabitacionFamiliar(409, 2, 1, 1, true);

	//COMPRUEBAS LOS GETTERS Y SETTERS
	//COMPARA LOS DATOS DE C2 CON EL DATO QUE LE METES
	@Test
	void getNumHab() {
		assertEquals(409, HabitacionFamiliar.getNumHab());
	}
	
	//PARA TESTEAR UN SET PASA EL VALOR DE F2 A F1 Y LO COMPARA CON EL DATO QUE LE METES
	@Test
	void setNumHab() {
	    int numhab = 409;
	    f1.setNumHab(f2.getNumHab());
	    assertEquals(f1.getNumHab(), numhab);
	}
	
	@Test
	void getCantidad() {
		assertEquals(2, HabitacionFamiliar.getCantidad());
	}
	@Test
	void setCantidad() {
	    int numhab = 2;
	    f1.setCantidad(f2.getCantidad());
	    assertEquals(f1.getCantidad(), numhab);
	}

	@Test
	void getCamaIndividual() {
		assertEquals(1, HabitacionFamiliar.getCamaIndividual());
	}
	@Test
	void setCamaIndividual() {
	    int camaindividual = 1;
	    f1.setCamaIndividual(f2.getCamaIndividual());
	    assertEquals(f1.getCamaIndividual(), camaindividual);
	}
	
	@Test
	void getCamaMatrimonio() {
		assertEquals(1, HabitacionFamiliar.getCamaMatrimonio());
	}
	@Test
	void setCamaMatrimonio() {
	    int camamatrimonio = 1;
	    f1.setCamaMatrimonio(f2.getCamaMatrimonio());
	    assertEquals(f1.getCamaMatrimonio(), camamatrimonio);
	}
	
	@Test
	void getCuna() {
		assertEquals(true, HabitacionFamiliar.getCuna());
	}
	@Test
	void setCuna() {
	    boolean cuna = true;
	    f1.setCuna(f2.getCuna());
	    assertEquals(f1.getCuna(), cuna);
	}
	
}

