import javax.swing.*;
import java.awt.*;

public class Snake_2D {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GamePlay gamePlay = new GamePlay();
        final int WIDTH = 900;
        final int HEIGHT = 700;
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.DARK_GRAY);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(gamePlay);
    }
}
