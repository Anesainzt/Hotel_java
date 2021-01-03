package teses;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import hotel.Habitacion;

class HabitacionTest {

	Habitacion h1 = new Habitacion();
	
		@Test
		void isEmpty() {
			assertEquals("false", "" + Habitacion.isEmpty());
		}
		
		@Test
		void getCantHabTot() {
			assertEquals("180", "" + Habitacion.getCantHabTot());
		}
		
}
