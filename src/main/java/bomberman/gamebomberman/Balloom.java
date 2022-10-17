package bomberman.gamebomberman;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Pair;


public class Balloom extends Enemy {
    public Balloom(){}
    public Balloom(int x, int y) {
        this.x = x;
        this.y = y;
        move.getChildren().add(move_left);
        move.getChildren().add(move_right);
        left[0] = new ImageView(balloom_left1);
        left[1] = new ImageView(balloom_left2);
        left[2] = new ImageView(balloom_left3);
        right[0] = new ImageView(balloom_right1);
        right[1] = new ImageView(balloom_right2);
        right[2] = new ImageView(balloom_right3);
        for(int i = 0; i < 3; i++) {
            left[i].setFitHeight(SIZE_OF_BOX);
            left[i].setFitWidth(SIZE_OF_BOX);
            right[i].setFitHeight(SIZE_OF_BOX);
            right[i].setFitWidth(SIZE_OF_BOX);
        }
        move.setTranslateX(x * SIZE_OF_BOX);
        move.setTranslateY(y * SIZE_OF_BOX);
        this.SetTimeline();
        this.timeline_right.play();
    }
}
