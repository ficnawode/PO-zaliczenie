package Main;

import java.awt.Graphics;

import javax.swing.JPanel;

import Input.KeyboardInput;
import Input.MouseInput;

public class GamePanel extends JPanel{
	private int xDelta = 100;
	private int yDelta = 100;
	
	private int frames = 0;
	private long lastCheck;
	
	
	public void changeXDelta(int value) {
		this.xDelta += value;
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
	}
	
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
	}
	
	public GamePanel(Game game) {
		this.addKeyListener(new KeyboardInput(this, game));
		this.addMouseListener(new MouseInput(this));
		this.addMouseMotionListener(new MouseInput(this));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		updateRectangle();
		g.fillRect(xDelta, yDelta, 200, 200);
		this.frames++;
		if(System.currentTimeMillis() - this.lastCheck >= 1000) {
			System.out.println(frames + " | fps");
			frames = 0;
			this.lastCheck = System.currentTimeMillis();
		}
		
		this.repaint();

	}

	private void updateRectangle() {
		/*
		if(xDelta > 300 || xDelta < 0) 
			xDir *= -1;
		if(yDelta > 400 || yDelta < 0)
			yDir *= -1;
		
		xDelta += xDir; 
	    yDelta += yDir;
	    */
	}
}
