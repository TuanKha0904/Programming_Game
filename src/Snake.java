import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Snake {
    private final int SIZE;
    Block head;
    ArrayList<Block> body;
    Image headLeft, headRight, headUp, headDown, tail;
    GamePlay game;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

    public Snake(int size, int x, int y, GamePlay game) {
        this.game = game;
        this.SIZE = size;
        head = new Block(x, y);
        body = new ArrayList<>();
        body.add(new Block(x - 1, y));
        body.add(new Block(x - 2, y));
        try {
            loadImage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadImage() throws IOException {
        headLeft = ImageIO.read(new File("src/assets/headLeft.png"));
        headRight = ImageIO.read(new File("src/assets/headRight.png"));
        headUp = ImageIO.read(new File("src/assets/headUp.png"));
        headDown = ImageIO.read(new File("src/assets/headDown.png"));
        tail = ImageIO.read(new File("src/assets/tail.png"));
    }

    public void paint(Graphics2D g) throws IOException {
        if (left) {
            g.drawImage(headLeft, head.x * SIZE, head.y * SIZE, SIZE, SIZE, null);
        } else if (right) {
            g.drawImage(headRight, head.x * SIZE, head.y * SIZE, SIZE, SIZE, null);
        } else if (up) {
            g.drawImage(headUp, head.x * SIZE, head.y * SIZE, SIZE, SIZE, null);
        } else if (down) {
            g.drawImage(headDown, head.x * SIZE, head.y * SIZE, SIZE, SIZE, null);
        }
        for (Block block : body) {
            g.drawImage(tail, block.x * SIZE, block.y * SIZE, SIZE, SIZE, null);
        }
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
        // Move the body first
        for (int i = body.size() - 1; i > 0; i--) {
            Block current = body.get(i);
            Block prev = body.get(i - 1);
            current.x = prev.x;
            current.y = prev.y;
        }

        // Move the first body part to the head's previous position
        if (!body.isEmpty()) {
            Block first = body.getFirst();
            first.x = head.x;
            first.y = head.y;
        }

        // Move the head
        if (left) {
            head.x -= 1;
        } else if (right) {
            head.x += 1;
        } else if (up) {
            head.y -= 1;
        } else if (down) {
            head.y += 1;
        }
    }

    public void checkCollision(int areaXPosition, int areaWidth, int areaYPosition, int areaHeight) {
        int maxX = (areaXPosition + areaWidth) / SIZE;
        int maxY = (areaYPosition + areaHeight) / SIZE;

        // Check wall collisions and teleport to the opposite side
        if (head.x < areaXPosition / SIZE) {
            head.x = maxX - 1;
        } else if (head.x >= maxX) {
            head.x = areaXPosition / SIZE;
        } else if (head.y < areaYPosition / SIZE) {
            head.y = maxY - 1;
        } else if (head.y >= maxY) {
            head.y = areaYPosition / SIZE;
        }

        // Check self-collision
        for (Block block : body) {
            if (block.x == head.x && block.y == head.y) {
                game.gameOver();
            }
        }

        // Check fruit collision
        if (head.x == game.fruit.fruit.x && head.y == game.fruit.fruit.y) {
            body.add(new Block(body.getLast().x, body.getLast().y));
            game.fruit.setFruit(game.gameWidth / SIZE, game.areaHeight / SIZE);
        }
    }
}
