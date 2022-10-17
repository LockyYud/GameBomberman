package bomberman.gamebomberman;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Brick extends Entity {
    private boolean exploded;
    private ImageView[] brick_explode = new ImageView[4];
    private Timeline timeline_brick = new Timeline();
    private StackPane brick_stack = new StackPane();

    public Brick(int x, int y) {
        super(x, y);
        exploded = false;
        brick_explode[0] = new ImageView(brick);
        brick_explode[1] = new ImageView(brick_exploded);
        brick_explode[2] = new ImageView(brick_exploded1);
        brick_explode[3] = new ImageView(brick_exploded2);
        for (int i = 0; i < 4; i++) {
            brick_explode[i].setFitWidth(SIZE_OF_BOX);
            brick_explode[i].setFitHeight(SIZE_OF_BOX);
        }
        brick_stack.getChildren().add(brick_explode[0]);
        timeline_brick.setCycleCount(1);
        timeline_brick.getKeyFrames().add(new KeyFrame(
                Duration.millis(150),
                (ActionEvent event) ->{
                    brick_stack.getChildren().setAll(brick_explode[1]);
                }
        ));
        timeline_brick.getKeyFrames().add(new KeyFrame(
                Duration.millis(400),
                (ActionEvent event) ->{
                    brick_stack.getChildren().setAll(brick_explode[2]);
                }
        ));
        timeline_brick.getKeyFrames().add(new KeyFrame(
                Duration.millis(650),
                (ActionEvent event) ->{
                    brick_stack.getChildren().setAll(brick_explode[3]);
                }
        ));
        timeline_brick.getKeyFrames().add(new KeyFrame(
                Duration.millis(900),
                (ActionEvent event) ->{
                    brick_stack.getChildren().setAll();
                }
        ));
        action.getChildren().add(brick_stack);
        action.setLayoutX(this.x);
        action.setLayoutY(this.y);
    }

    public void explode() {
        this.exploded = exploded;
        timeline_brick.play();
    }
}
