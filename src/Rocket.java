import javax.swing.*;
import java.awt.*;

public class Rocket {
    private static final ImageIcon rocketImage = new ImageIcon("src/assets/rocket.gif");
    private final int rocketWidth;
    private final int rocketHeight;
    private final int xPosition;
    private int yPosition;

    public Rocket(BattleShip battleShip) {
        this.rocketWidth = battleShip.getShipSize() / 2;
        this.rocketHeight = battleShip.getShipSize();
        this.xPosition = battleShip.getxPosition() + rocketWidth / 2;
        this.yPosition = battleShip.getyPosition() - rocketHeight / 2;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(rocketImage.getImage(), xPosition, yPosition, rocketWidth, rocketHeight, null);
    }

    public void move() {
        int speed = 5;
        yPosition -= speed;
    }

    public boolean checkOutScreen() {
        return yPosition < -rocketHeight;
    }

    public Rectangle getBounds() {
        return new Rectangle(xPosition, yPosition, rocketWidth, rocketHeight);
    }
}
