package bomberman.gamebomberman;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public abstract class Enemy extends Entity {
    protected ImageView[] left = new ImageView[3];
    protected ImageView[] right = new ImageView[3];
    protected Timeline timeline_left = new Timeline();
    protected Timeline timeline_right = new Timeline();
    protected StackPane move_left = new StackPane();
    protected StackPane move_right = new StackPane();
    TranslateTransition tran = new TranslateTransition();
    AnimationTimer timer;
    public Enemy(){}
    public Enemy(int x, int y) {
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
    }
    public void playtran() {
        this.SetTimeline();
        tran.play();
        timer.start();
        timeline_right.play();
        timeline_left.play();
    }
    private void SetTimeline() {
        //TimeLine left
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
        tran.setNode(move);
        tran.setCycleCount(TranslateTransition.INDEFINITE);
        tran.setAutoReverse(true);
        tran.setDuration(Duration.millis(3000));
        tran.setByX(500);
        tran.setByY(0);
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(tran.getNode().getTranslateX() > 400) move_left.toFront();
                if(tran.getNode().getTranslateX() < 50) move_right.toFront();
            }
        };
    }
//    private int randommove() {
//
//    }
}
