package bomberman.gamebomberman;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class Entity implements LoadImage {
    public static final int SIZE_OF_BOX = 40;
    protected final int time_move = 500;
    protected int x;
    protected int y;
    public ImageView image;
    public Group move = new Group();
    protected TranslateTransition tran_left = new TranslateTransition();
    protected TranslateTransition tran_right = new TranslateTransition();
    protected TranslateTransition tran_up = new TranslateTransition();
    protected TranslateTransition tran_down = new TranslateTransition();
    Entity() {
        //tran_left
        tran_left.setNode(move);
        tran_left.setDuration(Duration.millis(time_move + 25));
        tran_left.setCycleCount(1);
        tran_left.setAutoReverse(false);
        tran_left.setByY(0);
        tran_left.setByX(-SIZE_OF_BOX);
        //tran_right
        tran_right.setNode(move);
        tran_right.setDuration(Duration.millis(time_move + 25));
        tran_right.setCycleCount(1);
        tran_right.setAutoReverse(false);
        tran_right.setByY(0);
        tran_right.setByX(SIZE_OF_BOX);
        //tran_up
        tran_up.setNode(move);
        tran_up.setDuration(Duration.millis(time_move + 25));
        tran_up.setCycleCount(1);
        tran_up.setAutoReverse(false);
        tran_up.setByY(-SIZE_OF_BOX);
        tran_up.setByX(0);
        //tran_down
        tran_down.setNode(move);
        tran_down.setDuration(Duration.millis(time_move + 25));
        tran_down.setCycleCount(1);
        tran_down.setAutoReverse(false);
        tran_down.setByY(SIZE_OF_BOX);
        tran_down.setByX(0);
    }

    Entity(int x, int y) {
        this.x = x * SIZE_OF_BOX;
        this.y = y * SIZE_OF_BOX;
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

    boolean Collide_with(Entity obj) {
        if (this.x == obj.getX() || this.y == obj.getY()) return true;
        else return false;
    }
}
