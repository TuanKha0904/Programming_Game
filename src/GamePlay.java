import javax.swing.*;
import java.awt.*;

public class GamePlay extends JPanel {
    private final int WIDTH = 900;
    private final int HEIGHT = 700;
    private final int xPosition = 0;
    private final int yPosition = 0;
    public GamePlay() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(xPosition, yPosition, WIDTH, HEIGHT);
    }
}
