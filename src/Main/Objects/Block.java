package Main.Objects;

import Main.framework.GameObject;
import Main.framework.ObjectID;
import Main.framework.Texture;
import Main.window.Instance;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Block extends GameObject{

    Texture texture = Instance.getTexture();
    BlockID blockID;
    BufferedImage blockImg;

    public Block(float x, float y, BlockID blockID) {
        super(x, y, ObjectID.Block);
        this.width = 32f;
        this.height = 32f;

        this.blockID = blockID;
        switch (blockID) {
            case grass1by1:
                blockImg = texture.getTileset().getSubimage(0,0,32,32);
                this.width = 32f;
                this.height = 32f;
                break;
            case rock1by1:
                blockImg = texture.getTileset().getSubimage(0,32,32,32);
                this.width = 32f;
                this.height = 32f;
                break;
        }
    }

    public void tick(LinkedList<GameObject> objects) {
    }

    public void render(Graphics g) {
        g.drawImage(blockImg, (int)x,(int)y, null);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int)width, (int)height);
    }
}
