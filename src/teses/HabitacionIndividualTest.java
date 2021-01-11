package teses;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import hotel.HabitacionIndividual;

class HabitacionIndividualTest {

	HabitacionIndividual i1 = new HabitacionIndividual();
	HabitacionIndividual i2 = new HabitacionIndividual(113, 10);
	
	@Test
	void getNumHab() {
		assertEquals("113", "" + HabitacionIndividual.getNumHab());
	}
	@Test
	void setNumHab() {
	    int numhab = 113;
	    i1.setNumHab(i2.getNumHab());
	    assertEquals(i1.getNumHab(), numhab);
	}
	
	@Test
	void getCantidad() {
		assertEquals("10", "" + HabitacionIndividual.getCantidad());
	}
	@Test
	void setCantidad() {
	    int cantidad = 10;
	    i1.setCantidad(i2.getCantidad());
	    assertEquals(i1.getCantidad(), cantidad);
	}
	
}
