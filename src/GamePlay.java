import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class GamePlay extends JPanel implements ActionListener {
    private final int areaXPosition = 25;
    private final int areaYPosition = 100;
    private final int gameWidth = 825;
    private final int areaHeight = 500;
    Timer timer;
    Snake snake = new Snake(2, 4,this);
    AreaPlay areaPlay = new AreaPlay(gameWidth, areaHeight, areaXPosition, areaYPosition);

    public GamePlay() {
        initGame();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.keyPressed(e);
            }
        });
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private void initGame() {
        snake = new Snake(2, 4,this);
        areaPlay = new AreaPlay(gameWidth, areaHeight, areaXPosition, areaYPosition);
        timer = new Timer(100, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        try {
            super.paint(g);
            // draw title image
            Graphics2D g2d = (Graphics2D) g;
            Image titleImg = ImageIO.read(new File("src/assets/title.png"));
            int titleXPosition = 25;
            int titleYPosition = 10;
            int titleHeight = 80;
            g.drawImage(titleImg, titleXPosition, titleYPosition, gameWidth, titleHeight, null);

            // draw area
            areaPlay.paint(g2d);
            // draw snake
            snake.paint(g2d);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
        checkCollision();
    }

    private void checkCollision() {
        if (snake.checkCollision(areaXPosition, gameWidth, areaYPosition, areaHeight)) {
            gameOver();
        }
    }

    public void gameOver() {
        timer.stop();
        int option = JOptionPane.showOptionDialog(this,
                "Game over.",
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Exit", "Restart"},
                "Exit"
        );
        if (option == JOptionPane.NO_OPTION) {
            initGame();
        } else System.exit(ABORT);
    }
}
