import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Racquet {
    int x = 0;
    int xa = 0;
    private final BrickBreaker game;
    private static final int Y = 450;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 40;

    public Racquet(BrickBreaker game) {
        this.game= game;
        this.x = 700 / 2 - WIDTH / 2;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth()-WIDTH)
            x = x + xa;
    }

    public void paint(Graphics2D g) throws IOException {
        Image img = ImageIO.read(new File("src/assets/56-Breakout-Tiles.png"));
        g.drawImage(img, x, Y, WIDTH, HEIGHT, null);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 1;
    }

    public int getTopY() {
        return Y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }
}