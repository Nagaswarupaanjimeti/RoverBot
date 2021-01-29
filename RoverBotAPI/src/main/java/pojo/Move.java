package pojo;

public class Move {
    private String order;
    private int leftRotation;
    private int rightRotation;
    private int moveForward;
    private int moveBackward;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getLeftRotation() {
        return leftRotation;
    }

    public void setLeftRotation(int leftRotation) {
        this.leftRotation = leftRotation;
    }

    public int getRightRotation() {
        return rightRotation;
    }

    public void setRightRotation(int rightRotation) {
        this.rightRotation = rightRotation;
    }

    public int getMoveForward() {
        return moveForward;
    }

    public void setMoveForward(int moveForward) {
        this.moveForward = moveForward;
    }

    public int getMoveBackward() {
        return moveBackward;
    }

    public void setMoveBackward(int moveBackward) {
        this.moveBackward = moveBackward;
    }

    public Move(String order, int leftRotation, int rightRotation, int moveForward, int moveBackward) {
        this.order = order;
        this.leftRotation = leftRotation;
        this.rightRotation = rightRotation;
        this.moveForward = moveForward;
        this.moveBackward = moveBackward;
    }
}
