package Main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel {
	
	Game game;
	JButton menuButton;
	
	public SettingsPanel(Game game) {
		this.game = game;
		
		this.setLayout(null);
		
		this.menuButton = new JButton("menu");
		menuButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			           game.changeToCard("menu");
			}  
			});  
		
		menuButton.setBounds(0, 0, 100, 30);
		this.add(menuButton);
		
		


	}

	public void paintComponent(Graphics g) {
		
	}
}
