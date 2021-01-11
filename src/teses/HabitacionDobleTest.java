package teses;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import hotel.HabitacionDoble;
class HabitacionDobleTest{

	HabitacionDoble d1 = new HabitacionDoble();
	HabitacionDoble d2 = new HabitacionDoble(201, 4, false);

	@Test
	void getNumHab() {
		assertEquals("201", "" + HabitacionDoble.getNumHab());
	}
	@Test
	void setNumHab() {
	    int numhab = 201;
	    d1.setNumHab(d2.getNumHab());
	    assertEquals("" + d1.getNumHab(), "" + numhab);
	}
	
	@Test
	void getCant() {
		assertEquals("4", "" + HabitacionDoble.getCantidad());
	}
	@Test
	void setCantidad() {
	    int cantidad = 4;
	    d1.setCantidad(d2.getCantidad());
	    assertEquals("" + d1.getCantidad(), "" + cantidad);
	}
	
	
	@Test
	void getCamaMatrimonio() {
		assertEquals("false", "" + HabitacionDoble.isCamaMatrimonio());
	}
	@Test
	void setCamaMatrimonio() {
	    boolean camamatrimonio = false;
	    d1.setCamaMatrimonio(d2.isCamaMatrimonio());
	    assertEquals("" + d1.isCamaMatrimonio(), "" + camamatrimonio);
	}
	
	
	
}
