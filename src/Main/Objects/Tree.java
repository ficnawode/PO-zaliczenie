package Main.Objects;

import Main.framework.GameObject;
import Main.framework.ObjectID;
import Main.framework.Texture;
import Main.window.Instance;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Tree extends GameObject {
    int type = 0; //number from 0 to 1, as we have 2 tree types
    static boolean imagesLoaded = false;
    static Map<TreeID, BufferedImage> treeMap;
    private Texture texture = Instance.getTexture();
    private TreeID treeID;

    public Tree(int x,int y, TreeID treeID){
        super(x,y, ObjectID.Tree);
        if(treeMap == null) {
            treeMap = new HashMap<>();
            treeMap.put(TreeID.greenFir, texture.getTileset().getSubimage(8*32,6*32,2*32,4*32));
            treeMap.put(TreeID.brownFir, texture.getTileset().getSubimage(10*32,6*32,2*32,4*32));
        }
        this.treeID = treeID;
    }


    public void tick(LinkedList<GameObject> objects) {

    }

    public void render(Graphics g) {
        g.drawImage(treeMap.get(treeID),(int)x,(int)y,null);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,(int)width,(int)height);
    }
}
