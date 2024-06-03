import javax.swing.*;

public class StarShip {
    public static void main(String[] args) {
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
    }
}
