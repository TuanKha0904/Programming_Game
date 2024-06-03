import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EnemyShip {
    private final ImageIcon enemyShipImage = new ImageIcon("src/assets/enemyship.gif");
    private final GamePlay game;
    private final int shipSize = 50;
    private final int xPosition;
    private int yPosition = -100;

    public EnemyShip(GamePlay game) {
        this.game = game;
        Random random = new Random();
        this.xPosition = random.nextInt(game.getWidth());
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(enemyShipImage.getImage(), xPosition, yPosition, shipSize, shipSize, null);
    }

    public void move() {
        int speed = 1;
        yPosition += speed;
    }


    public boolean checkOutScreen() {
        return yPosition > game.getHeight() + shipSize;
    }
}
