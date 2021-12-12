package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    private BufferedImage img;
    public static String mainMenuBackground = "/background.png";
    public static String startButtonBefore = "/startButtonBefore.png";
    public static String startButtonAfter = "/startButtonAfter.png";
    public static String infoButtonBefore = "/infoButtonBefore.png";
    public static String infoButtonAfter = "/infoButtonAfter.png";
    public static String scoreButtonBefore = "/scoreButtonBefore.png";
    public static String scoreButtonAfter = "/startButtonAfter.png";
    public static String exitButtonBefore = "/exitButtonBefore.png";
    public static String exitButtonAfter = "/exitButtonAfter.png";
    public static String infoBackground = "/infoPage.png";
    public static String highScoreBackground = "/highscoreBackground.png";




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

    /*
    public BufferedImage getSubImage(int section) {
        return img.getSubimage(0, section*25, 50, 25);
    }
    */
}
