package Main.window;



import Main.Objects.*;
import Main.framework.GameObject;
import Main.framework.ObjectID;
import ResManagement.Images;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> objects = new LinkedList<>();

    private GameObject tempObject;
    private Camera camera;
    private Instance instance;

    public Handler(Camera camera, Instance instance) {
        this.camera = camera;
        this.instance = instance;
    }

    public void tick() {
        for(int i = 0; i < objects.size(); i++) {
            tempObject = objects.get(i);

            tempObject.setOnScreen(false);//overriden for background!!!

            if(tempObject.getX() > -camera.getX() - 50 &&
                tempObject.getX() < -camera.getX() + instance.getWidth() + 50 &&
                tempObject.getY() > -camera.getY() - 100 &&
                tempObject.getY() < -camera.getY() + instance.getHeight() - 50) {
                tempObject.setOnScreen(true);
            }



            tempObject.tick(objects);
        }
    }
    public void render(Graphics g) {
        for (GameObject object : objects) {
            if(object.getOnScreen())
                object.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }

    public void loadLevelFromImage(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();

        this.objects.clear();

        for(int i = 0; i<height; i++)
            for(int j = 0; j<width; j++) {
                int pixel = img.getRGB(i,j);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;


                //trees
                if(red == 0 && green == 255 && blue == 0) //green tree
                    this.addObject(new Tree(i*32,j*32, TreeID.greenFir));
                if(red == 175 && green == 75 && blue == 25) //brown tree
                    this.addObject(new Tree(i*32,j*32,TreeID.brownFir));

                //blocks
                if(red == 255 && green == 255 && blue == 255)
                    this.addObject(new Block(i*32,j*32, BlockID.grass1by1));
                if(red == 50 && green == 50 && blue == 50)
                    this.addObject(new Block(i*32,j*32,BlockID.rock1by1));

                //lava
                if(red == 255 && green == 75 && blue == 0)
                    this.addObject(new Lava(i*32, j*32));

                //lava
                if(red == 255 && green == 255 && blue == 0)
                    this.addObject(new LevelCompleter(i*32, j*32));


                //player
                if(red == 0 && green == 0 && blue ==255) {
                    this.addObject(new Player(i * 32, j * 32, this));
                    this.camera.setX(i*32);
                    this.camera.setY(j*32);
                }

            }
        //sort by ObjectID so trees are behind player and lava in front

        Background background = new Background(1000,1300, Images.getImg("menu.png"));
        this.camera.setBackground(background);
        this.addObject(background);

        Collections.sort(objects, Collections.reverseOrder());
    }

    public Instance getInstance(){
        return instance;
    }
}
