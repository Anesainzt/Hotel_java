package ventanas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import hotel.Empleado;


public class VentanaMapa extends JFrame{
	public VentanaMapa(String imagen, Empleado empleado) {
		 //Creamos el frame con un titulo
		  JFrame frame = new JFrame("FrameDemo");

		  frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		  //Crear componentes y agregarlos a la ventana
		  //crear un JLabel vacio...
		  JLabel emptyLabel = new JLabel("");

		  //Obtener el objeto Class NombreClase.class
		  Class clazz = VentanaEmpleado.class;

		  //Crear el path
		  String path = imagen;

		  //Obtener la url de nuestra imagen
		  URL url = clazz.getResource(path);

		  //Leer la imagen con la clase ImageIO
		  try {
		   BufferedImage image = ImageIO.read(url);

		   //Setear la imagen al JLabel
		   emptyLabel.setIcon(new ImageIcon(image));
		  } catch (IOException ioexception) {
		   System.err.println(ioexception);
		  }
		  JButton volver = new JButton("VOLVER");
		  volver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				VentanaEmpleado ve = new VentanaEmpleado(empleado);
				dispose();
			}
		});
		  emptyLabel.setPreferredSize(new Dimension(250, 100));
		  frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		  frame.getContentPane().add(volver, BorderLayout.SOUTH);
		  frame.setSize(800,  800);
		  frame.setVisible(true);
		 
	}

}
