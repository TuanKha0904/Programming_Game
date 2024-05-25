import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class BrickBreaker extends JPanel {
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    Rec rec = new Rec();
    private int score = 0;

    public BrickBreaker() throws IOException {
        initGame();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased();
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

    public void increaseScore() {
        score++;
    }
    public void increaseSpeed() {
        ball.increaseSpeed();
        racquet.increaseSpeed();
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
        g2d.setColor(Color.YELLOW);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Score: " + score, 10, 20);
    }

    public void gameOver() {
        GameAudio.stopAll();
        GameAudio.play("GAMEOVER");
        int option = JOptionPane.showOptionDialog(this,
                "Game over. Your score: " + score,
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Exit", "Restart"},
                "Exit"
        );
        if (option == JOptionPane.NO_OPTION) {
            try {
                initGame();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else System.exit(ABORT);
    }

    private void initGame() throws IOException {
        ball = new Ball(this);
        racquet = new Racquet(this);
        rec = new Rec();
        score = 0;
        GameAudio.stopAll();
        GameAudio.play("START");
        GameAudio.playLoop("BACK");
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
        GameAudio.play("START");
        GameAudio.play("BACK");
        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
