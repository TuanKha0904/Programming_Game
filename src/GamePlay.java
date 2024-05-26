import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GamePlay extends JPanel {
    public GamePlay() {

    }

    public void paint(Graphics g) {
        try {
            // draw title image
            Image titleImg = ImageIO.read(new File("src/assets/title.png"));
            g.drawImage(titleImg, 25, 10, 835, 80, null);
            // draw background image
            Image backImg = ImageIO.read(new File("src/assets/grass.jpg"));
            g.drawImage(backImg, 25, 110, 835, 500, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
