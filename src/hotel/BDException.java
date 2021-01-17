package hotel;
//CLASE PARA LAS EXCEPCIOINES DE LA BASE DE DATOS
public class BDException extends Exception {
	private static final long serialVersionUID = 1L;

	public BDException(String message) {
		super(message);
	}
	
	public BDException(String message, Throwable e) {
		super(message, e);
	}
}
