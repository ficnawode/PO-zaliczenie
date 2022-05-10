package Main;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ResManagement.Images;
import ResManagement.Sound;

public class MenuPanel extends JPanel {
	
	StateManager stateManager;
	
	Image bgImg;
	ImageIcon buttonIcon;
	JButton startButton;
	JButton settingsButton;
	JButton quitButton;
	
	public MenuPanel(StateManager stateManager) {
		this.bgImg = Images.getImg("menu.png");
		this.buttonIcon = new ImageIcon(Images.getImg("menu.png"));
		
		
		this.setLayout(new GridBagLayout());
		
		this.startButton = new JButton(Images.getImgIcon("startButton.png"));
		startButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				stateManager.getSoundManager().playClip("click1");
			    stateManager.changeToCard("game");
				stateManager.getGamePanel().getInstance().start();
			}  
			});  
		startButton.setBorderPainted(false);
	    startButton.setFocusPainted(false);
	    startButton.setContentAreaFilled(false);
		this.add(startButton);
		
		this.settingsButton = new JButton(Images.getImgIcon("settingsButton.png"));
		settingsButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				stateManager.getSoundManager().playClip("click1");
			    stateManager.changeToCard("settings");
			}  
			}); 
		settingsButton.setBorderPainted(false);
	    settingsButton.setFocusPainted(false);
	    settingsButton.setContentAreaFilled(false);
		this.add(settingsButton);

		
		this.quitButton = new JButton(Images.getImgIcon("quitButton.png"));
		quitButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				stateManager.getSoundManager().playClip("click1");
			    System.exit(0);
			}  
			});
		quitButton.setBorderPainted(false);
	    quitButton.setFocusPainted(false);
	    quitButton.setContentAreaFilled(false);
		this.add(quitButton);
		


	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImg, 0,0,null);
	}
}
