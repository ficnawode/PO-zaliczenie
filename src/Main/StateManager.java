package Main;

import ResManagement.SoundManager;

import javax.swing.*;
import java.awt.*;

public class StateManager {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private MenuPanel menuPanel;
	private SettingsPanel settingsPanel;
	private PausePanel pausePanel;
	private JPanel cardPanel;
	private CardLayout cl;
	private String currentPanelName;
	private int loudness = 50;//between 0 and 100;

	private SoundManager soundManager;

	public StateManager() {
		cardPanel = new JPanel();
		gameWindow = new GameWindow();
		gameWindow.add(cardPanel);
		
		cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		menuPanel = new MenuPanel(this);		
		cardPanel.add(menuPanel, "menu");
		
		gamePanel = new GamePanel(this);
		cardPanel.add(gamePanel, "game");
		
		settingsPanel = new SettingsPanel(this);		
		cardPanel.add(settingsPanel, "settings");
		
		pausePanel = new PausePanel(this);
		cardPanel.add(pausePanel, "pause");
		
		soundManager = new SoundManager();

		
		this.changeToCard("menu");

		//gamePanel.requestFocus();
	}
	
	public void changeToCard(String cardName) {
		cl.show(cardPanel, cardName);
		this.currentPanelName = cardName;
		System.out.println("Changed panel to " + cardName);
	}
	
	public SoundManager getSoundManager() {
		return soundManager;
	}
	
	public GameWindow getGameWindow() {
		return gameWindow;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public String getCurrentPanelName() {
		return currentPanelName;
	}
}
