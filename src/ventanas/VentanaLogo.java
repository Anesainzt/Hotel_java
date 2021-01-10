package ventanas;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class VentanaLogo extends javax.swing.JFrame{
	
	//HACER UN HILO JOIN PARA QUE EMPIECE LA FOTO, LUEGO EL AUDIO Y LUEGO SE TERMINEN LOS 2
	
	FondoPanel fondo = new FondoPanel();
	
	public VentanaLogo() {
		this.setContentPane(fondo);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Identificación del cliente");
		setSize(850, 700);
		setVisible(true);
	}
	
	class FondoPanel extends JPanel{
		private Image imagen;
		
		@Override
		public void paint(Graphics g) {
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

