package hotel;


public class HabitacionDoble extends Habitacion{
	
	protected static int numHab;
	protected static int cantidad;
	protected static boolean camaMatrimonio;

	
	public HabitacionDoble(int numHab, int cantidad, boolean camaMatrimonio) {
		HabitacionDoble.numHab = numHab;
		HabitacionDoble.cantidad = cantidad;
		HabitacionDoble.camaMatrimonio = camaMatrimonio;
	}
	
	public HabitacionDoble() {
		HabitacionDoble.numHab = 0;
		HabitacionDoble.cantidad = 0;
		HabitacionDoble.camaMatrimonio = false;
	}

	public static int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		HabitacionDoble.numHab = numHab;
	}

	public static int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		HabitacionDoble.cantidad = cantidad;
	}


	public static boolean isCamaMatrimonio() {
		return camaMatrimonio;
	}

	public static void setCamaMatrimonio(boolean camaMatrimonio) {
		HabitacionDoble.camaMatrimonio = camaMatrimonio;
	}
}
