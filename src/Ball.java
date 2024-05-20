import java.awt.*;

public class Ball {
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private final Game game;
    private static final int DIAMETER = 30;

    public Ball(Game game) {
        this.game= game;
    }
    public void move() {
        boolean changeDirection = true;
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
        else
            changeDirection = false;
        x = x + xa;
        y = y + ya;
        if (changeDirection)
            AudioGame.play("BALL");

    }
    public void paint(Graphics2D g) {
        g.setColor(Color.pink);
        g.fillOval(x, y, 30, 30);
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
