package hotel;


public class HabitacionFamiliar extends Habitacion{

	protected static int numHab;
	protected static int cantidad;
	protected static int camaIndividual;
	protected static int camaMatrimonio;
	protected static boolean cuna;
	
	
	public HabitacionFamiliar(int numHab, int cantidad, int camaIndividual, int camaMatrimonio,
			boolean cuna) {
		HabitacionFamiliar.numHab = numHab;
		HabitacionFamiliar.cantidad = cantidad;
		HabitacionFamiliar.camaIndividual = camaIndividual;
		HabitacionFamiliar.camaMatrimonio = camaMatrimonio;
		HabitacionFamiliar.cuna = cuna;
	}
	
	

	public HabitacionFamiliar() {
		HabitacionFamiliar.numHab = 0;
		HabitacionFamiliar.cantidad = 0;
		HabitacionFamiliar.camaIndividual = 0;
		HabitacionFamiliar.camaMatrimonio = 0;
		HabitacionFamiliar.cuna = false;
	}
	

	public static int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		HabitacionFamiliar.numHab = numHab;
	}

	public static int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		HabitacionFamiliar.cantidad = cantidad;
	}

	public static int getCamaIndividual() {
		return camaIndividual;
	}

	public void setCamaIndividual(int camaIndividual) {
		HabitacionFamiliar.camaIndividual = camaIndividual;
	}

	public static int getCamaMatrimonio() {
		return camaMatrimonio;
	}

	public void setCamaMatrimonio(int camaMatrimonio) {
		HabitacionFamiliar.camaMatrimonio = camaMatrimonio;
	}

	
	public static boolean getCuna() {
		return cuna;
	}

	public static void setCuna(boolean cuna) {
		HabitacionFamiliar.cuna = cuna;
	}

	
}
