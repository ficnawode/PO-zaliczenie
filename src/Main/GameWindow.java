package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	public GameWindow() {
		super();
	
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void changePanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(new JPanel());
	}
	
	
}
