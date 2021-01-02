package hotel;


public class HabitacionVip extends Habitacion{

	protected int numHab;
	protected int piso;
	protected int cantidad;
	protected int camas;
	protected boolean balcon;
	
	public HabitacionVip(int numHab, int piso, int cantidad, int camas, boolean balcon) {
		this.numHab = numHab;
		this.piso = piso;
		this.cantidad = cantidad;
		this.camas = camas;
		this.balcon = balcon;
	}
	
	public HabitacionVip() {
		this.numHab = 0;
		this.piso = 0;
		this.cantidad = 0;
		this.camas = 0;
		this.balcon = false;
	}
	
	public HabitacionVip(HabitacionVip v) {
		this.numHab = v.numHab;
		this.piso = v.piso;
		this.cantidad = v.cantidad;
		this.camas = v.camas;
		this.balcon = v.balcon;
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

	public boolean isBalcon() {
		return balcon;
	}

	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

	@Override
	public String toString() {
		return "HabitacionVip [numHab=" + numHab + ", piso=" + piso + ", cantidad=" + cantidad + ", camas=" + camas
				+ ", balcon=" + balcon + ", cantHabTot=" + cantHabTot + ", ocupado=" + ocupado + "]";
	}
	
}