import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this, 0, 0, 330);
    Racquet racquet2 = new Racquet(this, 0, 0, 30);
    int speed = 1;

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
                    racquet.keyReleased(e);
                if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D)
                    racquet2.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    racquet2.keyPressed(RacquetDirection.RIGHT);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    racquet2.keyPressed(RacquetDirection.LEFT);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    racquet.keyPressed(RacquetDirection.RIGHT);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    racquet.keyPressed(RacquetDirection.LEFT);
                }
                racquet.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    private void move() {
        ball.move();
        racquet.move();
        racquet2.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet2.paint(g2d);
        racquet.paint(g2d);
    }
    public void gameOver() {
        AudioGame.stopAll();
        AudioGame.play("GAMEOVER");
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.ERROR_MESSAGE);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AudioGame.play("BACK");

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
