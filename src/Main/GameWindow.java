package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	public GameWindow() {
		super();
	
		this.setSize(1280,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setFocusable(true);
		this.setVisible(true);
	}
	
	public void changePanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(new JPanel());
	}
	
	
}
