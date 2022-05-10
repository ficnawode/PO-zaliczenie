package Main.Objects;

import Main.framework.GameObject;
import Main.framework.ObjectID;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Background extends GameObject {
    BufferedImage image;

    public Background(int x,int y,BufferedImage image) {
        super(x,y, ObjectID.Background);
        this.image = image;
    }

    @Override
    public void tick(LinkedList<GameObject> objects) {
        this.setOnScreen(true);
        for(GameObject object : objects) {
            if(object.getId() == ObjectID.Player) {
                this.x = 0.9f*object.getX() - 1000;
            }
        }
    }

    public void render(Graphics g) {
        g.drawImage(image, (int)x,(int)y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,image.getWidth(), image.getHeight());
    }
}
