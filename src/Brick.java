import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Brick {
    private final int x, y, width, height;
    private final Image img;
    final private String[] imagePaths = {
            "src/assets/01-Breakout-Tiles.png",
            "src/assets/03-Breakout-Tiles.png",
            "src/assets/05-Breakout-Tiles.png",
            "src/assets/07-Breakout-Tiles.png",
            "src/assets/09-Breakout-Tiles.png",
            "src/assets/11-Breakout-Tiles.png",
            "src/assets/13-Breakout-Tiles.png",
            "src/assets/15-Breakout-Tiles.png",
            "src/assets/17-Breakout-Tiles.png",
            "src/assets/19-Breakout-Tiles.png"
    };

    public Brick(int x, int y, int width, int height) throws IOException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Random random = new Random();
        this.img = ImageIO.read(new File(imagePaths[random.nextInt(imagePaths.length)]));
    }

    public void paint(Graphics2D g) {
        g.drawImage(img, x, y, width, height, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
