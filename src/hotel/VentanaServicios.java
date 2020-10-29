package hotel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class VentanaServicios extends JFrame {
	
	JRadioButton SPA, buffet, deportes, miniBar;
	ButtonGroup bg;
	JButton contratar;
	
	public VentanaServicios(Cliente cliente) {
		
		setLayout(new GridLayout(5, 1));
		
		bg = new ButtonGroup();
		
		SPA = new JRadioButton("SPA ---> 100€");
		buffet = new JRadioButton("Buffet ---> 30€"); 
		deportes = new JRadioButton("Deportes ---> 20€");
		miniBar = new JRadioButton("Minibar ---> 80€"); 
		
		bg.add(SPA);
		bg.add(buffet);
		bg.add(deportes);
		bg.add(miniBar);
		
		contratar = new JButton("CONTINUAR");
		
		contratar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SPA.isSelected()) {
					String s = "SPA";
					//VentanaHoraServicio vhs = new VentanaHoraServicio(cliente, s);
				}else if(buffet.isSelected()) {
					String b = "Buffet";
					//VentanaHoraServicio vhs = new VentanaHoraServicio(cliente, b);
				}else if(deportes.isSelected()) {
					String d = "Deportes";
					//VentanaHoraServicio vhs = new VentanaHoraServicio(cliente, d);
				}else if(miniBar.isSelected()) {
					String mb = "MiniBar";
					//VentanaHoraServicio vhs = new VentanaHoraServicio(cliente, mb);
				}else {
					
				}
			}
		});
		
		add(SPA);
		add(buffet);
		add(deportes);
		add(miniBar);
		add(contratar);		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Registro del cliente");
		setSize(800, 200);
		setVisible(true);
		
	}

}
