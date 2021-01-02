package hotel;


public class HabitacionFamiliar extends Habitacion{

	protected int numHab;
	protected int piso;
	protected int cantidad;
	protected int camaIndividual;
	protected int camaMatrimonio;
	protected boolean cuna;
	
	
	
	public HabitacionFamiliar(int numHab, int piso, int cantidad, int camaIndividual, int camaMatrimonio,
			boolean cuna) {
		this.numHab = numHab;
		this.piso = piso;
		this.cantidad = cantidad;
		this.camaIndividual = camaIndividual;
		this.camaMatrimonio = camaMatrimonio;
		this.cuna = cuna;
	}

	public HabitacionFamiliar() {
		this.numHab = 0;
		this.piso = 0;
		this.cantidad = 0;
		this.camaIndividual = 0;
		this.camaMatrimonio = 0;
		this.cuna = false;
	}
	
	public HabitacionFamiliar(HabitacionFamiliar f) {
		this.numHab = f.numHab;
		this.piso = f.piso;
		this.cantidad = f.cantidad;
		this.camaIndividual = f.camaIndividual;
		this.camaMatrimonio = f.camaMatrimonio;
		this.cuna = f.cuna;
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

	public int getCamaIndividual() {
		return camaIndividual;
	}

	public void setCamaIndividual(int camaIndividual) {
		this.camaIndividual = camaIndividual;
	}

	public int getCamaMatrimonio() {
		return camaMatrimonio;
	}

	public void setCamaMatrimonio(int camaMatrimonio) {
		this.camaMatrimonio = camaMatrimonio;
	}

	public boolean isCuna() {
		return cuna;
	}

	public void setCuna(boolean cuna) {
		this.cuna = cuna;
	}

	@Override
	public String toString() {
		return "HabitacionFamiliar [numHab=" + numHab + ", piso=" + piso + ", cantidad=" + cantidad
				+ ", camaIndividual=" + camaIndividual + ", camaMatrimonio=" + camaMatrimonio + ", cuna=" + cuna
				+ ", cantHabTot=" + cantHabTot + ", ocupado=" + ocupado + "]";
	}
	
}
