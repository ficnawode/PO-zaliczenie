package Main.framework;

import Main.Objects.Player;
import Main.StateManager;
import Main.window.Handler;
import Main.window.Handler;
import Main.window.Instance;
import ResManagement.Sound;
import ResManagement.SoundManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    private StateManager stateManager;//required to switch between states
    private Instance instance;

    public KeyInput(Handler handler, StateManager stateManager, Instance instance) {
        this.handler = handler;
        this.stateManager = stateManager;
        this.instance = instance;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();


        //loop through object list, find player
        for(int i = 0; i<handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if(tempObject.getId() == ObjectID.Player) {
                Player tempPlayer = (Player) tempObject;
                if(key == KeyEvent.VK_D) {
                    stateManager.getSoundManager().playClip("run");
                    tempPlayer.setDirection('R');
                    tempPlayer.setCurrentAnimationRun();
                    tempPlayer.setVelX(5);
                }
                if(key == KeyEvent.VK_A) {
                    stateManager.getSoundManager().playClip("run");
                    tempPlayer.setDirection('L');
                    tempPlayer.setCurrentAnimationRun();
                    tempObject.setVelX(-5);
                }
                if(key == KeyEvent.VK_W && !tempObject.isJumping()) {
                    stateManager.getSoundManager().playClip("jump");
                    tempObject.setVelY(-5);
                    tempPlayer.setCurrentAnimationJump();
                    tempObject.setFalling(true);
                    tempObject.setJumping(true);
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        //loop through object list, find player
        for(int i = 0; i<handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if(tempObject.getId() == ObjectID.Player) {
                if(key == KeyEvent.VK_D)
                    tempObject.setVelX(0);
                if(key == KeyEvent.VK_A)
                    tempObject.setVelX(0);


            }
        }
        if(key == KeyEvent.VK_ESCAPE) {
            if(stateManager.getCurrentPanelName().equals("game")) {
                System.out.println("paused");
                instance.setPaused(true);
                stateManager.changeToCard("pause");
            }
            else if(stateManager.getCurrentPanelName().equals("settings"))
                stateManager.changeToCard("menu");
            else if(stateManager.getCurrentPanelName().equals("pause")) {
                instance.setPaused(false);
                stateManager.changeToCard("game");
            }
        }
    }

}
