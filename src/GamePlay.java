import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class GamePlay extends JPanel {
    Snake snake = new Snake(this);

    public GamePlay() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                snake.keyPressed(e);
            }
        });
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    @Override
    public void paint(Graphics g) {
        try {
            // draw title image
            Graphics2D g2d = (Graphics2D) g;
            Image titleImg = ImageIO.read(new File("src/assets/title.png"));
            g.drawImage(titleImg, 25, 10, 835, 80, null);
            // draw background image
//            Image backImg = ImageIO.read(new File("src/assets/grass.jpg"));
//            g.drawImage(backImg, 25, 110, 835, 500, null);

            // draw border background
            g2d.setColor(Color.GREEN);
            g2d.drawRect(25, 110, 835, 500);

            // draw background
            g2d.setColor(Color.BLACK);
            g2d.fillRect(25, 110, 835, 500);
            // draw snake
            snake.paint(g2d);
            g.dispose();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
