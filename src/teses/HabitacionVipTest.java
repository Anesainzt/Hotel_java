package teses;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import hotel.HabitacionVip;

class HabitacionVipTest {

	HabitacionVip v = new HabitacionVip(522, 12, 3, true);
	
	@Test
	void getNumHab() {
		assertEquals("522", "" + HabitacionVip.getNumHab());
	}
	
	@Test
	void getCantidad() {
		assertEquals("12", "" + HabitacionVip.getCantidad());
	}

	@Test
	void getCamas() {
		assertEquals("3", "" + HabitacionVip.getCamas());
	}
	
	@Test
	void getBalcon() {
		assertEquals("true", "" + HabitacionVip.isBalcon());
	}
	
	
	
}
