import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Game extends JPanel {
    int x, y = 0;
    private void moveBall (){
        x += 1;
        y += 1;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.pink);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 30, 30);
    }
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setBackground(Color.pink);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while (true) {
            game.moveBall();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
