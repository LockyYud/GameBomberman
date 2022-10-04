package bomberman.gamebomberman;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Entiny implements LoadImage {
    public static final int window_height = 600;
    public static final int window_width = 600;
    public static final int size_of_box = 40;
    protected int x;
    protected int y;

    public ImageView image;
    Entiny() {}

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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

    boolean Collide_with(Entiny obj) {
        if (this.x == obj.getX() || this.y == obj.getY()) return true;
        else return false;
    }
}
