package hotel;


public class HabitacionIndividual extends Habitacion {

	protected int numHab;
	protected int piso;
	protected int cantidad;
	protected int camas = 1;
	
	public HabitacionIndividual(int numHab, int piso, int cantidad, int camas) {
		this.numHab = numHab;
		this.piso = piso;
		this.cantidad = cantidad;
		this.camas = camas;
	}
	
	public HabitacionIndividual() {
		this.numHab = 0;
		this.piso = 0;
		this.cantidad = 0;
		this.camas = 1;
	}
	
	public HabitacionIndividual(HabitacionDoble d) {
		this.numHab = d.numHab;
		this.piso = d.piso;
		this.cantidad = d.cantidad;
		this.camas = d.camas;
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

	public int getCamas() {
		return camas;
	}

	public void setCamas(int camas) {
		this.camas = camas;
	}

	@Override
	public String toString() {
		return "HabitacionIndividual [numHab=" + numHab + ", piso=" + piso + ", cantidad=" + cantidad + ", camas=" + camas
				+ ", cantHabTot=" + cantHabTot + "]";
	}
	
}
