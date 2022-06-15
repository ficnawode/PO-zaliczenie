package Main.Objects;

import Main.framework.Animation;
import Main.framework.GameObject;
import Main.framework.ObjectID;
import Main.framework.Texture;
import Main.window.Instance;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class LevelCompleter  extends GameObject {

    BufferedImage currentFrame;
    Texture texture = Instance.getTexture();
    private int width;
    private int height;

    public LevelCompleter(float x, float y) {
        super(x, y, ObjectID.LevelCompleter);
        this.height = 32;
        this.width = 32;
        this.currentFrame = texture.getTileset().getSubimage(0,128,32,32);
    }

    @Override
    public void tick(LinkedList<GameObject> objects) {

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
