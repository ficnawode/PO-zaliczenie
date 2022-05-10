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
			break;
		case KeyEvent.VK_W:
			System.out.println("w");
			break;
		case KeyEvent.VK_S:
			System.out.println("s");
			break;
		case KeyEvent.VK_D:
			System.out.println("d");
			break;
		case KeyEvent.VK_ESCAPE:
			game.changeToCard("pause");
			break;
		}
		System.out.println("hello tho");
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
