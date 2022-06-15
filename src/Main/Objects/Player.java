package Main.Objects;

import Main.framework.Animation;
import Main.framework.GameObject;
import Main.framework.ObjectID;
import Main.framework.Texture;
import Main.window.Handler;
import Main.window.Instance;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Player extends GameObject {
    private final float width = 48, height = 96;
    private final float gravity = 0.2f;
    private final float TERMINAL_VELOCITY = 5;

    private Handler handler;

    private Texture texture = Instance.getTexture();
    private Animation idleL,idleR,runL,runR,jumpL,jumpR;
    private Animation currentAnimation;
    private BufferedImage currentFrame;
    private char direction = 'R';

    private final int framesPerAnimation = 20;
    private int animationFrameCounter = 0;

    public Player(float x, float y, Handler handler) {
        super(x, y, ObjectID.Player);
        this.handler = handler;

        this.idleL = new Animation(texture.getPlayerIdleLeft(), 6, 32,32);
        this.idleR = new Animation(texture.getPlayerIdleRight(), 6, 32,32);

        this.runL = new Animation(texture.getPlayerRunLeft(), 8, 32,32);
        this.runR = new Animation(texture.getPlayerRunRight(), 8, 32,32);

        this.jumpL = new Animation(texture.getPlayerJumpLeft(), 5, 32,32);
        this.jumpR = new Animation(texture.getPlayerJumpRight(), 5, 32,32);

        this.currentAnimation = idleR;
        this.currentFrame = currentAnimation.getNextFrame();
    }

    public void tick(LinkedList<GameObject> objects) {
        x += velX;
        y += velY;

        animationFrameCounter = (++animationFrameCounter) % framesPerAnimation;
        if(animationFrameCounter == 0)
            currentFrame = currentAnimation.getNextFrame();
        if(this.velX ==0 && this.velY == 0)
            this.setCurrentAnimationIdle();

        if(falling || jumping && velY <= TERMINAL_VELOCITY) {
            velY += gravity;
        }
        collision(handler.objects);
    }

    private void collision(LinkedList<GameObject> objects) {

        for(int i = 0; i<objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if(tempObject.getId() == ObjectID.Lava && (
            getBoundsBottom().intersects(tempObject.getBounds()) ||
            getBoundsTop().intersects(tempObject.getBounds()) ||
            getBoundsLeft().intersects(tempObject.getBounds()) ||
            getBoundsRight().intersects(tempObject.getBounds())
            )){
                handler.getInstance().setPaused(true);
                handler.getInstance().getStateManager().gameOver();
            }

            if(tempObject.getId() == ObjectID.LevelCompleter && (
                    getBoundsBottom().intersects(tempObject.getBounds()) ||
                            getBoundsTop().intersects(tempObject.getBounds()) ||
                            getBoundsLeft().intersects(tempObject.getBounds()) ||
                            getBoundsRight().intersects(tempObject.getBounds())
            )){
                handler.getInstance().setLevel("level1.png");
                handler.getInstance().getStateManager().getSoundManager().playClip("levelComplete");
                System.out.println("level completed");
            }

            if(tempObject.getId() == ObjectID.Block) {
                if(getBoundsBottom().intersects(tempObject.getBounds())) {
                    //snap to top of block
                    y = tempObject.getY() - this.height;
                    velY = 0;
                    falling = false;
                    jumping = false;
                }
                if(getBoundsTop().intersects(tempObject.getBounds())) {
                    y = tempObject.getY() + tempObject.getHeight();
                    velY = 0;
                    velX = 0;
                    falling = true;
                    jumping = true;
                }
                if(getBoundsLeft().intersects(tempObject.getBounds())) {
                    velX = 0;
                    x = tempObject.getX() + tempObject.getWidth() + 5;

                    velX = 0;
                    falling = true;
                    jumping = true;
                }
                if(getBoundsRight().intersects(tempObject.getBounds())) {
                    velX = 0;
                    x = tempObject.getX() - tempObject.getWidth() - 20;

                    falling = true;
                    jumping = true;
                }
                else {
                    falling = true;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.drawImage( currentFrame, (int) x, (int) y, (int) width, (int) height, null);
        Graphics2D g2d = (Graphics2D) g;
    }

    private class floatRectangle extends Rectangle{
        floatRectangle(float x,float y, float width, float height) {
            super((int) x , (int)y, (int)width, (int) height);
        }
    }

    public Rectangle getBounds() {
        return new floatRectangle(x,y,width,height);
    }

    public Rectangle getBoundsBottom() {
        return new floatRectangle(x + (width/4),y + (height/2), width/2,  height/2);
    }
    public Rectangle getBoundsTop() {
        return new floatRectangle(x + (width/4),y,width/2, height/2);
    }
    public Rectangle getBoundsRight() {
        return new floatRectangle(x + width - 5, y + 5, 5,  height - 10);
    }
    public Rectangle getBoundsLeft() {
        return new floatRectangle(x, y + 5, 5, height - 10);
    }

    public void setCurrentAnimationIdle() {
        if(this.direction == 'L')
            this.currentAnimation = idleL;
        if(this.direction == 'R')
            this.currentAnimation = idleR;
    }

    public void setCurrentAnimationRun() {
        if(this.direction == 'L')
            this.currentAnimation = runL;
        if(this.direction == 'R')
            this.currentAnimation = runR;
    }
    public void setCurrentAnimationJump() {
        if(this.direction == 'L')
            this.currentAnimation = jumpL;
        if(this.direction == 'R')
            this.currentAnimation = jumpR;
    }

    public char getDirection() {
        return direction;
    }
    public void setDirection(char direction) {
        this.direction = direction;
    }
}
