package teses;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import hotel.HabitacionFamiliar;

class HabitacionFamiliarTest {

	HabitacionFamiliar f1 = new HabitacionFamiliar();
	HabitacionFamiliar f2 = new HabitacionFamiliar(409, 2, 1, 1, true);

	@Test
	void getNumHab() {
		assertEquals(409, "" + HabitacionFamiliar.getNumHab());
	}
	
	@Test
	void setNumHab() {
	    int numhab = 201;
	    f1.setNumHab(f2.getNumHab());
	    assertEquals(f1.getNumHab(), numhab);
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

