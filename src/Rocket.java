import javax.swing.*;
import java.awt.*;

public class Rocket extends JPanel {
    ImageIcon rocketImage;
    private final int rocketWidth;
    private final int rocketHeight;
    private final int xPosition;
    private int yPosition;

    public Rocket(BattleShip battleShip) {
        this.rocketWidth = battleShip.shipSize / 2;
        this.rocketHeight = battleShip.shipSize;
        this.xPosition = battleShip.xPosition + rocketWidth / 2;
        this.yPosition = battleShip.yPosition - rocketHeight / 2;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        rocketImage = new ImageIcon("src/assets/rocket.gif");
        g.drawImage(rocketImage.getImage(), xPosition, yPosition, rocketWidth, rocketHeight, this);
    }

    public void move() {
        if ((yPosition > -rocketHeight)) {
            int speed = 3;
            yPosition -= speed;
        }
    }
}
