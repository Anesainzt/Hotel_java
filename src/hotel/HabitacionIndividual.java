package hotel;


public class HabitacionIndividual extends Habitacion {

	protected int numHab;
	protected int piso;
	protected int cantidad;
	
	
	public HabitacionIndividual(int numHab, int piso, int cantidad) {
		this.numHab = numHab;
		this.piso = piso;
		this.cantidad = cantidad;
	}
	
	public HabitacionIndividual() {
		this.numHab = 0;
		this.piso = 0;
		this.cantidad = 0;
	}
	
	public HabitacionIndividual(HabitacionIndividual i) {
		this.numHab = i.numHab;
		this.piso = i.piso;
		this.cantidad = i.cantidad;
	}

	public int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		this.numHab = numHab;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "HabitacionIndividual [numHab=" + numHab + ", piso=" + piso + ", cantidad=" + cantidad + ", cantHabTot=" + cantHabTot + "]";
	}
	
}
