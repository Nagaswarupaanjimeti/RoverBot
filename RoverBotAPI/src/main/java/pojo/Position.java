package pojo;

public class Position {
    private String Direction;
    private int X;
    private int Y;

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public Position(String direction, int x, int y) {
        Direction = direction;
        X = x;
        Y = y;
    }
}
