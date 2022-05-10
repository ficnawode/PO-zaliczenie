package Main.framework;

import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject implements Comparable<GameObject>{
    protected float x,y;
    protected ObjectID id;
    protected float velX = 0, velY = 0;
    protected boolean falling = true;
    protected boolean jumping = false;
    protected float width,height;
    private boolean onScreen;

    public GameObject(float x, float y, ObjectID id) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.onScreen = false;
    }

    public abstract void tick(LinkedList<GameObject> objects);
    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();


    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }
    public float getVelY() {
        return velY;
    }
    public void setVelX(float velX) {
        this.velX = velX;
    }
    public void setVelY(float velY) {
        this.velY = velY;
    }

    public boolean isFalling() {
        return falling;
    }
    public boolean isJumping() {
        return jumping;
    }
    public void setFalling(boolean falling) {
        this.falling = falling;
    }
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public ObjectID getId() {
        return id;
    }

    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }

    public boolean getOnScreen() {
        return onScreen;
    }
    public void setOnScreen(boolean onScreen) {
        this.onScreen = onScreen;
    }

    @Override
    public int compareTo(GameObject g) {
            return id.compareTo(g.id);
    }
}
