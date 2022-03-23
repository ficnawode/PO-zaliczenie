package Main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PausePanel extends JPanel {
	
	Game game;
	JButton menuButton;
	JButton gameButton;

	
	public PausePanel(Game game) {
		this.game = game;
		
		this.setLayout(null);
		
		this.menuButton = new JButton("back");
		menuButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			           game.changeToCard("menu");
			}  
			});  
		
		menuButton.setBounds(0, 0, 50, 30);
		this.add(menuButton);
		
		this.gameButton = new JButton("back to game");
		gameButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			           game.changeToCard("game");
			}  
			});  
		
		gameButton.setBounds(0, 50, 100, 30);
		this.add(gameButton);


	}

	public void paintComponent(Graphics g) {
		
	}
}
