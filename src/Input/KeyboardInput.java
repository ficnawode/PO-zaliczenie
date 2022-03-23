package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.Game;
import Main.GamePanel;

public class KeyboardInput implements KeyListener {
	GamePanel gamePanel;
	Game game;
	
	public KeyboardInput(GamePanel gamePanel, Game game) {
		this.gamePanel = gamePanel;
		this.game = game;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
			System.out.println("a");
			gamePanel.changeXDelta(-5);
			break;
		case KeyEvent.VK_W:
			gamePanel.changeYDelta(-5);
			break;
		case KeyEvent.VK_S:
			gamePanel.changeYDelta(5);
			break;
		case KeyEvent.VK_D:
			gamePanel.changeXDelta(5);
			break;
		case KeyEvent.VK_ESCAPE:
			game.changeToCard("pause");
			break;
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
