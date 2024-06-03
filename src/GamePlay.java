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
    private BattleShip battleShip;
    private ArrayList<Rocket> rockets;
    private ArrayList<EnemyShip> enemyShips;
    private ArrayList<EnemyBullet> enemyBullets;
    private ArrayList<Heart> hearts;
    private int score = 0;

    public GamePlay() {
        initGame();
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
        // Paint heart
        for (Heart heart : hearts) {
            heart.paintComponent(g);
        }
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

    private void addHeart() {
        if (hearts.size() < 3) {
            hearts.add(new Heart(WIDTH - (40 * (hearts.size() + 1)), 15));
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
        ArrayList<Heart> heartToRemove = new ArrayList<>();
        for (EnemyBullet enemyBullet : enemyBullets) {
            if (enemyBullet.getBounds().intersects(battleShip.getBounds())) {
                heartToRemove.add(hearts.getLast());
                enemyBulletsToRemove.add(enemyBullet);
            }
        }
        enemyBullets.removeAll(enemyBulletsToRemove);
        hearts.removeAll(heartToRemove);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        updateRocket();
        rocketAndEnemyShipCollision();
        bulletAndBattleShipCollision();
        gameOver();
        repaint();
    }

    private void gameOver() {
        if (hearts.isEmpty()) {
            int option = JOptionPane.showOptionDialog(this,
                    "Game over. Your score: " + score,
                    "Game Over",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Exit", "Restart"},
                    "Exit"
            );
            if (option == JOptionPane.NO_OPTION) {
                initGame();
            } else System.exit(ABORT);
        }
    }

    private void initGame() {
        score = 0;
        battleShip = new BattleShip(this);
        rockets = new ArrayList<>();
        enemyShips = new ArrayList<>();
        enemyBullets = new ArrayList<>();
        hearts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            hearts.add(new Heart(WIDTH - (40 * (i + 1)), 15));
        }
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
