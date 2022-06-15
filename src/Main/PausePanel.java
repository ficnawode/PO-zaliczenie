package Main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.nimbus.State;

public class PausePanel extends JPanel {
	
	StateManager stateManager;
	JButton menuButton;
	JButton gameButton;

	
	public PausePanel(StateManager stateManager) {
		this.stateManager = stateManager;
		
		this.setLayout(null);
		
		this.menuButton = new JButton("back");
		menuButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			           stateManager.changeToCard("menu");
			}  
			});  
		
		menuButton.setBounds(10, 10, 100, 30);
		this.add(menuButton);
		
		this.gameButton = new JButton("back to game");
		gameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){  
			    stateManager.getGamePanel().getInstance().setPaused(false);
				stateManager.changeToCard("game");
			}  
			});  
		
		gameButton.setBounds(10, 60, 100, 30);
		this.add(gameButton);
	}

	public void paintComponent(Graphics g) {
		
	}
}
