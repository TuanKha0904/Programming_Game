import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class GamePlay extends JPanel implements ActionListener {
    private final int WIDTH = 900;
    private final int HEIGHT = 700;
    private final BattleShip battleShip;
    private final ArrayList<Rocket> rockets;
    private final ArrayList<EnemyShip> enemyShips;
    private final ArrayList<EnemyBullet> enemyBullets;
    private int score = 0;

    public GamePlay() {
        battleShip = new BattleShip(this);
        enemyShips = new ArrayList<>();
        rockets = new ArrayList<>();
        enemyBullets = new ArrayList<>();
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
        Timer rocketTimer = new Timer(300, e -> addRocket());
        rocketTimer.start();
        // Set timer for enemy ship loop
        Timer enemyShipTimer = new Timer(3000, e -> addEnemyShip());
        enemyShipTimer.start();
        // Set timer for enemy bullet loop
        Timer enemyBulletTimer = new Timer(3000, e -> addEnemyBullet());
        enemyBulletTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int xPosition = 0;
        int yPosition = 0;
        g.fillRect(xPosition, yPosition, WIDTH, HEIGHT);
        battleShip.paintComponent(g);
        // Paint rocket
        for (Rocket rocket : rockets) {
            rocket.paintComponent(g);
        }
        // Paint enemy ship
        for (EnemyShip enemyShip : enemyShips) {
            enemyShip.paintComponent(g);
        }
        // Paint enemy bullets
        for (EnemyBullet enemyBullet : enemyBullets) {
            enemyBullet.paintComponent(g);
        }
        // Paint string score
        int xScore = 10;
        int yScore = 30;
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, xScore, yScore);
    }

    public void move() {
        battleShip.move();
        for (Rocket rocket : rockets) {
            rocket.move();
        }
        for (EnemyShip enemyShip : enemyShips) {
            enemyShip.move();
        }
        for (EnemyBullet enemyBullet : enemyBullets) {
            enemyBullet.move();
        }
    }

    private void addRocket() {
        rockets.add(new Rocket(battleShip));
    }

    private void addEnemyShip() {
        enemyShips.add(new EnemyShip(this));
    }

    private void addEnemyBullet() {
        if (!enemyShips.isEmpty()) {
            Random random = new Random();
            for (EnemyShip enemyShip : enemyShips) {
                // Add enemy bullet if random boolean is true (50%)
                if (random.nextBoolean()) {
                    enemyBullets.add(new EnemyBullet(this, enemyShip));
                }
            }
        }
    }

    private void updateRocket() {
        rockets.removeIf(Rocket::checkOutScreen);
        enemyShips.removeIf(EnemyShip::checkOutScreen);
        enemyBullets.removeIf(EnemyBullet::checkOutScreen);
    }

    private void rocketAndEnemyShipCollision() {
        ArrayList<Rocket> rocketsToRemove = new ArrayList<>();
        ArrayList<EnemyShip> enemyShipsToRemove = new ArrayList<>();
        for (Rocket rocket : rockets) {
            for (EnemyShip enemyShip : enemyShips) {
                if (rocket.getBounds().intersects(enemyShip.getBounds())) {
                    rocketsToRemove.add(rocket);
                    enemyShip.increaseCollision();
                    if (enemyShip.breakShip()) {
                        increaseScore();
                        enemyShipsToRemove.add(enemyShip);
                    }
                }
            }
        }
        rockets.removeAll(rocketsToRemove);
        enemyShips.removeAll(enemyShipsToRemove);
    }

    private void bulletAndBattleShipCollision() {
        ArrayList<EnemyBullet> enemyBulletsToRemove = new ArrayList<>();
        for(EnemyBullet enemyBullet : enemyBullets) {
            if (enemyBullet.getBounds().intersects(battleShip.getBounds())) {
                enemyBulletsToRemove.add(enemyBullet);
            }
        }
        enemyBullets.removeAll(enemyBulletsToRemove);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        updateRocket();
        rocketAndEnemyShipCollision();
        bulletAndBattleShipCollision();
        repaint();
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    private void increaseScore() {
        score++;
    }
}
