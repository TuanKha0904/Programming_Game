import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePlay extends JPanel {
    public final int WIDTH = 900;
    public final int HEIGHT = 700;
    public final int xPosition = 0;
    public final int yPosition = 0;
    BattleShip battleShip = new BattleShip(this);
    Rocket rocket = new Rocket(battleShip);

    public GamePlay() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                battleShip.keyReleased();
            }
            @Override
            public void keyPressed(KeyEvent e) {
                battleShip.keyPressed(e);
            }
        });
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(xPosition, yPosition, WIDTH, HEIGHT);
        battleShip.paintComponent(g);
        rocket.paintComponent(g);
    }

    public void move() {
        battleShip.move();
        rocket.move();
    }
}
