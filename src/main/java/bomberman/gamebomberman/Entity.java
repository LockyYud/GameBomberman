package bomberman.gamebomberman;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

public abstract class Entity implements LoadImage {
    public static final int window_height = 600;
    public static final int window_width = 600;
    public static final int SIZE_OF_BOX = 40;
    protected int x;
    protected int y;
    public ImageView image;
    public Group move = new Group();

    Entity() {}

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
