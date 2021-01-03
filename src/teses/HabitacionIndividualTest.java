package teses;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import hotel.HabitacionIndividual;

class HabitacionIndividualTest {

	HabitacionIndividual i = new HabitacionIndividual(113, 10);
	
	@Test
	void getNumHab() {
		assertEquals("113", "" + HabitacionIndividual.getNumHab());
	}
	
	@Test
	void getCantidad() {
		assertEquals("201", "" + HabitacionIndividual.getCantidad());
	}
	
}
