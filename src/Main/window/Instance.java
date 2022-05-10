package Main.window;

import Main.Objects.Player;
import Main.StateManager;
import Main.framework.*;
import Main.Objects.Block;
import Main.Objects.Player;
import Main.framework.KeyInput;
import Main.framework.ObjectID;
import ResManagement.Images;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.Window;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Instance extends JPanel implements Runnable {

    private boolean running = false;
    private Thread thread;
    private Handler handler;
    private Camera camera;
    private JFrame parentFrame;
    private BufferStrategy bufferStrategy;
    private StateManager stateManager;
    private boolean paused = false;

    private static Texture texture;

    private BufferedImage level = null;

    public static int WIDTH, HEIGHT;

    public Instance(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void init() {

        WIDTH = stateManager.getGameWindow().getWidth();
        HEIGHT = stateManager.getGamePanel().getHeight();

        texture = new Texture();

        level = Images.getLevelImg("level0.png");
        this.camera = new Camera(4000,4000);
        handler = new Handler(this.camera, this);
        handler.loadLevelFromImage(level);

        parentFrame.createBufferStrategy(3);
        this.bufferStrategy = parentFrame.getBufferStrategy();



        KeyInput listener = new KeyInput(handler, stateManager, this);
        this.addKeyListener(listener);
        parentFrame.addKeyListener(listener);


    }

    public synchronized void start() {
        if(running) {
            paused = false;
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
            this.setFocusable(true);
            this.requestFocus();

            init();


            long lastTime = System.nanoTime();
            double amountOfTicks = 60.0;
            double ns = 1000000000 / amountOfTicks;
            double delta = 0;
            long timer = System.currentTimeMillis();
            short updates = 0;
            int frames = 0;

            while (running) {
                if(!paused) {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while (delta >= 1) {
                        tick();
                        updates++;
                        delta--;
                    }
                    render();
                    frames++;

                    if (System.currentTimeMillis() - timer > 1000) {
                        timer += 1000;
                        System.out.println("FPS: " + frames + " | TICKS: " + updates);
                        frames = 0;
                        updates = 0;
                    }
                }
            }
        }

    private void tick() {
        handler.tick();
        for(int i = 0; i<handler.objects.size(); i++)
            if(handler.objects.get(i).getId() == ObjectID.Player) {
                camera.tick(handler.objects.get(i));
                break;
            }

        WIDTH = stateManager.getGameWindow().getWidth();
        HEIGHT = stateManager.getGamePanel().getHeight();
    }

    private void render() {

        Graphics g = bufferStrategy.getDrawGraphics();
        Graphics2D g2d = (Graphics2D)g;

        //drawspace
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());

        g2d.translate(camera.getX(), camera.getY());

        handler.render(g);

        g2d.translate(camera.getX(), -camera.getY());

        g.dispose();
        bufferStrategy.show();
    }

    public void setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public static Texture getTexture() {
        return texture;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public Thread getThread() {
        return thread;
    }
}