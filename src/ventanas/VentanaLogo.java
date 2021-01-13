package ventanas;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import hotel.BD;
import hotel.BDException;

public class VentanaLogo extends javax.swing.JFrame{
	//FONDO QUE PONEMOS CON LA IMAGEN
	FondoPanel fondo = new FondoPanel();
	BD bd;
	public VentanaLogo() {
		
		//HACEMOS UN HILO PARA PASAR A LA SIGUIENTE VENTANA TRAS ACABAR LA BIENVENIDA
		bd = new BD();
		try {
			bd.connect();
		} catch (BDException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bd.ponerAlDiaBD();
		Thread t = new Thread(new Runnable() {
			
            @Override
            public void run() {
            	
            	 VentanaInicio vi = new VentanaInicio();
            	 dispose();
            }
            
        });

		try {
			//SONIDO QUE LEEMOS DEL FILE
			Clip sonido = AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(new File("hotelJava.wav")));
			//INICIAMOS EL SONIDO
			sonido.start();
			//LOOP(0) PARA QUE SOLO SE REPRODUZCA 1 VEZ
			sonido.loop(0);
            		    
		} catch (Exception e) {
		    System.out.println("" + e);
		}
		
        setContentPane(fondo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Identificación del cliente");
		setSize(850, 700);
		setVisible(true);
		
		try {
			//DEJAMOS AL HILO DORMIDO, CUANDO "DESPIERTE", LA BIENVENIDA HABRÁ ACABADO Y PASAMOS A LA SIGUIENTE VENTANA
			Thread.sleep(10*1000);
         } catch (Exception e) {
            System.out.println(e);
         }
		//INICIAMOS EL HILO
		t.start();
	}
	//CLASE PARA PONER DE FONDO LA IMAGEN
	class FondoPanel extends JPanel{
		private Image imagen;
		
		@Override
		public void paint(Graphics g) {
			//SELECCIONAMOS LA IMAGEN DEL ARCHIVO QUE ESTA EN EL PAQUETE IMAGEN
			imagen = new ImageIcon(getClass().getResource("/imagen/hotelJava.jpg")).getImage();
			
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			
			setOpaque(false);
			
			super.paint(g);
		}
	}
	
	
	public static void main (String args[]) {
		VentanaLogo vg = new VentanaLogo();
	}
}