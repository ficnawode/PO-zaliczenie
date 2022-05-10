package Main.framework;

import java.awt.image.BufferedImage;
import java.util.Vector;

public class Animation {
    private Vector<BufferedImage> aniList;
    int len;
    int current;

    public Animation(BufferedImage spriteSheet, int len, int width, int height) {
        aniList = new Vector<>();
        this.len = len;
        for(int i = 0; i<len; i++)
            aniList.add(spriteSheet.getSubimage(i*width,0,width,height));
    }

    public BufferedImage getNextFrame () {
        current = (++current) % len;
        return aniList.get(current);
    }
}
