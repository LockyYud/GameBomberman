package bomberman.gamebomberman;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.controlsfx.control.action.Action;

public class Balloom extends Enemy implements LoadImage{
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
            left[i].setFitHeight(size_of_box);
            left[i].setFitWidth(size_of_box);
            right[i].setFitHeight(size_of_box);
            right[i].setFitWidth(size_of_box);
        }
    }
}
