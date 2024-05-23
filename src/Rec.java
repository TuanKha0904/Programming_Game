import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rec {
    private final List<Brick> bricks;
    private static final int WIDTH = 40;
    private static final int HEIGHT = 20;
    private static final Random random = new Random();
    private static final int NUM_BRICKS = random.nextInt(10, 30);

    public Rec() throws IOException {
        this.bricks = new ArrayList<>();
        initializeBricks();
    }

    public void initializeBricks() throws IOException {
        for (int i = 0; i < NUM_BRICKS; i++) {
            int x = random.nextInt(0, 700 - WIDTH);
            int y = random.nextInt(20, 300);
            bricks.add(new Brick(x, y, WIDTH, HEIGHT));
        }
    }

    public void paint(Graphics2D g) throws IOException {
        for (Brick brick : bricks) {
                brick.paint(g);
        }
    }

    public List<Brick> getBricks() {
        return bricks;
    }
}
