package teses;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import hotel.HabitacionDoble;
class HabitacionDobleTest{

	HabitacionDoble d = new HabitacionDoble(201, 4, false);

	@Test
	void getNumHab() {
		assertEquals("201", "" + HabitacionDoble.getNumHab());
	}
	
	@Test
	void getCant() {
		assertEquals("4", "" + HabitacionDoble.getCantidad());
	}

	@Test
	void getCamaMatrimonio() {
		assertEquals("false", "" + HabitacionDoble.getCamaMatrimonio());
	}
	
}