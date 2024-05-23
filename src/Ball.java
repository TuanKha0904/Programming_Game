import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Ball {
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private final BrickBreaker game;
    private static final int DIAMETER = 30;

    public Ball(BrickBreaker game) {
        this.game= game;
        this.x = 700 / 2 - DIAMETER / 2;
        this.y = 450 - DIAMETER;
    }
    public void move() {
        if (x + xa < 0)
            xa = 1;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -1;
        else if (y + ya < 0)
            ya = 1;
        else if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        else if (collision()){
            ya = -1;
            y = game.racquet.getTopY() - DIAMETER;
        }
        x = x + xa;
        y = y + ya;
        checkCollisionWithBricks();
    }
    public void paint(Graphics2D g) throws IOException {
        Image img = ImageIO.read(new File("src/assets/60-Breakout-Tiles.png"));
        g.drawImage(img, x, y, DIAMETER, DIAMETER, null);
    }

    private void checkCollisionWithBricks() {
        Iterator<Brick> iterator = game.rec.getBricks().iterator();
        while (iterator.hasNext()) {
            Brick brick = iterator.next();
            if (getBounds().intersects(brick.getBounds())) {
                iterator.remove();
                ya = -ya;
            }
        }
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}