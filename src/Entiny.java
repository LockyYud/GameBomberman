import javafx.scene.image.Image;

interface LoadImage {
    Image player_left = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_left.png");
    Image player_left_1 = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_left_1.png");
    Image player_left_2 = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_left_2.png");
    Image player_right = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_right.png");
    Image player_right_1 = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_right_1.png");
    Image player_right_2 = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_right_2.png");
    Image player_up = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_up.png");
    Image player_up_1 = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_up_1.png");
    Image player_up_2 = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_up_2.png");
    Image player_down = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_down.png");
    Image player_down_1 = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_down_1.png");
    Image player_down_2 = new Image("file:Bomberman\\GameBomberman\\data\\image\\player_down_2.png");
}

public abstract class Entiny implements LoadImage {
    protected int x;
    protected int y;
    protected boolean exist;

    Entiny() {
    }

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

    public boolean getExist() {
        return exist;
    }

    boolean Collide_with(Entiny obj) {
        if (this.x == obj.getX() || this.y == obj.getY())
            return true;
        else
            return false;
    }

    public void setDead() {
        exist = false;
    }

}
