package hotel;


public class HabitacionDoble extends Habitacion{
	
	protected int numHab;
	protected int piso;
	protected int cantidad;
	protected boolean camaMatrimonio;
	
	public HabitacionDoble(int numHab, int piso, int cantidad, boolean camaMatrimonio) {
		this.numHab = numHab;
		this.piso = piso;
		this.cantidad = cantidad;
		this.camaMatrimonio = camaMatrimonio;
	}
	
	public HabitacionDoble() {
		this.numHab = 0;
		this.piso = 0;
		this.cantidad = 0;
		this.camaMatrimonio = false;
	}
	
	public HabitacionDoble(HabitacionDoble d) {
		this.numHab = d.numHab;
		this.piso = d.piso;
		this.cantidad = d.cantidad;
		this.camaMatrimonio = d.camaMatrimonio;
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

	public boolean getCamaMatrimonio() {
		return camaMatrimonio;
	}

	public void setCamaMatrimonio(boolean camaMatrimonio) {
		this.camaMatrimonio = camaMatrimonio;
	}

	@Override
	public String toString() {
		return "HabitacionDoble [numHab=" + numHab + ", piso=" + piso + ", cantidad=" + cantidad + ", camaMatrimonio=" + camaMatrimonio
				+ ", cantHabTot=" + cantHabTot + "]";
	}
	
	



}
