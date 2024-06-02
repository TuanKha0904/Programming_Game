import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class BattleShip extends JPanel {
    private final GamePlay game;
    private final int heightSize = 100;
    private final int widthSize = 100;
    private int xPosition;
    private final int yPosition;
    private final Image battleShipImage;
    private int changePosition = 0;
    private int speed = 2;

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

    public void move() {
        if (xPosition + changePosition > 0 && xPosition + changePosition < game.WIDTH - widthSize)
            xPosition += changePosition;
    }

    public void keyReleased() {
        changePosition = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            changePosition = -speed;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            changePosition = speed;
    }
}
