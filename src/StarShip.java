import javax.swing.*;
import java.awt.*;

public class StarShip {
    public static void Main(String[] args) {
        JFrame frame = new JFrame();
        final int WIDTH = 900;
        final int HEIGHT = 700;
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
