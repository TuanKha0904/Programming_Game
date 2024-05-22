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
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if (y + ya < 0 || y + ya > game.getHeight() - DIAMETER)
            game.gameOver(); // can change to gameWin
        else if (collision() != 0) {
            ya = collision() == 1 ? game.speed : -game.speed;
        } else
            changeDirection = false;

        if (changeDirection)
            AudioGame.play("BALL");

        x = x + xa;
        y = y + ya;
        if (changeDirection)
            AudioGame.play("BALL");

    }

    private int collision() {
        if (game.racquet.getBounds().intersects(getBounds()))
            return 2;
        if (game.racquet2.getBounds().intersects(getBounds()))
            return 1;
        return 0;
    }
    public void paint(Graphics2D g) {
        g.setColor(Color.pink);
        g.fillOval(x, y, 30, 30);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
