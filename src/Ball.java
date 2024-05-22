public class Ball {
    // asset image
    private int x;
    private int y;
    private int width;
    private int height;
    private int xVelocity;
    private int yVelocity;
    private int xDir;
    private int yDir;

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        width = 4;
        height = 4;
        xVelocity = 1;
        yVelocity = 1;
        xDir = 1;
        yDir = 1;
    }



}
