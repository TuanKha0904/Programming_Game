import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Snake implements ActionListener {
    Block head;
    ArrayList<Block> body;
    private final int SIZE = 25;
    Image headLeft, headRight, headUp, headDown, tail;
    GamePlay game;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

//    private int snakeLength = 3;

    public Snake(int x, int y, GamePlay game) {
        int delay = 100;
        Timer timer = new Timer(delay, this);
        timer.start();
        this.game = game;
        head = new Block(x, y);
        body = new ArrayList<>();
        body.add(new Block(x - 1, y));
        body.add(new Block(x - 2, y));
        body.add(new Block(x - 3, y));

        try {
            loadImage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadImage() throws IOException {
        headLeft = ImageIO.read(new File("src/assets/headLeft.png"));
        headRight = ImageIO.read(new File("src/assets/headRight.png"));
        headUp = ImageIO.read(new File("src/assets/headUP.png"));
        headDown = ImageIO.read(new File("src/assets/headDown.png"));
        tail = ImageIO.read(new File("src/assets/tail.png"));
    }

    public void paint(Graphics2D g) throws IOException {
        if (left)
            g.drawImage(headLeft, head.x * SIZE, head.y * SIZE, SIZE, SIZE, null);
        if (right)
            g.drawImage(headRight, head.x * SIZE, head.y * SIZE, SIZE, SIZE, null);
        if (up)
            g.drawImage(headUp, head.x * SIZE, head.y * SIZE, SIZE, SIZE, null);
        if (down)
            g.drawImage(headDown, head.x * SIZE, head.y * SIZE, SIZE, SIZE, null);
        for(Block block: body)
            g.drawImage(tail, block.x * SIZE, block.y * SIZE, SIZE, SIZE, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !left) {
            right = true;
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && !right) {
            left = true;
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && !down) {
            right = false;
            left = false;
            up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && !up) {
            right = false;
            left = false;
            down = true;
        }
    }

    public void move() {
        for (int i = body.size() - 1; i >= 0; i--) {
            Block current = body.get(i);

            if (i == 0) {
                current.x = head.x;
                current.y = head.y;
            } else {
                Block prev = body.get(i - 1);
                current.x = prev.x;
                current.y = prev.y;
            }
        if (left) {
            head.x -= 1;
        }

        if (right) {
            head.x += 1;
        }
        if (up) {
            head.y -= 1;
        }

        if (down) {
            head.y += 1;
        }

        }
    }
}
