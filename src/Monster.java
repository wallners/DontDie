import java.util.Random;

public class Monster {
    private int x;
    private int y;
    Random rand = new Random();
    float stupidityFactor;
    int smartMove = 1;


    public Monster(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int moveX) {
        this.x = x + moveX;
    }

    public void setY(int moveY) {
        this.y = y + moveY;
    }

    public int getY() {
        return y;

    }

    public void moveMonster(int playerX, int playerY) {

        stupidityFactor = rand.nextFloat();
        if (stupidityFactor < 0.9) {
            smartMove = 1;
        } else {
            smartMove = -1;
        }

        if (this.x > playerX) {
            setX(-1 * smartMove);
        } else {
            setX(+1 * smartMove);
        }
        if (this.y > playerY) {
            setY(-1 * smartMove);
        } else {
            setY(+1 * smartMove);
        }
    }
}
