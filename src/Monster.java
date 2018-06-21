import java.util.Random;

public class Monster {
    Random rand = new Random();
    float stupidityFactor;
    int smartMove = 1;
    int newX;
    int newY;
    private int x;
    private int y;

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

    public int getY() {
        return y;

    }

    public void setY(int moveY) {
        this.y = y + moveY;
    }

    public void moveMonster(int playerX, int playerY, Monster[] monsters) {

        stupidityFactor = rand.nextFloat();

        if (stupidityFactor < 0.9) {
            smartMove = 1;
        } else {
            smartMove = -1;
        }
        if (this.x > playerX) {
            newX = x - 1 * smartMove;
        } else {
            newX = x + 1;
        }
        if (this.y > playerY) {
            newY = y - 1;
        } else {
            newY = y + 1;
        }
        if (!isMonsterClose(monsters)) {
            setX((newX-x)*smartMove);
            setY((newY-y)*smartMove);
        }
    }

    public boolean isMonsterClose(Monster[] monsters) {
        for (Monster monster : monsters) {
            if (newX - monster.getX() == 0 && newY - monster.getY() == 0 && monster != this) {
                return true;
            }
        }
        return false;
    }
}
