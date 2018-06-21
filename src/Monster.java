public class Monster {
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

    public void setY(int moveY) {
        this.y = y + moveY;
    }

    public int getY() {
        return y;

    }

    public void moveMonster(int playerX, int playerY) {
        if (this.x > playerX) {
            setX(-1);
        } else {
            setX(+1);
        }
        if (this.y > playerY) {
            setY(-1);
        } else {
            setY(+1);
        }
    }
}
