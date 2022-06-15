package Main.Objects;

import Main.framework.Animation;
import Main.framework.GameObject;
import Main.framework.ObjectID;
import Main.framework.Texture;
import Main.window.Instance;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

public class Lava extends GameObject {

    private Animation animation;
    private int framesPerAnimation = 30;
    private int animationFrameCounter = 0;
    BufferedImage currentFrame;
    Texture texture = Instance.getTexture();
    private int width;
    private int height;

    public Lava(float x, float y) {
        super(x, y, ObjectID.Lava);
        this.width = 32;
        this.height = 32;
        animationFrameCounter = (int)(6*Math.random());
        animation = new Animation(texture.getLava(), 5, 32,32);
        currentFrame = animation.getNextFrame();
    }

    @Override
    public void tick(LinkedList<GameObject> objects) {
        animationFrameCounter = (++animationFrameCounter) % framesPerAnimation;
        if(animationFrameCounter == 0)
            currentFrame = animation.getNextFrame();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(currentFrame, (int)x, (int)y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int) y,(int) width,(int) height);
    }
}
