package Main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ResManagement.Images;

public class SettingsPanel extends JPanel {
	
	StateManager stateManager;
	JButton menuButton;
	JLabel testImage;
	
	public SettingsPanel(StateManager stateManager) {
		this.stateManager = stateManager;
		
		this.setLayout(null);
		
		this.menuButton = new JButton("menu");
		menuButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			           stateManager.changeToCard("menu");
			}  
			});  
		
		menuButton.setBounds(0, 0, 100, 30);
		this.add(menuButton);
		
		testImage = new JLabel(Images.getImgIcon("example.png"));
		testImage.setBounds(50,50,100,100);
		this.add(testImage);
	}

	public void paintComponent(Graphics g) {
		
	}
}
