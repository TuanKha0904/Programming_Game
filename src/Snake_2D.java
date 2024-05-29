import javax.swing.*;
import java.awt.*;

public class Snake_2D {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        GamePlay gamePlay = new GamePlay();
        frame.setBounds(10, 10, 900, 700);
        frame.setBackground(Color.DARK_GRAY);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(gamePlay);
        while (true) {
            gamePlay.move();
            gamePlay.repaint();
            Thread.sleep(200);
        }
    }
}
