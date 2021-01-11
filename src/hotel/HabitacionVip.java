package hotel;


public class HabitacionVip extends Habitacion{

	protected static int numHab;
	protected static int cantidad;
	protected static int camas;
	protected static boolean balcon;
	
	public HabitacionVip(int numHab, int cantidad, int camas, boolean balcon) {
		HabitacionVip.numHab = numHab;
		HabitacionVip.cantidad = cantidad;
		HabitacionVip.camas = camas;
		HabitacionVip.balcon = balcon;
	}
	
	public HabitacionVip() {
		HabitacionVip.numHab = 0;
		HabitacionVip.cantidad = 0;
		HabitacionVip.camas = 0;
		HabitacionVip.balcon = false;
	}
	

	public static int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		HabitacionVip.numHab = numHab;
	}

	public static int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		HabitacionVip.cantidad = cantidad;
	}

	public static int getCamas() {
		return camas;
	}

	public void setCamas(int camas) {
		HabitacionVip.camas = camas;
	}

	public static boolean isBalcon() {
		return balcon;
	}

	public void setBalcon(boolean balcon) {
		HabitacionVip.balcon = balcon;
	}

}