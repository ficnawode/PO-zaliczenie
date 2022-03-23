package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
	
	public GameWindow() {
		super();
	
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void changePanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(new JPanel());
	}
	
	
}
