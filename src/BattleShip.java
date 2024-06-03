import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class BattleShip extends JPanel {
    private final GamePlay game;
    public final int shipSize = 50;
    public int xPosition;
    public final int yPosition;
    private final Image battleShipImage;
    private int changePosition = 0;
    private int speed = 2;

    public BattleShip(GamePlay game) {
        this.game = game;
        this.xPosition = (game.WIDTH - shipSize) / 2;
        this.yPosition = game.HEIGHT - shipSize * 2;
        System.out.println(xPosition);
        this.battleShipImage = new ImageIcon("src/assets/battleship.gif").getImage();
        this.setPreferredSize(new Dimension(shipSize, shipSize));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(battleShipImage, xPosition, yPosition, shipSize, shipSize, this);
        g.setColor(Color.RED);
    }

    public void move() {
        if (xPosition + changePosition > 0 && xPosition + changePosition < game.WIDTH - shipSize)
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
