public class Player {
    private int x;
    private int y;

    public Player(int x, int y) {
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
}
