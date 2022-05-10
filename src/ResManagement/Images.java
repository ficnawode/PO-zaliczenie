package ResManagement;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {
	public static ImageIcon getImgIcon(String name) {		
		try {
			BufferedImage bImg = ImageIO.read(new File("./res/images/" + name));
			return new ImageIcon(bImg);
		} catch (IOException e) {
			System.out.println("Image not found.");
			e.printStackTrace();
		}
		return null;
	}
	
	public static BufferedImage getImg(String name) {
		try {
			BufferedImage bImg = ImageIO.read(new File("./res/images/" + name));
			return bImg;
		} catch (IOException e) {
			System.out.println("Image not found.");
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage getLevelImg(String name){
		try {
			BufferedImage bImg = ImageIO.read(new File("./res/levels/" + name));
			return bImg;
		} catch (IOException e) {
			System.out.println("Image not found.");
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage getSpriteSheet(String name) {
		try {
			BufferedImage bImg = ImageIO.read(new File("./res/spriteSheets/" + name));
			return bImg;
		} catch (IOException e) {
			System.out.println("Image not found.");
			e.printStackTrace();
		}
		return null;
	}
}
