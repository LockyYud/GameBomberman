package bomberman.gamebomberman;

//import java.util.*;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.TimerTask;

public abstract class Enemy extends Entity {
    protected ImageView[] left = new ImageView[3];
    protected ImageView[] right = new ImageView[3];
    protected Timeline timeline_left = new Timeline();
    protected Timeline timeline_right = new Timeline();
    protected StackPane move_left = new StackPane();
    protected StackPane move_right = new StackPane();
    public TimerTask timer = new TimerTask() {
        @Override
        public void run() {

        }
    };
    public Enemy(){}
    protected void SetTimeline() {
        //TimeLine left;
        timeline_left.setCycleCount(Timeline.INDEFINITE);
        timeline_left.getKeyFrames().add(new KeyFrame(
                Duration.millis(100),
                (ActionEvent event) -> {
                    move_left.getChildren().setAll(left[0]);
                }
        ));
        timeline_left.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),
                (ActionEvent event) -> {
                    move_left.getChildren().setAll(left[1]);
                }
        ));
        timeline_left.getKeyFrames().add(new KeyFrame(
                Duration.millis(300),
                (ActionEvent event) -> {
                    move_left.getChildren().setAll(left[2]);
                }
        ));
        //TimeLine right
        timeline_right.setCycleCount(Timeline.INDEFINITE);
        timeline_right.getKeyFrames().add(new KeyFrame(
                Duration.millis(100),
                (ActionEvent event) -> {
                    move_right.getChildren().setAll(right[0]);
                }
        ));
        timeline_right.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),
                (ActionEvent event) -> {
                    move_right.getChildren().setAll(right[1]);
                }
        ));
        timeline_right.getKeyFrames().add(new KeyFrame(
                Duration.millis(300),
                (ActionEvent event) -> {
                    move_right.getChildren().setAll(right[2]);
                }
        ));
    }


    private int randommove() {
        int a = (int) (4 * Math.random());
        return a;
    }
}
