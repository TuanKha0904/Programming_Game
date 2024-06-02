import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Fruit {
    private final int SIZE;
    Block fruit = new Block(0, 0);
    Image fruitImage;
    GamePlay gamePlay;
    Random random = new Random();

    public Fruit(int size,GamePlay gamePlay) {
        this.gamePlay = gamePlay;
        this.SIZE = size;
        try {
            loadImage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setFruit(gamePlay.gameWidth / SIZE, gamePlay.areaHeight / SIZE); // Pass the number of columns and rows as parameters
    }

    private void loadImage() throws IOException {
        fruitImage = ImageIO.read(new File("src/assets/fruit.png"));
    }

    public void paint(Graphics2D g) {
        g.drawImage(fruitImage, fruit.x * SIZE, fruit.y * SIZE, SIZE, SIZE, null); // Multiply by SIZE to convert from grid coordinates to pixel coordinates
    }

    public void setFruit(int columns, int rows) {
        fruit.x = random.nextInt(1, columns);
        fruit.y = random.nextInt(4, rows);
    }
}
