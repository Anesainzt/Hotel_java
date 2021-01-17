package teses;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import hotel.HabitacionVip;

class HabitacionVipTest {

	//CREAS DOS CLIENTES UNO VACIO(SETTERS) Y OTRO LLENO(GETTERS)
	HabitacionVip v1 = new HabitacionVip();
	HabitacionVip v2 = new HabitacionVip(522, 12, 3, true);
	
	//COMPRUEBAS LOS GETTERS Y SETTERS
	//COMPARA LOS DATOS DE V2 CON EL DATO QUE LE METES
	@Test
	void getNumHab() {
		assertEquals("522", "" + HabitacionVip.getNumHab());
	}
	//PARA TESTEAR UN SET PASA EL VALOR DE V2 A V1 Y LO COMPARA CON EL DATO QUE LE METES
	@Test
	void setNumHab() {
	    int numhab = 522;
	    v1.setNumHab(v2.getNumHab());
	    assertEquals(v1.getNumHab(), numhab);
	}
	
	@Test
	void getCantidad() {
		assertEquals("12", "" + HabitacionVip.getCantidad());
	}
	@Test
	void setCantidad() {
	    int cantidad = 12;
	    v1.setCantidad(v2.getCantidad());
	    assertEquals(v1.getCantidad(), cantidad);
	}

	@Test
	void getCamas() {
		assertEquals("3", "" + HabitacionVip.getCamas());
	}
	@Test
	void setCamas() {
	    int camas = 3;
	    v1.setCamas(v2.getCamas());
	    assertEquals(v1.getCamas(), camas);
	}
	
	@Test
	void getBalcon() {
		assertEquals("true", "" + HabitacionVip.isBalcon());
	}
	@Test
	void setBalcon() {
	    boolean numhab = true;
	    v1.setBalcon(v2.isBalcon());
	    assertEquals(v1.isBalcon(), numhab);
	}
	
	
	
}
