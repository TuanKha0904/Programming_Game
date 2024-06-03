import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePlay extends JPanel implements ActionListener {
    private final int WIDTH = 900;
    private final int HEIGHT = 700;
    private final BattleShip battleShip;
    private final ArrayList<Rocket> rockets;

    public GamePlay() {
        battleShip = new BattleShip(this);
        rockets = new ArrayList<>();
        // Add key listener for game play
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                battleShip.keyReleased();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                battleShip.keyPressed(e);
            }
        });
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        // Set timer for game loop
        Timer gameTimer = new Timer(16, this); // 60 FPS
        gameTimer.start();
        // Set timer for rocket loop
        Timer rocketTimer = new Timer(500, e -> addRocket());
        rocketTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int xPosition = 0;
        int yPosition = 0;
        g.fillRect(xPosition, yPosition, WIDTH, HEIGHT);
        battleShip.paintComponent(g);
        for (Rocket rocket : rockets) {
            rocket.paintComponent(g);
        }
    }

    public void move() {
        battleShip.move();
        for (Rocket rocket : rockets) {
            rocket.move();
        }
    }

    public void addRocket() {
        rockets.add(new Rocket(battleShip));
    }

    public void updateRocket() {
        rockets.removeIf(Rocket::checkOutScreen);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        updateRocket();
        repaint();
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}
