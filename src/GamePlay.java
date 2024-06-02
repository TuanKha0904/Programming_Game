import javax.swing.*;
import java.awt.*;

public class GamePlay extends JPanel {
    public final int WIDTH = 900;
    public final int HEIGHT = 700;
    public final int xPosition = 0;
    public final int yPosition = 0;
    BattleShip battleShip = new BattleShip(this);

    public GamePlay() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(xPosition, yPosition, WIDTH, HEIGHT);
        battleShip.paintComponent(g);
    }
}
