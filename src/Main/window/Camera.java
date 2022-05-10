package Main.window;
import Main.Objects.Background;
import Main.Objects.Player;
import Main.framework.GameObject;

public class Camera {
    private float x, y;
    private boolean initFlag = true;

    //camera changes bg position
    private Background background;

    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject player) {
        x = -player.getX() + (float) Instance.WIDTH / 2 ;

        y = -player.getY() + (float) Instance.HEIGHT / 2 ;
    }

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

    public void setBackground(Background background) {
        this.background = background;
    }

}