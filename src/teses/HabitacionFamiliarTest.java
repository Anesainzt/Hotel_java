package teses;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import hotel.HabitacionFamiliar;

public class HabitacionFamiliarTest {

	HabitacionFamiliar d = new HabitacionFamiliar(409, 2, 1, 1, true);

	@Test
	void getNumHab() {
		assertEquals(409, "" + HabitacionFamiliar.getNumHab());
	}
	
	@Test
	void getCant() {
		assertEquals(2, "" + HabitacionFamiliar.getCantidad());
	}

	@Test
	void getCamaIndividual() {
		assertEquals(1, "" + HabitacionFamiliar.getCamaIndividual());
	}
	
	@Test
	void getCamaMatrimonio() {
		assertEquals(1, "" + HabitacionFamiliar.getCamaMatrimonio());
	}
	
	@Test
	void getCuna() {
		assertEquals(false, "" + HabitacionFamiliar.getCuna());
	}
	
}
