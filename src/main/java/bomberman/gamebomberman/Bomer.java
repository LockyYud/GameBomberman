package bomberman.gamebomberman;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.security.Key;
import java.util.GregorianCalendar;

public class Bomer extends Entiny implements LoadImage{
     private ImageView[] images_down = new ImageView[3];
     private ImageView[] images_up = new ImageView[3];
     private ImageView[] images_left = new ImageView[3];
     private ImageView[] images_right = new ImageView[3];
     private ImageView[] images_dead = new ImageView[3];
     public StackPane move_left = new StackPane();
     public StackPane move_right = new StackPane();
     public StackPane move_up = new StackPane();
     public StackPane move_down = new StackPane();
     public Group move = new Group();
     private Timeline timeline_down = new Timeline();
     private Timeline timeline_up = new Timeline();
     private Timeline timeline_left = new Timeline();
     private Timeline timeline_right = new Timeline();
     private TranslateTransition tran_left = new TranslateTransition();
     private TranslateTransition tran_right = new TranslateTransition();
     private TranslateTransition tran_up = new TranslateTransition();
     private TranslateTransition tran_down = new TranslateTransition();
     public EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
          @Override
          public void handle(KeyEvent keyEvent) {
               if(keyEvent.getCode() == KeyCode.DOWN) {
                    y++;
                    timeline_down.play();
                    move_down.toFront();
                    tran_down.setByY(size_of_box);
                    tran_down.setByX(0);
                    tran_down.play();
               }
               if(keyEvent.getCode() == KeyCode.UP) {
                    y--;
                    timeline_up.play();
                    move_up.toFront();
                    tran_up.setByY(-size_of_box);
                    tran_up.setByX(0);
                    tran_up.play();
               }
               if(keyEvent.getCode() == KeyCode.RIGHT) {
                    x++;
                    timeline_right.play();
                    move_right.toFront();
                    tran_right.setByY(0);
                    tran_right.setByX(size_of_box);
                    tran_right.play();
               }
               if(keyEvent.getCode() == KeyCode.LEFT) {
                    x--;
                    timeline_left.play();
                    move_left.toFront();
                    tran_left.setByY(0);
                    tran_left.setByX(-size_of_box);
                    tran_left.play();
               }
          }
     };
     public Bomer(){
          images_down[0] = new ImageView(player_down);
          images_down[1] = new ImageView(player_down_1);
          images_down[2] = new ImageView(player_down_2);
          images_up[0] = new ImageView(player_up);
          images_up[1] = new ImageView(player_up_1);
          images_up[2] = new ImageView(player_up_2);
          images_left[0] = new ImageView(player_left);
          images_left[1] = new ImageView(player_left_1);
          images_left[2] = new ImageView(player_left_2);
          images_right[0] = new ImageView(player_right);
          images_right[1] = new ImageView(player_right_1);
          images_right[2] = new ImageView(player_right_2);
          images_dead[0] = new ImageView(player_dead);
          images_dead[1] = new ImageView(player_dead_1);
          images_dead[2] = new ImageView(player_dead_2);
          for(int i = 0; i < 3; i++) {
               images_down[i].setFitHeight(size_of_box);
               images_down[i].setFitWidth(size_of_box);
               images_up[i].setFitHeight(size_of_box);
               images_up[i].setFitWidth(size_of_box);
               images_left[i].setFitHeight(size_of_box);
               images_left[i].setFitWidth(size_of_box);
               images_right[i].setFitHeight(size_of_box);
               images_right[i].setFitWidth(size_of_box);
               images_dead[i].setFitHeight(size_of_box);
               images_dead[i].setFitWidth(size_of_box);
          }
          x = 0;
          y = 0;

          //TimeLine for move left
          timeline_left.setCycleCount(1);
          timeline_left.getKeyFrames().add(new KeyFrame(
                  Duration.millis(100),
                  (ActionEvent event) -> {
                       move_left.getChildren().setAll(images_left[1]);
                  }
          ));
          timeline_left.getKeyFrames().add(new KeyFrame(
                  Duration.millis(200),
                  (ActionEvent event) -> {
                       move_left.getChildren().setAll(images_left[2]);
                  }
          ));
          timeline_left.getKeyFrames().add(new KeyFrame(
                  Duration.millis(300),
                  (ActionEvent event) -> {
                       move_left.getChildren().setAll(images_left[0]);
                  }
          ));
          //TimeLine for move right
          timeline_right.setCycleCount(1);
          timeline_right.getKeyFrames().add(new KeyFrame(
                  Duration.millis(100),
                  (ActionEvent event) -> {
                       move_right.getChildren().setAll(images_right[1]);
                  }
          ));
          timeline_right.getKeyFrames().add(new KeyFrame(
                  Duration.millis(200),
                  (ActionEvent event) -> {
                       move_right.getChildren().setAll(images_right[2]);
                  }
          ));
          timeline_right.getKeyFrames().add(new KeyFrame(
                  Duration.millis(300),
                  (ActionEvent event) -> {
                       move_right.getChildren().setAll(images_right[0]);
                  }
          ));

          //TimeLine for move up
          timeline_up.setCycleCount(1);
          timeline_up.getKeyFrames().add(new KeyFrame(
                  Duration.millis(100),
                  (ActionEvent event) -> {
                       move_up.getChildren().setAll(images_up[1]);
                  }
          ));
          timeline_up.getKeyFrames().add(new KeyFrame(
                  Duration.millis(200),
                  (ActionEvent event) -> {
                       move_up.getChildren().setAll(images_up[2]);
                  }
          ));
          timeline_up.getKeyFrames().add(new KeyFrame(
                  Duration.millis(300),
                  (ActionEvent event) -> {
                       move_up.getChildren().setAll(images_up[0]);
                  }
          ));

          //TimeLine for move down
          timeline_down.setCycleCount(1);
          timeline_down.getKeyFrames().add(new KeyFrame(
                  Duration.millis(100),
                  (ActionEvent event) -> {
                       move_down.getChildren().setAll(images_down[1]);
                  }
          ));
          timeline_down.getKeyFrames().add(new KeyFrame(
                  Duration.millis(200),
                  (ActionEvent event) -> {
                       move_down.getChildren().setAll(images_down[2]);
                  }
          ));
          timeline_down.getKeyFrames().add(new KeyFrame(
                  Duration.millis(300),
                  (ActionEvent event) -> {
                       move_down.getChildren().setAll(images_down[0]);
                  }
          ));

          //move all
          move.getChildren().add(move_right);
          move.getChildren().add(move_left);
          move.getChildren().add(move_down);
          move.getChildren().add(move_up);
          //tran_left
          tran_left.setNode(move);
          tran_left.setDuration(Duration.millis(300));
          tran_left.setCycleCount(1);
          tran_left.setAutoReverse(false);
          //tran_right
          tran_right.setNode(move);
          tran_right.setDuration(Duration.millis(300));
          tran_right.setCycleCount(1);
          tran_right.setAutoReverse(false);
          //tran_up
          tran_up.setNode(move);
          tran_up.setDuration(Duration.millis(300));
          tran_up.setCycleCount(1);
          tran_up.setAutoReverse(false);
          //tran_down
          tran_down.setNode(move);
          tran_down.setDuration(Duration.millis(300));
          tran_down.setCycleCount(1);
          tran_down.setAutoReverse(false);
     }
}
