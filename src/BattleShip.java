import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class BattleShip extends JPanel {
    private final GamePlay game;
    private final int shipSize = 50;
    private int xPosition;
    private final int yPosition;
    private final Image battleShipImage;
    private int changePosition = 0;

    public BattleShip(GamePlay game) {
        this.game = game;
        this.xPosition = (game.getWidth() - shipSize) / 2;
        this.yPosition = game.getHeight() - shipSize * 2;
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
        if (xPosition + changePosition > 0 && xPosition + changePosition < game.getWidth() - shipSize)
            xPosition += changePosition;
    }

    public void keyReleased() {
        changePosition = 0;
    }

    public void keyPressed(KeyEvent e) {
        int speed = 2;
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            changePosition = -speed;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            changePosition = speed;
    }

    public int getxPosition() {
    	return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getShipSize() {
    	return shipSize;
    }
}
