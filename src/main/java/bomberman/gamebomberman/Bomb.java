package bomberman.gamebomberman;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicBoolean;

public class Bomb extends Entity {
    public static int TimeBomb_Explore = 2600;
    private int length_of_fire;
    private ImageView[] bombItem = new ImageView[3];
    private ImageView[] bombItemEx = new ImageView[3];
    private ImageView[] bombItemEx_right = new ImageView[3];
    private ImageView[] bombItemEx_left = new ImageView[3];
    private ImageView[] bombItemEx_up = new ImageView[3];
    private ImageView[] bombItemEx_down = new ImageView[3];
    private ImageView[] bombItemEx_vertical_up = new ImageView[3];
    private ImageView[] bombItemEx_vertical_down = new ImageView[3];
    private ImageView[] bombItemEx_horizontal_left = new ImageView[3];
    private ImageView[] bombItemEx_horizontal_right = new ImageView[3];
    private Timeline timeline_bomb = new Timeline();
    private Brick[] brick_will_break = new Brick[4];
    private StackPane bomb_stack = new StackPane();
    int horizon;
    int vertical;

    private void construct() {
        bombItem[0] = new ImageView(bomb);
        bombItem[1] = new ImageView(bomb_1);
        bombItem[2] = new ImageView(bomb_2);
        bombItemEx[0] = new ImageView(bomb_exploded);
        bombItemEx[1] = new ImageView(bomb_exploded1);
        bombItemEx[2] = new ImageView(bomb_exploded2);
        bombItemEx_right[0] = new ImageView(explosion_horizontal_right_last);
        bombItemEx_right[1] = new ImageView(explosion_horizontal_right_last1);
        bombItemEx_right[2] = new ImageView(explosion_horizontal_right_last2);
        bombItemEx_left[0] = new ImageView(explosion_horizontal_left_last);
        bombItemEx_left[1] = new ImageView(explosion_horizontal_left_last1);
        bombItemEx_left[2] = new ImageView(explosion_horizontal_left_last2);
        bombItemEx_up[0] = new ImageView(explosion_vertical_top_last);
        bombItemEx_up[1] = new ImageView(explosion_vertical_top_last1);
        bombItemEx_up[2] = new ImageView(explosion_vertical_top_last2);
        bombItemEx_down[0] = new ImageView(explosion_vertical_down_last);
        bombItemEx_down[1] = new ImageView(explosion_vertical_down_last1);
        bombItemEx_down[2] = new ImageView(explosion_vertical_down_last2);
        bombItemEx_vertical_down[0] = new ImageView(explosion_vertical);
        bombItemEx_vertical_down[1] = new ImageView(explosion_vertical1);
        bombItemEx_vertical_down[2] = new ImageView(explosion_vertical2);
        bombItemEx_horizontal_left[0] = new ImageView(explosion_horizontal);
        bombItemEx_horizontal_left[1] = new ImageView(explosion_horizontal1);
        bombItemEx_horizontal_left[2] = new ImageView(explosion_horizontal2);
        bombItemEx_vertical_up[0] = new ImageView(explosion_vertical);
        bombItemEx_vertical_up[1] = new ImageView(explosion_vertical1);
        bombItemEx_vertical_up[2] = new ImageView(explosion_vertical2);
        bombItemEx_horizontal_right[0] = new ImageView(explosion_horizontal);
        bombItemEx_horizontal_right[1] = new ImageView(explosion_horizontal1);
        bombItemEx_horizontal_right[2] = new ImageView(explosion_horizontal2);
    }

