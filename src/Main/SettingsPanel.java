package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ResManagement.Images;

public class SettingsPanel extends JPanel {
	
	StateManager stateManager;
	JButton menuButton;

	JLabel volumeIndicator;
	JSlider volumeSlider;
	Image bgImg;
	
	public SettingsPanel(StateManager stateManager) {
		this.stateManager = stateManager;
		this.bgImg = Images.getImg("menu.png");

		this.setLayout(null);
		
		this.menuButton = new JButton("menu");
		menuButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			           stateManager.changeToCard("menu");
			}  
			});  
		
		menuButton.setBounds(10, 10, 100, 30);
		this.add(menuButton);

		volumeSlider = new JSlider();
		volumeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				stateManager.getSoundManager().setVolume(((float)volumeSlider.getValue())/100f);
				volumeIndicator.setText(String.valueOf(volumeSlider.getValue()));
			}
		});
		volumeSlider.setBounds(100, 100, 200, 20);
		this.add(volumeSlider);

		volumeIndicator = new JLabel();
		volumeIndicator.setText(String.valueOf(volumeSlider.getValue()));
		volumeIndicator.setBounds(310,100,50,30);
		this.add(volumeIndicator);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImg, 0,0,null);
	}
}
