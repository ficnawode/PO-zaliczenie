package Main;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Main.window.Instance;

public class GamePanel extends JPanel {
	private Instance instance;
	
	public GamePanel(StateManager stateManager) {
		//KeyListener kl = new KeyboardInput(this, game);

		//this.initKeyBindings();
		//this.addMouseListener(new MouseInput(this));
		//this.addMouseMotionListener(new MouseInput(this));

		this.instance = new Instance(stateManager);
		instance.setPreferredSize(new Dimension(1280,800));
		instance.setMaximumSize(new Dimension(1280,800));
		instance.setMinimumSize(new Dimension(1280,800));
		instance.setParentFrame(stateManager.getGameWindow());
		this.add(instance);
	}
	
	private void initKeyBindings() {
		//space
		this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "spacePressed");
		
		Action spacePressed = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("space pressed");
			}
		};
		
		this.getActionMap().put("spacePressed", spacePressed);
		
		//a
		this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "aKeyPressed");
		
		Action aKeyPressed = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("a pressed");
			}
		};
		
		this.getActionMap().put("aKeyPressed", aKeyPressed);
		
		//w
		this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "wKeyPressed");
		
		Action wKeyPressed = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("w pressed");
			}
		};
		
		this.getActionMap().put("wKeyPressed", wKeyPressed);
		
		//s
		this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "sKeyPressed");
		
		Action sKeyPressed = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("s pressed");
			}
		};
		
		this.getActionMap().put("sKeyPressed", sKeyPressed);
		
		//d
		this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "dKeyPressed");
		
		Action dKeyPressed = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("d pressed");
			}
		};
		
		this.getActionMap().put("dKeyPressed", dKeyPressed);
		
		//esc
		this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escKeyPressed");
		
		Action escKeyPressed = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("esc pressed");
			}
		};
		
		this.getActionMap().put("escKeyPressed", escKeyPressed);
		
	}

	public Instance getInstance() {
		return instance;
	}

}
