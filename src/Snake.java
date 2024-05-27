import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Snake implements ActionListener {
    private final GamePlay game;
    private int[] snakeXLength = new int[700];
    private int[] snakeYLength = new int[700];

    private int WIDTH = 25;
    private int HEIGHT = 25;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

    private Timer timer;
    private int delay = 100;

    private int snakeLength = 3;
    private int moves = 0;

    public Snake(GamePlay game) {
        this.game = game;
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics2D g) throws IOException {
        if (moves == 0) {
            snakeXLength[2] = 25;
            snakeXLength[1] = 50;
            snakeXLength[0] = 75;

            snakeYLength[2] = 110;
            snakeYLength[1] = 110;
            snakeYLength[0] = 110;
        }
        Image headLeft = ImageIO.read(new File("src/assets/headLeft.png"));
        Image headRight = ImageIO.read(new File("src/assets/headRight.png"));
        Image headUp = ImageIO.read(new File("src/assets/headUP.png"));
        Image headDown = ImageIO.read(new File("src/assets/headDown.png"));
        Image tail = ImageIO.read(new File("src/assets/tail.png"));
        g.drawImage(headLeft, snakeXLength[0], snakeYLength[0], WIDTH, HEIGHT, null);
        for (int length = 0; length < snakeLength; length++) {
            if(length == 0 && left)
                g.drawImage(headLeft, snakeXLength[length], snakeYLength[length], WIDTH, HEIGHT, null);
            if(length == 0 && right)
                g.drawImage(headRight, snakeXLength[length], snakeYLength[length], WIDTH, HEIGHT, null);
            if(length == 0 && up)
                g.drawImage(headUp, snakeXLength[length], snakeYLength[length], WIDTH, HEIGHT, null);
            if(length == 0 && down)
                g.drawImage(headDown, snakeXLength[length], snakeYLength[length], WIDTH, HEIGHT, null);
            if (length != 0)
                g.drawImage(tail, snakeXLength[length], snakeYLength[length], WIDTH, HEIGHT, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
