package hotel;


public class HabitacionIndividual extends Habitacion {

	protected static int numHab;
	protected static int cantidad;
	
	
	public HabitacionIndividual(int numHab, int cantidad) {
		HabitacionIndividual.numHab = numHab;
		HabitacionIndividual.cantidad = cantidad;
	}
	
	public HabitacionIndividual() {
		HabitacionIndividual.numHab = 0;
		HabitacionIndividual.cantidad = 0;
	}

	public static int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		HabitacionIndividual.numHab = numHab;
	}

	public static int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		HabitacionIndividual.cantidad = cantidad;
	}

}
