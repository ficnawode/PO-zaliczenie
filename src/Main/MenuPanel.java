package Main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ResManagement.Sound;

public class MenuPanel extends JPanel {
	
	Game game;
	JButton startButton;
	JButton settingsButton;
	JButton quitButton;
	
	public MenuPanel(Game game) {
		this.game = game;
		
		this.setLayout(null);
		
		this.startButton = new JButton("start");
		startButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			    game.changeToCard("game");
			}  
			});  
		
		startButton.setBounds(0, 0, 220, 30);
		this.add(startButton);
		
		this.settingsButton = new JButton("settings");
		settingsButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				game.getSoundManager().playClip("click1");
			    game.changeToCard("settings");
			}  
			}); 
		settingsButton.setBounds(0, 50, 220, 30);
		this.add(settingsButton);

		
		this.quitButton = new JButton("quit");
		quitButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			           System.exit(0);
			}  
			}); 
		quitButton.setBounds(0, 100, 220, 30);
		this.add(quitButton);
		


	}

	public void paintComponent(Graphics g) {
		
	}
}
