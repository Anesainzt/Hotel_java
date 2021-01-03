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
	
	public HabitacionDoble(HabitacionDoble d) {
		HabitacionDoble.numHab = d.numHab;
		HabitacionDoble.cantidad = d.cantidad;
		HabitacionDoble.camaMatrimonio = d.camaMatrimonio;
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

	public static boolean getCamaMatrimonio() {
		return camaMatrimonio;
	}

	public void setCamaMatrimonio(boolean camaMatrimonio) {
		HabitacionDoble.camaMatrimonio = camaMatrimonio;
	}

	@Override
	public String toString() {
		return "HabitacionDoble [numHab=" + numHab + ", cantidad=" + cantidad + ", camaMatrimonio="
				+ camaMatrimonio + ", cantHabTot=" + cantHabTot + ", ocupado=" + ocupado + "]";
	}
	

}
