import javax.swing.*;
import java.awt.*;

public class BattleShip extends JPanel {
    private final GamePlay game;
    private final int heightSize = 100;
    private final int widthSize = 100;
    private final int xPosition;
    private final int yPosition;
    private final Image battleShipImage;

    public BattleShip(GamePlay game) {
        this.game = game;
        this.xPosition = (game.WIDTH - widthSize) / 2;
        this.yPosition = game.HEIGHT - heightSize * 2;
        this.battleShipImage = new ImageIcon("src/assets/battleship.gif").getImage();
        this.setPreferredSize(new Dimension(widthSize, heightSize));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(battleShipImage, xPosition, yPosition, widthSize, heightSize, this);
    }
}
