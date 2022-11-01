package bomberman.gamebomberman;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Entity implements LoadImageWithoutBackground {
    public static final int SIZE_OF_BOX = 32;
    protected int time_move = 1000;
    protected int x;
    protected int y;
    public ImageView image;
    public Group action = new Group();
    public boolean dead = false;
    public Group getAction() {
        return action;
    }

    protected TranslateTransition tran_left = new TranslateTransition();
    protected TranslateTransition tran_right = new TranslateTransition();
    protected TranslateTransition tran_up = new TranslateTransition();
    protected TranslateTransition tran_down = new TranslateTransition();
    Entity() {
        tran_left.setNode(action);
        tran_left.setDuration(Duration.millis(time_move));
        tran_left.setCycleCount(1);
        tran_left.setAutoReverse(false);
        tran_left.setByY(0);
        tran_left.setByX(-SIZE_OF_BOX);
        //tran_right
        tran_right.setNode(action);
        tran_right.setDuration(Duration.millis(time_move));
        tran_right.setCycleCount(1);
        tran_right.setAutoReverse(false);
        tran_right.setByY(0);
        tran_right.setByX(SIZE_OF_BOX);
        //tran_up
        tran_up.setNode(action);
        tran_up.setDuration(Duration.millis(time_move));
        tran_up.setCycleCount(1);
        tran_up.setAutoReverse(false);
        tran_up.setByY(-SIZE_OF_BOX);
        tran_up.setByX(0);
        //tran_down
        tran_down.setNode(action);
        tran_down.setDuration(Duration.millis(time_move));
        tran_down.setCycleCount(1);
        tran_down.setAutoReverse(false);
        tran_down.setByY(SIZE_OF_BOX);
        tran_down.setByX(0);
    }
    Entity (int x, int y) {
        this.x = x;
        this.y = y;
        //tran_left
        tran_left.setNode(action);
        tran_left.setDuration(Duration.millis(time_move));
        tran_left.setCycleCount(1);
        tran_left.setAutoReverse(false);
        tran_left.setByY(0);
        tran_left.setByX(-SIZE_OF_BOX);
        //tran_right
        tran_right.setNode(action);
        tran_right.setDuration(Duration.millis(time_move));
        tran_right.setCycleCount(1);
        tran_right.setAutoReverse(false);
        tran_right.setByY(0);
        tran_right.setByX(SIZE_OF_BOX);
        //tran_up
        tran_up.setNode(action);
        tran_up.setDuration(Duration.millis(time_move));
        tran_up.setCycleCount(1);
        tran_up.setAutoReverse(false);
        tran_up.setByY(-SIZE_OF_BOX);
        tran_up.setByX(0);
        //tran_down
        tran_down.setNode(action);
        tran_down.setDuration(Duration.millis(time_move));
        tran_down.setCycleCount(1);
        tran_down.setAutoReverse(false);
        tran_down.setByY(SIZE_OF_BOX);
        tran_down.setByX(0);

        //set position
        action.setTranslateX(x * SIZE_OF_BOX);
        action.setTranslateY(y * SIZE_OF_BOX);
    }

    public void setX(int x) {
        this.x = x * SIZE_OF_BOX;
    }

    public void setY(int y) {
        this.y = y * SIZE_OF_BOX;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ImageView getImage() {
        return image;
    }

    protected boolean Collide_with(Entity obj) {
        if(Math.abs(obj.getAction().getTranslateX() - action.getTranslateX()) <= 5
                && Math.abs(obj.getAction().getTranslateY() - action.getTranslateY()) <= 5)
            return true;
        return false;
    }
    public boolean Collide_with_bomb(double bombX, double bombY) {
        if(bombX >= action.getTranslateX() && bombX < action.getTranslateX() + SIZE_OF_BOX
                && bombY >= action.getTranslateY() && bombY < action.getTranslateY() + SIZE_OF_BOX ) {
            return true;
        }
        return false;
    }
    protected AnimationTimer checkEndGame;
}
