import javax.swing.*;
import java.awt.*;

public class EnemyBullet {
    private static final ImageIcon bulletImage = new ImageIcon("src/assets/enemybullets.gif");
    private final int bulletWidth;
    private final int bulletHeight;
    private final int xPosition;
    private int yPosition;
    private final GamePlay game;

    public EnemyBullet(GamePlay game, EnemyShip enemyShip) {
        this.game = game;
        this.bulletWidth = enemyShip.getShipSize() / 2;
        this.bulletHeight = enemyShip.getShipSize() / 2;
        this.xPosition = enemyShip.getxPosition() + bulletWidth / 2;
        this.yPosition = enemyShip.getyPosition() + bulletHeight / 2;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(bulletImage.getImage(), xPosition, yPosition, bulletWidth, bulletHeight, null);
    }

    public void move() {
        int speed = 5;
        yPosition += speed;
    }

    public boolean checkOutScreen() {
        return yPosition > game.getHeight() + bulletHeight;
    }
}
