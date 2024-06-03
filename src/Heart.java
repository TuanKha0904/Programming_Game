import javax.swing.*;
import java.awt.*;

public class Heart {
    private final ImageIcon heartImage = new ImageIcon("src/assets/heart.png");
    private final int xPosition;
    private final int yPosition;

    public Heart(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    public void paintComponent(Graphics g) {
        int heartSize = 20;
        g.drawImage(heartImage.getImage(), xPosition, yPosition, heartSize, heartSize, null);
    }
}
