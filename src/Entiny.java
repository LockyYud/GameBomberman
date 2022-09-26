import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

interface LoadImage {
    //player image
    Image player_left = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_left.png");
    Image player_left_1 = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_left_1.png");
    Image player_left_2 = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_left_2.png");
    Image player_right = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_right.png");
    Image player_right_1 = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_right_1.png");
    Image player_right_2 = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_right_2.png");
    Image player_up = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_up.png");
    Image player_up_1 = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_up_1.png");
    Image player_up_2 = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_up_2.png");
    Image player_down = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_down.png");
    Image player_down_1 = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_down_1.png");
    Image player_down_2 = new Image("File:\\Bomberman\\GameBomberman\\data\\image\\player_down_2.png");
    Image player_dead = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\player_dead1.png");
    Image player_dead_1 = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\player_dead2.png");
    Image player_dead_2 = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\player_dead3.png");

    Image balloom_right = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\balloom_right1.png");
    Image balloom_right_1 = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\balloom_right2.png");
    Image balloom_right_2 = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\balloom_right3.png");
    Image balloom_left = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\balloom_left1.png");
    Image balloom_left_1 = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\balloom_left2.png");
    Image balloom_left_2 = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\balloom_left3.png");

    Image brick = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\brick.png");
    Image grass = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\grass.png");
    Image wall = new Image("File:\\Bomberman\\GameBomberman\\res\\sprites\\wall.png");
}

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
