import javax.swing.*;
import java.io.IOException;

public class StarShip {
    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame frame = new JFrame("BattleShip Game");
        GamePlay gamePlay = new GamePlay();
        final int WIDTH = 900;
        final int HEIGHT = 700;
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(gamePlay);
        frame.setVisible(true);
        while (true) {
            gamePlay.move();
            gamePlay.repaint();
            Thread.sleep(10);
        }
    }
}
