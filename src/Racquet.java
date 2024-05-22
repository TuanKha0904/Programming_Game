import java.awt.*;
import java.awt.event.KeyEvent;
enum RacquetDirection {
    LEFT, RIGHT
}

public class Racquet {
    int x = 0;
    int xa = 0;
    private final Game game;
    int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;

    public Racquet(Game game, int x, int xa, int y) {
        this.game= game;
        this.x = x;
        this.xa = xa;
        this.Y = y;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth()-60)
            x = x + xa;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, Y, 60, 10);
        g.setColor(Color.pink);
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

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return Y;
    }

    public void keyPressed(RacquetDirection racquetDirection) {
        if (racquetDirection == RacquetDirection.LEFT)
            xa = -1;
        if (racquetDirection == RacquetDirection.RIGHT)
            xa = 1;
    }
}
