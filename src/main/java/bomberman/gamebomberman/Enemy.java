package bomberman.gamebomberman;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public abstract class Enemy extends Entity implements LoadImage{
    protected ImageView[] left = new ImageView[3];
    protected ImageView[] right = new ImageView[3];
    protected Timeline timeline_left = new Timeline();
    protected Timeline timeline_right = new Timeline();
    protected StackPane move_left = new StackPane();
    protected StackPane move_right = new StackPane();
    public TimerTask timer = new TimerTask() {
        @Override
        public void run() {
            switch (randommove()) {
                case 1:
                    System.out.println(1);
                    tran_down.play();
                    break;
                case 2:
                    System.out.println(2);
                    tran_up.play();
                    break;
                case 3:
                    System.out.println(3);
                    tran_right.play();
                    break;
                case 4:
                    System.out.println(4);
                    tran_left.play();
                    break;
            }
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
//        System.out.println(a);
        return a;
    }
}
