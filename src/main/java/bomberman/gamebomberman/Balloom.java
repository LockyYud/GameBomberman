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
        this.SetTimeline();
        this.timeline_right.play();
    }
    public EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent keyEvent) {
            if(keyEvent.getCode() == KeyCode.SPACE) {
                timer.cancel();
            }
            if(keyEvent.getCode() == KeyCode.DOWN) {
                tran_down.setByY(SIZE_OF_BOX);
                tran_down.setByX(0);
                tran_down.play();
            }
            if(keyEvent.getCode() == KeyCode.UP) {
                tran_up.setByY(-SIZE_OF_BOX);
                tran_up.setByX(0);
                tran_up.play();
            }
            if(keyEvent.getCode() == KeyCode.RIGHT) {
                tran_right.setByY(0);
                tran_right.setByX(SIZE_OF_BOX);
                tran_right.play();
            }
            if(keyEvent.getCode() == KeyCode.LEFT) {
                tran_left.setByY(0);
                tran_left.setByX(-SIZE_OF_BOX);
                tran_left.play();
            }
        }
    };
}
