package bomberman.gamebomberman;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicBoolean;

public class Bomb extends Entity {
    private int length_of_fire;
    private ImageView[] bombItem = new ImageView[3];
    private ImageView[] bombItemEx = new ImageView[3];
    private ImageView[] bombItemEx_right = new ImageView[3];
    private ImageView[] bombItemEx_left = new ImageView[3];
    private ImageView[] bombItemEx_up = new ImageView[3];
    private ImageView[] bombItemEx_down = new ImageView[3];
    private ImageView[] bombItemEx_vertical = new ImageView[3];
    private ImageView[] bombItemEx_horizontal = new ImageView[3];
    private Timeline timeline_bomb = new Timeline();
    private StackPane bomb_stack = new StackPane();

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
        bombItemEx_vertical[0] = new ImageView(explosion_vertical);
        bombItemEx_vertical[1] = new ImageView(explosion_vertical1);
        bombItemEx_vertical[2] = new ImageView(explosion_vertical2);
        bombItemEx_horizontal[0] = new ImageView(explosion_horizontal);
        bombItemEx_horizontal[1] = new ImageView(explosion_horizontal1);
        bombItemEx_horizontal[2] = new ImageView(explosion_horizontal2);
    }

    private void set(int length) {
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
            bombItemEx_vertical[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx_vertical[i].setFitHeight(SIZE_OF_BOX);
            bombItemEx_horizontal[i].setFitWidth(SIZE_OF_BOX);
            bombItemEx_horizontal[i].setFitHeight(SIZE_OF_BOX);
        }
    }

    public Bomb(int x, int y, int length) {
        super(x, y);
        length_of_fire = length;
        construct();
        set(length_of_fire);
        bomb_stack.getChildren().setAll(bombItem[0]);
        action.getChildren().setAll(bomb_stack);
        action.setLayoutX(this.x);
        action.setLayoutY(this.y);
        timeline_bomb.setCycleCount(1);
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(1000),
                (ActionEvent event) ->{
                    bomb_stack.getChildren().setAll(bombItem[1]);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(this.x);
                    action.setLayoutY(this.y);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(1600),
                (ActionEvent event) ->{
                    bomb_stack.getChildren().setAll(bombItem[2]);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(this.x);
                    action.setLayoutY(this.y);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(2200),
                (ActionEvent event) ->{
                    int length_up = 0;
                    int length_left = 0;
                    Group g = new Group();
                    for (int i = 0; i < 1; i++) {
                        bombItemEx[i].setX(this.x);
                        bombItemEx[i].setY(this.y);
                        g.getChildren().add(bombItemEx[i]);
                        bombItemEx_up[i].setX(this.x);
                        bombItemEx_up[i].setY(this.y - length_of_fire * SIZE_OF_BOX);
                        if (canMove(bombItemEx_up[i].getX(), bombItemEx_up[i].getY())) {
                            length_up++;
                            g.getChildren().add(bombItemEx_up[i]);
                        }
                        bombItemEx_down[i].setX(this.x);
                        bombItemEx_down[i].setY(this.y + length_of_fire * SIZE_OF_BOX);
                        if (canMove(bombItemEx_down[i].getX(), bombItemEx_down[i].getY())) {
                            g.getChildren().add(bombItemEx_down[i]);
                        }
                        bombItemEx_right[i].setX(this.x + length_of_fire * SIZE_OF_BOX);
                        bombItemEx_right[i].setY(this.y);
                        if (canMove(bombItemEx_right[i].getX(), bombItemEx_right[i].getY())) {
                            g.getChildren().add(bombItemEx_right[i]);
                        }
                        bombItemEx_left[i].setX(this.x - length_of_fire * SIZE_OF_BOX);
                        bombItemEx_left[i].setY(this.y);
                        if (canMove(bombItemEx_left[i].getX(), bombItemEx_left[i].getY())) {
                            length_left++;
                            g.getChildren().add(bombItemEx_left[i]);
                        }
                        if (length_of_fire > 1) {
                            int n = length_of_fire - 1;
                            while (n > 0) {
                                ImageView temp_up = new ImageView(bombItemEx_vertical[i].getImage());
                                temp_up.setFitWidth(SIZE_OF_BOX);
                                temp_up.setFitHeight(SIZE_OF_BOX);
                                temp_up.setX(this.x);
                                temp_up.setY(this.y - n * SIZE_OF_BOX);
                                if (canMove(temp_up.getX(), temp_up.getY())) {
                                    length_up++;
                                    g.getChildren().add(temp_up);
                                }
                                ImageView temp_down = new ImageView(bombItemEx_vertical[i].getImage());
                                temp_down.setFitWidth(SIZE_OF_BOX);
                                temp_down.setFitHeight(SIZE_OF_BOX);
                                temp_down.setX(this.x);
                                temp_down.setY(this.y + n * SIZE_OF_BOX);
                                if (canMove(temp_down.getX(), temp_down.getY())) {
                                    g.getChildren().add(temp_down);
                                }
                                ImageView temp_right = new ImageView(bombItemEx_horizontal[i].getImage());
                                temp_right.setFitWidth(SIZE_OF_BOX);
                                temp_right.setFitHeight(SIZE_OF_BOX);
                                temp_right.setX(this.x + n * SIZE_OF_BOX);
                                temp_right.setY(this.y);
                                if (canMove(temp_right.getX(), temp_right.getY())) {
                                    g.getChildren().add(temp_right);
                                }
                                ImageView temp_left = new ImageView(bombItemEx_horizontal[i].getImage());
                                temp_left.setFitWidth(SIZE_OF_BOX);
                                temp_left.setFitHeight(SIZE_OF_BOX);
                                temp_left.setX(this.x - n * SIZE_OF_BOX);
                                temp_left.setY(this.y);
                                if (canMove(temp_left.getX(), temp_left.getY())) {
                                    length_left++;
                                    g.getChildren().add(temp_left);
                                }
                                n--;
                            }
                        }
                    }
                    bomb_stack.getChildren().setAll(g);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(this.x - length_left * SIZE_OF_BOX);
                    action.setLayoutY(this.y - length_up * SIZE_OF_BOX);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(2500),
                (ActionEvent event) ->{
                    int length_up = 0;
                    int length_left = 0;
                    Group g = new Group();
                    for (int i = 1; i < 2; i++) {
                        bombItemEx[i].setX(this.x);
                        bombItemEx[i].setY(this.y);
                        g.getChildren().add(bombItemEx[i]);
                        bombItemEx_up[i].setX(this.x);
                        bombItemEx_up[i].setY(this.y - length_of_fire * SIZE_OF_BOX);
                        if (canMove(bombItemEx_up[i].getX(), bombItemEx_up[i].getY())) {
                            length_up++;
                            g.getChildren().add(bombItemEx_up[i]);
                        }
                        bombItemEx_down[i].setX(this.x);
                        bombItemEx_down[i].setY(this.y + length_of_fire * SIZE_OF_BOX);
                        if (canMove(bombItemEx_down[i].getX(), bombItemEx_down[i].getY())) {
                            g.getChildren().add(bombItemEx_down[i]);
                        }
                        bombItemEx_right[i].setX(this.x + length_of_fire * SIZE_OF_BOX);
                        bombItemEx_right[i].setY(this.y);
                        if (canMove(bombItemEx_right[i].getX(), bombItemEx_right[i].getY())) {
                            g.getChildren().add(bombItemEx_right[i]);
                        }
                        bombItemEx_left[i].setX(this.x - length_of_fire * SIZE_OF_BOX);
                        bombItemEx_left[i].setY(this.y);
                        if (canMove(bombItemEx_left[i].getX(), bombItemEx_left[i].getY())) {
                            length_left++;
                            g.getChildren().add(bombItemEx_left[i]);
                        }
                        if (length_of_fire > 1) {
                            int n = length_of_fire - 1;
                            while (n > 0) {
                                ImageView temp_up = new ImageView(bombItemEx_vertical[i].getImage());
                                temp_up.setFitWidth(SIZE_OF_BOX);
                                temp_up.setFitHeight(SIZE_OF_BOX);
                                temp_up.setX(this.x);
                                temp_up.setY(this.y - n * SIZE_OF_BOX);
                                if (canMove(temp_up.getX(), temp_up.getY())) {
                                    length_up++;
                                    g.getChildren().add(temp_up);
                                }
                                ImageView temp_down = new ImageView(bombItemEx_vertical[i].getImage());
                                temp_down.setFitWidth(SIZE_OF_BOX);
                                temp_down.setFitHeight(SIZE_OF_BOX);
                                temp_down.setX(this.x);
                                temp_down.setY(this.y + n * SIZE_OF_BOX);
                                if (canMove(temp_down.getX(), temp_down.getY())) {
                                    g.getChildren().add(temp_down);
                                }
                                ImageView temp_right = new ImageView(bombItemEx_horizontal[i].getImage());
                                temp_right.setFitWidth(SIZE_OF_BOX);
                                temp_right.setFitHeight(SIZE_OF_BOX);
                                temp_right.setX(this.x + n * SIZE_OF_BOX);
                                temp_right.setY(this.y);
                                if (canMove(temp_right.getX(), temp_right.getY())) {
                                    g.getChildren().add(temp_right);
                                }
                                ImageView temp_left = new ImageView(bombItemEx_horizontal[i].getImage());
                                temp_left.setFitWidth(SIZE_OF_BOX);
                                temp_left.setFitHeight(SIZE_OF_BOX);
                                temp_left.setX(this.x - n * SIZE_OF_BOX);
                                temp_left.setY(this.y);
                                if (canMove(temp_left.getX(), temp_left.getY())) {
                                    length_left++;
                                    g.getChildren().add(temp_left);
                                }
                                n--;
                            }
                        }
                    }
                    bomb_stack.getChildren().setAll(g);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(this.x - length_left * SIZE_OF_BOX);
                    action.setLayoutY(this.y - length_up * SIZE_OF_BOX);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(2800),
                (ActionEvent event) ->{
                    int length_up = 0;
                    int length_left = 0;
                    Group g = new Group();
                    for (int i = 2; i < 3; i++) {
                        bombItemEx[i].setX(this.x);
                        bombItemEx[i].setY(this.y);
                        g.getChildren().add(bombItemEx[i]);
                        bombItemEx_up[i].setX(this.x);
                        bombItemEx_up[i].setY(this.y - length_of_fire * SIZE_OF_BOX);
                        if (canMove(bombItemEx_up[i].getX(), bombItemEx_up[i].getY())) {
                            length_up++;
                            g.getChildren().add(bombItemEx_up[i]);
                        }
                        bombItemEx_down[i].setX(this.x);
                        bombItemEx_down[i].setY(this.y + length_of_fire * SIZE_OF_BOX);
                        if (canMove(bombItemEx_down[i].getX(), bombItemEx_down[i].getY())) {
                            g.getChildren().add(bombItemEx_down[i]);
                        }
                        bombItemEx_right[i].setX(this.x + length_of_fire * SIZE_OF_BOX);
                        bombItemEx_right[i].setY(this.y);
                        if (canMove(bombItemEx_right[i].getX(), bombItemEx_right[i].getY())) {
                            g.getChildren().add(bombItemEx_right[i]);
                        }
                        bombItemEx_left[i].setX(this.x - length_of_fire * SIZE_OF_BOX);
                        bombItemEx_left[i].setY(this.y);
                        if (canMove(bombItemEx_left[i].getX(), bombItemEx_left[i].getY())) {
                            length_left++;
                            g.getChildren().add(bombItemEx_left[i]);
                        }
                        if (length_of_fire > 1) {
                            int n = length_of_fire - 1;
                            while (n > 0) {
                                ImageView temp_up = new ImageView(bombItemEx_vertical[i].getImage());
                                temp_up.setFitWidth(SIZE_OF_BOX);
                                temp_up.setFitHeight(SIZE_OF_BOX);
                                temp_up.setX(this.x);
                                temp_up.setY(this.y - n * SIZE_OF_BOX);
                                if (canMove(temp_up.getX(), temp_up.getY())) {
                                    length_up++;
                                    g.getChildren().add(temp_up);
                                }
                                ImageView temp_down = new ImageView(bombItemEx_vertical[i].getImage());
                                temp_down.setFitWidth(SIZE_OF_BOX);
                                temp_down.setFitHeight(SIZE_OF_BOX);
                                temp_down.setX(this.x);
                                temp_down.setY(this.y + n * SIZE_OF_BOX);
                                if (canMove(temp_down.getX(), temp_down.getY())) {
                                    g.getChildren().add(temp_down);
                                }
                                ImageView temp_right = new ImageView(bombItemEx_horizontal[i].getImage());
                                temp_right.setFitWidth(SIZE_OF_BOX);
                                temp_right.setFitHeight(SIZE_OF_BOX);
                                temp_right.setX(this.x + n * SIZE_OF_BOX);
                                temp_right.setY(this.y);
                                if (canMove(temp_right.getX(), temp_right.getY())) {
                                    g.getChildren().add(temp_right);
                                }
                                ImageView temp_left = new ImageView(bombItemEx_horizontal[i].getImage());
                                temp_left.setFitWidth(SIZE_OF_BOX);
                                temp_left.setFitHeight(SIZE_OF_BOX);
                                temp_left.setX(this.x - n * SIZE_OF_BOX);
                                temp_left.setY(this.y);
                                if (canMove(temp_left.getX(), temp_left.getY())) {
                                    length_left++;
                                    g.getChildren().add(temp_left);
                                }
                                n--;
                            }
                        }
                    }
                    bomb_stack.getChildren().setAll(g);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(this.x - length_left * SIZE_OF_BOX);
                    action.setLayoutY(this.y - length_up * SIZE_OF_BOX);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(3100),
                (ActionEvent) ->{
                    action.getChildren().setAll();
                }
        ));

        timeline_bomb.play();
    }

    private boolean canMove(double _x1, double _y1) {
        char[][] tmap = MainGame.map;
        int xb = this.x / SIZE_OF_BOX;
        int yb = this.y / SIZE_OF_BOX;
        int x1 = (int) _x1 / SIZE_OF_BOX;
        int y1 = (int) _y1 / SIZE_OF_BOX;
        if (xb == x1) {
            if (yb > y1) {
                for (int i = yb; i >= y1; i--) {
                    if (tmap[x1][i] == '#' || tmap[x1][i] == '*') {
                        if (tmap[x1][i] == '*') {
//                            MainGame.setBrickExplode(x1, i);
                        }
                        return false;
                    }
                }
            } else {
                for (int i = yb; i <= y1; i++) {
                    if (tmap[x1][i] == '#' || tmap[x1][i] == '*') {
                        if (tmap[x1][i] == '*') {
//                            MainGame.setBrickExplode(x1, i);
                        }
                        return false;
                    }
                }
            }
        } else if (yb == y1) {
            if (xb > x1) {
                for (int i = xb; i >= x1; i--) {
                    if (tmap[i][y1] == '#' || tmap[i][y1] == '*') {
                        if (tmap[i][y1] == '*') {
//                            MainGame.setBrickExplode(i, y1);
                        }
                        return false;
                    }
                }
            } else {
                for (int i = xb; i <= x1; i++) {
                    if (tmap[i][y1] == '#' || tmap[i][y1] == '*') {
                        if (tmap[i][y1] == '*') {
//                            MainGame.setBrickExplode(i, y1);
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
