import javax.swing.*;
import java.awt.*;

public class Rocket extends JPanel {
    private final GamePlay game;
    private final BattleShip battleShip;
    private int rocketWidth = 40;
    private int rocketHeight = 100;
    private int xPosition;
    private int yPosition;

    public Rocket(GamePlay game, BattleShip battleShip) {
        this.game = game;
        this.battleShip = battleShip;
        this.rocketWidth = battleShip.shipSize / 2;
        this.rocketHeight = battleShip.shipSize;
        this.xPosition = battleShip.xPosition + rocketWidth / 2;
        this.yPosition = battleShip.yPosition - rocketHeight / 2;
        System.out.println(xPosition + ""+ rocketWidth);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon rocketImage = new ImageIcon("src/assets/rocket.gif");
        g.drawImage(rocketImage.getImage(), xPosition, yPosition, rocketWidth, rocketHeight, this);
//        g.setColor(Color.GREEN);
//        g.drawRect(xPosition, yPosition, rocketWidth, rocketHeight);
    }
}
