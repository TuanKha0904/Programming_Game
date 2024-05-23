import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

public class BrickBreaker extends JPanel {
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    Rec rec = new Rec(this);
    final Random random = new Random();
    public BrickBreaker() throws IOException {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }
        });
        setFocusable(true);
        setBackground(Color.BLACK);
    }

    private void move() {
        ball.move();
        racquet.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        try {
            ball.paint(g2d);
            racquet.paint(g2d);
            rec.paint(g2d);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.ERROR_MESSAGE);
        System.exit(ABORT);
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame obj = new JFrame();
        BrickBreaker game = new BrickBreaker();
        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Brick Breaker");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(game);
        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }

    public Rec getRec() {
        return rec;
    }
}
