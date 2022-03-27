package Main;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class Game {
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private MenuPanel menuPanel;
	private SettingsPanel settingsPanel;
	private PausePanel pausePanel;
	
	private JPanel cardPanel;
	
	private CardLayout cl;
	
	private int loudness = 50;//between 0 and 100;
	
	public Game() {
		
		cardPanel = new JPanel();
		gameWindow = new GameWindow();
		gameWindow.add(cardPanel);
		
		cl = new CardLayout();
		cardPanel.setLayout(cl);
		
		gamePanel = new GamePanel(this);
		cardPanel.add(gamePanel, "game");
		
		menuPanel = new MenuPanel(this);		
		cardPanel.add(menuPanel, "menu");
		
		settingsPanel = new SettingsPanel(this);		
		cardPanel.add(settingsPanel, "settings");
		
		pausePanel = new PausePanel(this);
		cardPanel.add(pausePanel, "pause");

		
		cl.show(cardPanel, "menu");

		//gamePanel.requestFocus();
	}
	
	public void changeToCard(String cardName) {
		cl.show(cardPanel, cardName);
	}
}
