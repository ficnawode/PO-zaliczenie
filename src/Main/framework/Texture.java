package Main.framework;

import ResManagement.Images;

import java.awt.image.BufferedImage;

public class Texture {

    private BufferedImage tileset, playerIdleLeft, playerIdleRight, playerRunLeft,
            playerRunRight, playerJumpLeft, playerJumpRight, lava;

    public Texture(){
        tileset = Images.getSpriteSheet("tileset.png");

        playerIdleLeft = Images.getSpriteSheet("player/idle_left.png");
        playerIdleRight = Images.getSpriteSheet("player/idle_right.png");

        playerRunLeft = Images.getSpriteSheet("player/run_left.png");
        playerRunRight = Images.getSpriteSheet("player/run_right.png");

        playerJumpLeft = Images.getSpriteSheet("player/jump_left.png");
        playerJumpRight = Images.getSpriteSheet("player/jump_right.png");

        lava = Images.getSpriteSheet("lava.png");
    }

    public BufferedImage getTileset() {
        return tileset;
    }
    public BufferedImage getPlayerIdleLeft() {
        return playerIdleLeft;
    }
    public BufferedImage getPlayerIdleRight() {
        return playerIdleRight;
    }
    public BufferedImage getPlayerRunLeft() {
        return playerRunLeft;
    }
    public BufferedImage getPlayerRunRight() {
        return playerRunRight;
    }
    public BufferedImage getPlayerJumpLeft() {
        return playerJumpLeft;
    }
    public BufferedImage getPlayerJumpRight() {
        return playerJumpRight;
    }
    public BufferedImage getLava() {
        return lava;
    }
}
