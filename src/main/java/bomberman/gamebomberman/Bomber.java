package bomberman.gamebomberman;

import com.almasb.fxgl.dev.editor.EntityInspector;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import java.util.*;

public class Bomber extends Entity {
     public final int time_move = 300;
     private boolean canMove = false;
     private ImageView[] images_down = new ImageView[3];
     private ImageView[] images_up = new ImageView[3];
     private ImageView[] images_left = new ImageView[3];
     private ImageView[] images_right = new ImageView[3];
     private ImageView[] images_dead = new ImageView[3];
     public StackPane move_left = new StackPane();
     public StackPane move_right = new StackPane();
     public StackPane move_up = new StackPane();
     public StackPane move_down = new StackPane();
     public StackPane dead = new StackPane();
     private Timeline timeline_down = new Timeline();
     private Timeline timeline_up = new Timeline();
     private Timeline timeline_left = new Timeline();
     private Timeline timeline_right = new Timeline();
     public Timeline timeline_dead = new Timeline();
     private TranslateTransition transition = new TranslateTransition();

     private List<Bomb> bombs = new ArrayList<>();
     public EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
          @Override
          public void handle(KeyEvent keyEvent) {
               int newX = x;
               int newY = y;
               if(keyEvent.getCode() == KeyCode.SPACE) {
               }
               if(keyEvent.getCode() == KeyCode.DOWN) {
                    newY++;
                    timeline_down.play();
//                    move_down.toFront();
                    action.getChildren().setAll(move_down);
                    transition = tran_down;
                    canMove = true;
               }
               if(keyEvent.getCode() == KeyCode.UP) {
                    newY--;
                    timeline_up.play();
                    action.getChildren().setAll(move_up);
                    transition = tran_up;
                    canMove = true;
               }
               if(keyEvent.getCode() == KeyCode.RIGHT) {
                    newX++;
                    timeline_right.play();
                    action.getChildren().setAll(move_right);
                    transition = tran_right;
                    canMove = true;
               }
               if(keyEvent.getCode() == KeyCode.LEFT) {
                    newX--;
                    timeline_left.play();
                    action.getChildren().setAll(move_left);
                    transition = tran_left;
                    canMove = true;
               }
               if(CanMove(newX, newY) && canMove){
                    transition.play();
                    x = newX;
                    y = newY;
                    canMove = false;
               }
               canMove = false;
               if(keyEvent.getCode() == KeyCode.SPACE) {
                    System.out.println(x + " " + y);
               }
               if(keyEvent.getCode() == KeyCode.M) {
                    System.out.println(newX + " " + newY);
               }
          }
     };
     public Bomber(){
          for(int i = 0; i < MainGame.map.length; i++) {
               for(int j = 0; j < MainGame.map[i].length; j++) {
                    if(MainGame.map[i][j] == 'p') {
                         x = i;
                         y = j;
                         break;
                    }
               }
          }
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
          images_dead[0] = new ImageView(player_dead1);
          images_dead[1] = new ImageView(player_dead2);
          images_dead[2] = new ImageView(player_dead3);
          for(int i = 0; i < 3; i++) {
               images_down[i].setFitHeight(SIZE_OF_BOX);
               images_down[i].setFitWidth(SIZE_OF_BOX);
               images_up[i].setFitHeight(SIZE_OF_BOX);
               images_up[i].setFitWidth(SIZE_OF_BOX);
               images_left[i].setFitHeight(SIZE_OF_BOX);
               images_left[i].setFitWidth(SIZE_OF_BOX);
               images_right[i].setFitHeight(SIZE_OF_BOX);
               images_right[i].setFitWidth(SIZE_OF_BOX);
               images_dead[i].setFitHeight(SIZE_OF_BOX);
               images_dead[i].setFitWidth(SIZE_OF_BOX);
          }
          //TimeLine for move left
          timeline_left.setCycleCount(1);
          timeline_left.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move / 3),
                  (ActionEvent event) -> {
                       move_left.getChildren().setAll(images_left[1]);
                  }
          ));
          timeline_left.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move / 3 * 2),
                  (ActionEvent event) -> {
                       move_left.getChildren().setAll(images_left[2]);
                  }
          ));
          timeline_left.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move),
                  (ActionEvent event) -> {
                       move_left.getChildren().setAll(images_left[0]);
                  }
          ));
          //TimeLine for move right
          timeline_right.setCycleCount(1);
          timeline_right.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move/3),
                  (ActionEvent event) -> {
                       move_right.getChildren().setAll(images_right[1]);
                  }
          ));
          timeline_right.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move / 3 * 2),
                  (ActionEvent event) -> {
                       move_right.getChildren().setAll(images_right[2]);
                  }
          ));
          timeline_right.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move),
                  (ActionEvent event) -> {
                       move_right.getChildren().setAll(images_right[0]);
                  }
          ));

          //TimeLine for move up
          timeline_up.setCycleCount(1);
          timeline_up.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move/3),
                  (ActionEvent event) -> {
                       move_up.getChildren().setAll(images_up[1]);
                  }
          ));
          timeline_up.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move / 3 * 2),
                  (ActionEvent event) -> {
                       move_up.getChildren().setAll(images_up[2]);
                  }
          ));
          timeline_up.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move),
                  (ActionEvent event) -> {
                       move_up.getChildren().setAll(images_up[0]);
                  }
          ));

          //TimeLine for move down
          timeline_down.setCycleCount(1);
          timeline_down.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move/3),
                  (ActionEvent event) -> {
                       move_down.getChildren().setAll(images_down[1]);
                  }
          ));
          timeline_down.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move / 3 * 2),
                  (ActionEvent event) -> {
                       move_down.getChildren().setAll(images_down[2]);
                  }
          ));
          timeline_down.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move),
                  (ActionEvent event) -> {
                       move_down.getChildren().setAll(images_down[0]);
                  }
          ));
          //TimeLine for dead
          timeline_dead.setCycleCount(1);
          timeline_dead.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move/3),
                  (ActionEvent event) -> {
                       dead.getChildren().setAll(images_dead[1]);
                  }
          ));
          timeline_dead.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move / 3 * 2),
                  (ActionEvent event) -> {
                       dead.getChildren().setAll(images_dead[2]);
                  }
          ));
          timeline_dead.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move),
                  (ActionEvent event) -> {
                       dead.getChildren().setAll(images_dead[0]);
                  }
          ));
          action.getChildren().add(move_right);
          action.getChildren().add(move_left);
          action.getChildren().add(move_down);
          action.getChildren().add(move_up);
          action.getChildren().add(dead);
          transition.setNode(action);
          transition.setDuration(Duration.millis(time_move));
          transition.setAutoReverse(false);
          action.setTranslateY(SIZE_OF_BOX * y);
          action.setTranslateX(SIZE_OF_BOX * x);
     }
     private boolean CanMove(int x, int y) {
          if(MainGame.map[y][x] == 'p') {
               return true;
          }
          if(MainGame.map[y][x] == '*' || MainGame.map[y][x] == '#' || MainGame.map[y][x] == 'x') {
               return false;
          }
          return true;
     }
}