    private void set() {
        for (int i = 0; i < 3; i++) {
            bombItem[i].setFitWidth(SIZE_OF_BOX);
            bombItem[i].setFitHeight(SIZE_OF_BOX);
            bombItemEx[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx[i].setFitHeight(SIZE_OF_BOX);
            bombItemEx_right[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx_right[i].setFitHeight(SIZE_OF_BOX);
            bombItemEx_left[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx_left[i].setFitHeight(SIZE_OF_BOX);
            bombItemEx_up[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx_up[i].setFitHeight(SIZE_OF_BOX);
            bombItemEx_down[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx_down[i].setFitHeight(SIZE_OF_BOX);
            bombItemEx_vertical_up[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx_vertical_up[i].setFitHeight(SIZE_OF_BOX);
            bombItemEx_horizontal_right[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx_horizontal_right[i].setFitHeight(SIZE_OF_BOX);
            bombItemEx_vertical_down[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx_vertical_down[i].setFitHeight(SIZE_OF_BOX);
            bombItemEx_horizontal_left[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx_horizontal_left[i].setFitHeight(SIZE_OF_BOX);
        }
    }

    public Bomb(int x, int y, int length) {
        super(x, y);
        MainGame.map[x][y] = 'b';
        length_of_fire = length;
        construct();
        set();
        horizon = 0;
        vertical = 0;
        timeline_bomb.setCycleCount(1);
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(0),
                (ActionEvent event) -> {
                    bomb_stack.getChildren().setAll(bombItem[0]);
                    action.getChildren().setAll(bomb_stack);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(300),
                (ActionEvent event) -> {
                    bomb_stack.getChildren().setAll(bombItem[1]);
                    action.getChildren().setAll(bomb_stack);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(600),
                (ActionEvent event) -> {
                    bomb_stack.getChildren().setAll(bombItem[2]);
                    action.getChildren().setAll(bomb_stack);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(900),
                (ActionEvent event) -> {
                    bomb_stack.getChildren().setAll(bombItem[1]);
                    action.getChildren().setAll(bomb_stack);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(1200),
                (ActionEvent event) -> {
                    bomb_stack.getChildren().setAll(bombItem[0]);
                    action.getChildren().setAll(bomb_stack);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(1500),
                (ActionEvent event) -> {
                    bomb_stack.getChildren().setAll(bombItem[1]);
                    action.getChildren().setAll(bomb_stack);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(1800),
                (ActionEvent event) -> {
                    bomb_stack.getChildren().setAll(bombItem[2]);
                    action.getChildren().setAll(bomb_stack);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(2200),
                (ActionEvent event) -> {
                    MainGame.sound.playSingleEp(0);
                    Group g = new Group();
                    if (MainGame.bomber.getX() == this.x && MainGame.bomber.getY() == this.y) {
                        MainGame.bomber.dead = true;
                    }
                    g.getChildren().add(bombItemEx[0]);
                    if (canMove(0, -SIZE_OF_BOX)) {
                        if (canMove(0, -length_of_fire * SIZE_OF_BOX) && length_of_fire == 2) {
                            bombItemEx_up[0].setX(0);
                            bombItemEx_up[0].setY(-length_of_fire * SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_up[0]);
                            bombItemEx_vertical_up[0].setX(0);
                            bombItemEx_vertical_up[0].setY(-SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_vertical_up[0]);
                            vertical = 2;
                        } else {
                            bombItemEx_up[0].setX(0);
                            bombItemEx_up[0].setY(-SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_up[0]);
                            vertical = 1;
                        }
                    }
                    if (canMove(0, SIZE_OF_BOX)) {
                        if (canMove(0, length_of_fire * SIZE_OF_BOX) && length_of_fire == 2) {
                            bombItemEx_down[0].setX(0);
                            bombItemEx_down[0].setY(length_of_fire * SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_down[0]);
                            bombItemEx_vertical_down[0].setX(0);
                            bombItemEx_vertical_down[0].setY(SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_vertical_down[0]);
                        } else {
                            bombItemEx_down[0].setX(0);
                            bombItemEx_down[0].setY(SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_down[0]);
                        }
                    }
                    if (canMove(SIZE_OF_BOX, 0)) {
                        if (canMove(SIZE_OF_BOX * length_of_fire, 0) && length_of_fire == 2) {
                            bombItemEx_right[0].setX(SIZE_OF_BOX * length_of_fire);
                            bombItemEx_right[0].setY(0);
                            g.getChildren().add(bombItemEx_right[0]);
                            bombItemEx_horizontal_right[0].setX(SIZE_OF_BOX);
                            bombItemEx_horizontal_right[0].setY(0);
                            g.getChildren().add(bombItemEx_horizontal_right[0]);
                        } else {
                            bombItemEx_right[0].setX(SIZE_OF_BOX);
                            bombItemEx_right[0].setY(0);
                            g.getChildren().add(bombItemEx_right[0]);
                        }
                    }
                    if (canMove(-SIZE_OF_BOX, 0)) {
                        if (canMove(-SIZE_OF_BOX * length_of_fire, 0) && length_of_fire == 2) {
                            bombItemEx_left[0].setX(-SIZE_OF_BOX * length_of_fire);
                            bombItemEx_left[0].setY(0);
                            g.getChildren().add(bombItemEx_left[0]);
                            bombItemEx_horizontal_left[0].setX(-SIZE_OF_BOX);
                            bombItemEx_horizontal_left[0].setY(0);
                            g.getChildren().add(bombItemEx_horizontal_left[0]);
                            horizon = 2;
                        } else {
                            bombItemEx_left[0].setX(-SIZE_OF_BOX);
                            bombItemEx_left[0].setY(0);
                            g.getChildren().add(bombItemEx_left[0]);
                            horizon = 1;
                        }
                    }
                    bomb_stack.getChildren().setAll(g);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(0 - horizon * SIZE_OF_BOX);
                    action.setLayoutY(0 - vertical * SIZE_OF_BOX);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(2400),
                (ActionEvent event) -> {
                    Group g = new Group();

                    g.getChildren().add(bombItemEx[1]);
                    if (canMove(0, -SIZE_OF_BOX)) {
                        if (canMove(0, -length_of_fire * SIZE_OF_BOX) && length_of_fire == 2) {
                            bombItemEx_up[1].setX(0);
                            bombItemEx_up[1].setY(-length_of_fire * SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_up[1]);
                            bombItemEx_vertical_up[1].setX(0);
                            bombItemEx_vertical_up[1].setY(-SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_vertical_up[1]);
                        } else {
                            bombItemEx_up[1].setX(0);
                            bombItemEx_up[1].setY(-SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_up[1]);
                        }
                    }
                    if (canMove(0, SIZE_OF_BOX)) {
                        if (canMove(0, length_of_fire * SIZE_OF_BOX) && length_of_fire == 2) {
                            bombItemEx_down[1].setX(0);
                            bombItemEx_down[1].setY(length_of_fire * SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_down[1]);
                            bombItemEx_vertical_down[1].setX(0);
                            bombItemEx_vertical_down[1].setY(SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_vertical_down[1]);
                        } else {
                            bombItemEx_down[1].setX(0);
                            bombItemEx_down[1].setY(SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_down[1]);
                        }
                    }
                    if (canMove(SIZE_OF_BOX, 0)) {
                        if (canMove(SIZE_OF_BOX * length_of_fire, 0) && length_of_fire == 2) {
                            bombItemEx_right[1].setX(SIZE_OF_BOX * length_of_fire);
                            bombItemEx_right[1].setY(0);
                            g.getChildren().add(bombItemEx_right[1]);
                            bombItemEx_horizontal_right[1].setX(SIZE_OF_BOX);
                            bombItemEx_horizontal_right[1].setY(0);
                            g.getChildren().add(bombItemEx_horizontal_right[1]);
                        } else {
                            bombItemEx_right[1].setX(SIZE_OF_BOX);
                            bombItemEx_right[1].setY(0);
                            g.getChildren().add(bombItemEx_right[1]);
                        }
                    }
                    if (canMove(-SIZE_OF_BOX, 0)) {
                        if (canMove(-SIZE_OF_BOX * length_of_fire, 0) && length_of_fire == 2) {
                            bombItemEx_left[1].setX(-SIZE_OF_BOX * length_of_fire);
                            bombItemEx_left[1].setY(0);
                            g.getChildren().add(bombItemEx_left[1]);
                            bombItemEx_horizontal_left[1].setX(-SIZE_OF_BOX);
                            bombItemEx_horizontal_left[1].setY(0);
                            g.getChildren().add(bombItemEx_horizontal_left[1]);
                        } else {
                            bombItemEx_left[1].setX(-SIZE_OF_BOX);
                            bombItemEx_left[1].setY(0);
                            g.getChildren().add(bombItemEx_left[1]);
                        }
                    }
                    bomb_stack.getChildren().setAll(g);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(0 - horizon * SIZE_OF_BOX);
                    action.setLayoutY(0 - vertical * SIZE_OF_BOX);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(TimeBomb_Explore),
                (ActionEvent event) -> {
                    Group g = new Group();

                    g.getChildren().add(bombItemEx[2]);
                    if (canMove(0, -SIZE_OF_BOX)) {
                        if (canMove(0, -length_of_fire * SIZE_OF_BOX) && length_of_fire == 2) {
                            bombItemEx_up[2].setX(0);
                            bombItemEx_up[2].setY(-length_of_fire * SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_up[2]);
                            bombItemEx_vertical_up[2].setX(0);
                            bombItemEx_vertical_up[2].setY(-SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_vertical_up[2]);
                        } else {
                            bombItemEx_up[2].setX(0);
                            bombItemEx_up[2].setY(-SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_up[2]);
                        }
                    }
                    if (canMove(0, SIZE_OF_BOX)) {
                        if (canMove(0, length_of_fire * SIZE_OF_BOX) && length_of_fire == 2) {
                            bombItemEx_down[2].setX(0);
                            bombItemEx_down[2].setY(length_of_fire * SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_down[2]);
                            bombItemEx_vertical_down[2].setX(0);
                            bombItemEx_vertical_down[2].setY(SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_vertical_down[2]);
                        } else {
                            bombItemEx_down[2].setX(0);
                            bombItemEx_down[2].setY(SIZE_OF_BOX);
                            g.getChildren().add(bombItemEx_down[2]);
                        }
                    }
                    if (canMove(SIZE_OF_BOX, 0)) {
                        if (canMove(SIZE_OF_BOX * length_of_fire, 0) && length_of_fire == 2) {
                            bombItemEx_right[2].setX(SIZE_OF_BOX * length_of_fire);
                            bombItemEx_right[2].setY(0);
                            g.getChildren().add(bombItemEx_right[2]);
                            bombItemEx_horizontal_right[2].setX(SIZE_OF_BOX);
                            bombItemEx_horizontal_right[2].setY(0);
                            g.getChildren().add(bombItemEx_horizontal_right[2]);
                        } else {
                            bombItemEx_right[2].setX(SIZE_OF_BOX);
                            bombItemEx_right[2].setY(0);
                            g.getChildren().add(bombItemEx_right[2]);
                        }
                    }
                    if (canMove(-SIZE_OF_BOX, 0)) {
                        if (canMove(-SIZE_OF_BOX * length_of_fire, 0) && length_of_fire == 2) {
                            bombItemEx_left[2].setX(-SIZE_OF_BOX * length_of_fire);
                            bombItemEx_left[2].setY(0);
                            g.getChildren().add(bombItemEx_left[2]);
                            bombItemEx_horizontal_left[2].setX(-SIZE_OF_BOX);
                            bombItemEx_horizontal_left[2].setY(0);
                            g.getChildren().add(bombItemEx_horizontal_left[2]);
                        } else {
                            bombItemEx_left[2].setX(-SIZE_OF_BOX);
                            bombItemEx_left[2].setY(0);
                            g.getChildren().add(bombItemEx_left[2]);
                        }
                    }
                    bomb_stack.getChildren().setAll(g);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(0 - horizon * SIZE_OF_BOX);
                    action.setLayoutY(0 - vertical * SIZE_OF_BOX);
                    MainGame.map[this.x][this.y] = ' ';
                }
        ));
        timeline_bomb.play();
    }

    private boolean canMove(double _x1, double _y1) {

        int x1 = (int) _x1 / SIZE_OF_BOX;
        int y1 = (int) _y1 / SIZE_OF_BOX;
        if (MainGame.map[x + x1][y + y1] == '#' || (MainGame.destination[x + x1][y + y1] != null
                && MainGame.map[x + x1][y + y1] == ' ')) {
            return false;
        }
        if (MainGame.obstacle[x + x1][y + y1] != null && MainGame.map[x + x1][y + y1] != ' ') {
            ((Brick) MainGame.obstacle[x + x1][y + y1]).explode();
        }
        for (int i = 0; i < MainGame.monster.length; i++) {
            if (MainGame.monster[i].Collide_with_bomb(this.x * SIZE_OF_BOX + _x1
                    , this.y * SIZE_OF_BOX + _y1)) {
                ((Enemy) MainGame.monster[i]).ActionDead();
            }
        }
        if (MainGame.bomber.Collide_with_bomb(this.x * SIZE_OF_BOX + _x1
                , this.y * SIZE_OF_BOX + _y1) && MainGame.bomber.dead == false
                && MainGame.bomber.timeline_dead.getStatus() == Animation.Status.STOPPED) {
            MainGame.bomber.dead = true;
        }
        return true;
    }
}
