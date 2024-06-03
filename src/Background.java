import javax.swing.*;
import java.awt.*;

public class Background {
    private final ImageIcon background = new ImageIcon("src/assets/back.png");
    private final GamePlay game;

    public Background(GamePlay game) {
        this.game = game;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(background.getImage(), 0, 0, game.getWidth(), game.getHeight(), null);
    }
}
