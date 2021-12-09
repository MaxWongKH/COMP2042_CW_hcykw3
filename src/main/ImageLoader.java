package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    private BufferedImage img;
    public static String mainMenuBackground = "/background.png";
    public static String ball = "/Red-Ball-PNG.png";
    public static String paddle = "/paddle.png";


    public ImageLoader(String path) {
        try {
            img = ImageIO.read(ImageLoader.class.getResourceAsStream(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedImage getImage() {
        return img;
    }
    public BufferedImage getSubImage(int section) {
        return img.getSubimage(0, section*25, 50, 25);
    }
}
