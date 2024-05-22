import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Rec {
    private final BrickBreaker game;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 40;
    public Rec(BrickBreaker game) {
        this.game= game;
    }
    public void paint(Graphics2D g) throws IOException {
        Image img = ImageIO.read(new File("src/assets/56-Breakout-Tiles.png"));
        g.drawImage(img, 100, 50, WIDTH, HEIGHT, null);
    }
}
