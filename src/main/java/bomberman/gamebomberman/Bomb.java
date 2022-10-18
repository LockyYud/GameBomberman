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
    private ImageView[] bombItem = new ImageView[30];
    private Timeline timeline_bomb = new Timeline();
    private StackPane bomb_stack = new StackPane();

    private void construct() {
        bombItem[0] = new ImageView(bomb);
        bombItem[1] = new ImageView(bomb_1);
        bombItem[2] = new ImageView(bomb_2);
        bombItem[3] = new ImageView(bomb_exploded);
        bombItem[4] = new ImageView(bomb_exploded1);
        bombItem[5] = new ImageView(bomb_exploded2);
        bombItem[6] = new ImageView(explosion_horizontal);
        bombItem[7] = new ImageView(explosion_horizontal1);
        bombItem[8] = new ImageView(explosion_horizontal2);
        bombItem[9] = new ImageView(explosion_horizontal_left_last);
        bombItem[10] = new ImageView(explosion_horizontal_left_last1);
        bombItem[11] = new ImageView(explosion_horizontal_left_last2);
        bombItem[12] = new ImageView(explosion_horizontal_right_last);
        bombItem[13] = new ImageView(explosion_horizontal_right_last1);
        bombItem[14] = new ImageView(explosion_horizontal_right_last2);
        bombItem[15] = new ImageView(explosion_vertical);
        bombItem[16] = new ImageView(explosion_vertical1);
        bombItem[17] = new ImageView(explosion_vertical2);
        bombItem[18] = new ImageView(explosion_vertical_down_last);
        bombItem[19] = new ImageView(explosion_vertical_down_last1);
        bombItem[20] = new ImageView(explosion_vertical_down_last2);
        bombItem[21] = new ImageView(explosion_vertical_top_last);
        bombItem[22] = new ImageView(explosion_vertical_top_last1);
        bombItem[23] = new ImageView(explosion_vertical_top_last2);
        bombItem[24] = new ImageView(explosion_horizontal);
        bombItem[25] = new ImageView(explosion_horizontal1);
        bombItem[26] = new ImageView(explosion_horizontal2);
        bombItem[27] = new ImageView(explosion_vertical);
        bombItem[28] = new ImageView(explosion_vertical1);
        bombItem[29] = new ImageView(explosion_vertical2);
    }

    private void set(int length) {
        for (int i = 0; i < 30; i++) {
            bombItem[i].setFitWidth(SIZE_OF_BOX);
            bombItem[i].setFitHeight(SIZE_OF_BOX);
        }
        for (int i = 0; i < 6; i++) {
            bombItem[i].setX(this.x);
            bombItem[i].setY(this.y);
        }
        for (int i = 6; i < 9; i++) {
            int n = length - 1;
            while (n > 0) {
                bombItem[i].setX(this.x - n * SIZE_OF_BOX);
                bombItem[i].setY(this.y);
                bombItem[i + 18].setX(this.x + n * SIZE_OF_BOX);
                bombItem[i + 18].setY(this.y);
                n--;
            }
        }
        for (int i = 9; i < 12; i++) {
            bombItem[i].setX(this.x - (length) * SIZE_OF_BOX);
            bombItem[i].setY(this.y);
        }
        for (int i = 12; i < 15; i++) {
            bombItem[i].setX(this.x + (length) * SIZE_OF_BOX);
            bombItem[i].setY(this.y);
        }
        for (int i = 15; i < 18; i++) {
            int n = length - 1;
            while (n > 0) {
                bombItem[i].setX(this.x);
                bombItem[i].setY(this.y - n * SIZE_OF_BOX);
                bombItem[i + 12].setX(this.x);
                bombItem[i + 12].setY(this.y + n * SIZE_OF_BOX);
                n--;
            }
        }
        for (int i = 18; i < 21; i++) {
            bombItem[i].setX(this.x);
            bombItem[i].setY(this.y + (length) * SIZE_OF_BOX);
        }
        for (int i = 21; i < 24; i++) {
            bombItem[i].setX(this.x);
            bombItem[i].setY(this.y - (length) * SIZE_OF_BOX);
        }
    }

    public Bomb(int x, int y, int length) {
        super(x, y);
        construct();
        set(length);
        AtomicBoolean transformed = new AtomicBoolean(false);
        bomb_stack.getChildren().setAll(bombItem[0]);
        action.getChildren().setAll(bomb_stack);
        action.setLayoutX(this.x);
        action.setLayoutY(this.y);
        timeline_bomb.setCycleCount(1);
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(600),
                (ActionEvent event) ->{
                    bomb_stack.getChildren().setAll(bombItem[1]);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(this.x);
                    action.setLayoutY(this.y);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(1200),
                (ActionEvent event) ->{
                    bomb_stack.getChildren().setAll(bombItem[2]);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(this.x);
                    action.setLayoutY(this.y);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(1800),
                (ActionEvent event) ->{
                    Group g = new Group();
                    if (length > 1) {
                        for (int i = 3; i <= 27; i += 3) {
                            Group temp = new Group(bombItem[i]);
                            g.getChildren().add(temp);
                        }
                    } else {
                        int[] a = {3, 9, 12, 18, 21};
                        for (int i = 0; i < 5; i++) {
                            Group temp = new Group(bombItem[a[i]]);
                            g.getChildren().add(temp);
                        }
                    }
                    bomb_stack.getChildren().setAll(g);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(this.x - length * SIZE_OF_BOX);
                    action.setLayoutY(this.y - length * SIZE_OF_BOX);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(2200),
                (ActionEvent event) ->{
                    Group g = new Group();
                    if (length > 1) {
                        for (int i = 4; i <= 28; i += 3) {
                            Group temp = new Group(bombItem[i]);
                            g.getChildren().add(temp);
                        }
                    } else {
                        int[] a = {4, 10, 13, 19, 22};
                        for (int i = 0; i < 5; i++) {
                            Group temp = new Group(bombItem[a[i]]);
                            g.getChildren().add(temp);
                        }
                    }
                    bomb_stack.getChildren().setAll(g);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(this.x - length * SIZE_OF_BOX);
                    action.setLayoutY(this.y - length * SIZE_OF_BOX);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(2400),
                (ActionEvent event) ->{
                    Group g = new Group();
                    if (length > 1) {
                        for (int i = 5; i <= 29; i += 3) {
                            Group temp = new Group(bombItem[i]);
                            g.getChildren().add(temp);
                        }
                    } else {
                        int[] a = {5, 11, 14, 20, 23};
                        for (int i = 0; i < 5; i++) {
                            Group temp = new Group(bombItem[a[i]]);
                            g.getChildren().add(temp);
                        }
                    }
                    bomb_stack.getChildren().setAll(g);
                    action.getChildren().setAll(bomb_stack);
                    action.setLayoutX(this.x - length * SIZE_OF_BOX);
                    action.setLayoutY(this.y - length * SIZE_OF_BOX);
                }
        ));
        timeline_bomb.getKeyFrames().add(new KeyFrame(
                Duration.millis(2600),
                (ActionEvent) ->{
                    action.getChildren().setAll();
                }
        ));

        timeline_bomb.play();
    }
<<<<<<< HEAD

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
=======
>>>>>>> parent of 8da81cb (Recode Bomb)
}
