import java.awt.*;

public class AreaPlay {
    private final int xPosition;
    private final int yPosition ;
    private final int width ;
    private final int height ;

    public AreaPlay(int width, int height, int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
        this.width = width;
        this.height = height;

    }

    public void paint(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.drawRect(xPosition, yPosition, width, height);
        g.setColor(Color.BLACK);
        g.fillRect(xPosition, yPosition, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
