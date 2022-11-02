package bomberman.gamebomberman;

import com.almasb.fxgl.dev.editor.EntityInspector;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.util.Pair;

import java.util.*;

public class Bomber extends Entity implements typesItem{
    private int time_move = 400;
    public int startX;
    public int startY;
     private boolean moved = false;
     private int lenghtofBomb = 1;
     public int num_life = 3;
     private ImageView[] images_down = new ImageView[3];
     private ImageView[] images_up = new ImageView[3];
     private ImageView[] images_left = new ImageView[3];
     private ImageView[] images_right = new ImageView[3];
     private ImageView[] images_dead = new ImageView[3];
     public StackPane move_left = new StackPane();
     public StackPane move_right = new StackPane();
     public StackPane move_up = new StackPane();
     public StackPane move_down = new StackPane();
     public StackPane actionDead = new StackPane();
     private Timeline timeline_down = new Timeline();
     private Timeline timeline_up = new Timeline();
     private Timeline timeline_left = new Timeline();
     private Timeline timeline_right = new Timeline();
     public Timeline timeline_dead = new Timeline();
     public Timeline make_bomb = new Timeline();
     public Timeline make_bombs = new Timeline();
     private TranslateTransition transition = new TranslateTransition();
     private TranslateTransition transitionOffice = new TranslateTransition();

     private List<Bomb> bombs = new ArrayList<>();
     private Pair<Integer, Integer> direction;
     private Bomb bombom;
     private Bomb bomboms;
     private boolean moreBomb = false;
     public Group bombombom = new Group();
     public AnimationTimer updateBomerPos = new AnimationTimer() {
         @Override
         public void handle(long l) {
             if(moved) {
                 if(transitionOffice.getStatus() == Animation.Status.STOPPED ) {
                     transitionOffice = transition;
                     transition.play();
                     moved = false;
                     x = x + direction.getKey().intValue();
                     y = y + direction.getValue().intValue();
                 }
             }
         }
     };
     public EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
          @Override
          public void handle(KeyEvent keyEvent) {
              if(timeline_dead.getStatus() != Animation.Status.RUNNING){
                  if (keyEvent.getCode() == KeyCode.SPACE) {
                      if(make_bomb.getStatus() == Animation.Status.RUNNING && moreBomb) {
                          System.out.println(1);
                          make_bombs.play();
                      }
                      make_bomb.play();
                  }
                  if (keyEvent.getCode() == KeyCode.DOWN) {
                      timeline_down.play();
                      action.getChildren().setAll(move_down);
                      transition = tran_down;
                      moved = true;
                      direction = new Pair<>(0, 1);
                  } else if (keyEvent.getCode() == KeyCode.UP) {
                      timeline_up.play();
                      action.getChildren().setAll(move_up);
                      transition = tran_up;
                      moved = true;
                      direction = new Pair<>(0, -1);
                  } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                      timeline_right.play();
                      action.getChildren().setAll(move_right);
                      transition = tran_right;
                      moved = true;
                      direction = new Pair<>(1, 0);
                  } else if (keyEvent.getCode() == KeyCode.LEFT) {
                      timeline_left.play();
                      action.getChildren().setAll(move_left);
                      transition = tran_left;
                      moved = true;
                      direction = new Pair<>(-1, 0);
                  }
                  if (!CanMove()) {
                      moved = false;
                  }
              }
          }
     };
     public Bomber(){
          for(int i = 0; i < MainGame.map.length; i++) {
               for(int j = 0; j < MainGame.map[i].length; j++) {
                    if(MainGame.map[i][j] == 'p') {
                         x = i;
                         y = j;
                         startX = x;
                         startY = y;
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
          action.getChildren().add(images_down[0]);
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
                  Duration.millis(300),
                  (ActionEvent event) -> {
                       actionDead.getChildren().setAll(images_dead[0]);
                  }
          ));
          timeline_dead.getKeyFrames().add(new KeyFrame(
                  Duration.millis(450),
                  (ActionEvent event) -> {
                       actionDead.getChildren().setAll(images_dead[1]);
                  }
          ));
          timeline_dead.getKeyFrames().add(new KeyFrame(
                  Duration.millis(600),
                  (ActionEvent event) -> {
                       actionDead.getChildren().setAll(images_dead[2]);
                  }
          ));
          timeline_dead.getKeyFrames().add(new KeyFrame(
                  Duration.millis(1100),
                  (ActionEvent event) -> {
                      action.getChildren().setAll(images_down[0]);
                      System.out.println(2);
                      if(num_life > 1){
                          action.setTranslateX(startX * SIZE_OF_BOX);
                          action.setTranslateY(startY * SIZE_OF_BOX);
                      }
                       x = this.startX;
                       y = this.startY;
                       num_life--;
                  }
          ));

          //timeline bomb
          make_bomb.setCycleCount(1);
          make_bomb.setAutoReverse(false);
          make_bomb.getKeyFrames().add(new KeyFrame(
                  Duration.millis(0),
                  (ActionEvent event) -> {
                       bombom = new Bomb(this.x, this.y, lenghtofBomb);
                       bombombom.getChildren().add(bombom.action);
                  }
          ));
          make_bomb.getKeyFrames().add(new KeyFrame(
                  Duration.millis(Bomb.TimeBomb_Explore + 100),
                  (ActionEvent event) -> {
                       bombombom.getChildren().remove(bombom.action);
                       bombom = null;
                  }
          ));
          //timeline bombs
          make_bombs.setCycleCount(1);
          make_bombs.setAutoReverse(false);
          make_bombs.getKeyFrames().add(new KeyFrame(
                  Duration.millis(0),
                  (ActionEvent event) -> {
                       bomboms = new Bomb(this.x, this.y, lenghtofBomb);
                       bombombom.getChildren().add(bomboms.action);
                  }
          ));
          make_bombs.getKeyFrames().add(new KeyFrame(
                  Duration.millis(Bomb.TimeBomb_Explore + 100),
                  (ActionEvent event) -> {
                       bombombom.getChildren().remove(bomboms.action);
                       bomboms = null;
                  }
          ));
          tran_right.setDuration(Duration.millis(time_move));
          tran_up.setDuration(Duration.millis(time_move));
          tran_left.setDuration(Duration.millis(time_move));
          tran_down.setDuration(Duration.millis(time_move));
          action.getChildren().add(move_right);
          action.getChildren().add(move_left);
          action.getChildren().add(move_down);
          action.getChildren().add(move_up);
          action.getChildren().add(actionDead);
          transition.setNode(action);
          transition.setDuration(Duration.millis(time_move));
          transition.setAutoReverse(false);
          action.setTranslateY(SIZE_OF_BOX * y);
          action.setTranslateX(SIZE_OF_BOX * x);
     }
     private boolean CanMove() {
             int newX = this.x + direction.getKey().intValue();
             int newY = this.y + direction.getValue().intValue();
            if(MainGame.map[newX][newY] == 'p'
                    || MainGame.map[newX][newY] == '1'
                    || MainGame.map[newX][newY] == '2'
                    || MainGame.map[newX][newY] == ' ') {
               return true;
            }
            if(MainGame.nums_Monster_inGame == 0 && MainGame.map[newX][newY] == 'x') {
                return true;
            }
            return false;
     }

     public void ChangeSpeed () {
          time_move = 300;
          timeline_down.getKeyFrames().removeAll();
          timeline_up.getKeyFrames().removeAll();
          timeline_left.getKeyFrames().removeAll();
          timeline_right.getKeyFrames().removeAll();
          //TimeLine for move left
          timeline_left.setCycleCount(1);
          timeline_left.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move / 3),
                  (ActionEvent event) -> {
                       move_left.getChildren().setAll(images_left[0]);
                  }
          ));
          timeline_left.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move / 3 * 2),
                  (ActionEvent event) -> {
                       move_left.getChildren().setAll(images_left[1]);
                  }
          ));
          timeline_left.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move),
                  (ActionEvent event) -> {
                       move_left.getChildren().setAll(images_left[2]);
                  }
          ));
          //TimeLine for move right
          timeline_right.setCycleCount(1);
          timeline_right.getKeyFrames().add(new KeyFrame(
                  Duration.millis(time_move/3),
                  (ActionEvent event) -> {
                       move_right.getChildren().setAll(images_right[0]);
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
          tran_down.setDuration(Duration.millis(time_move));
          tran_up.setDuration(Duration.millis(time_move));
          tran_left.setDuration(Duration.millis(time_move));
          tran_right.setDuration(Duration.millis(time_move));

     }
     public void playActionDead() {
         MainGame.sound.playSingleEp(2);
         action.getChildren().setAll(actionDead);
         timeline_dead.play();
     }
     public void ChangeLenghtofBomb (int lenght) {
         lenghtofBomb = lenght;
     }
     public void Takeitem(Item item) {
         if(item.getName() == nameItem.SPEED) {
             MainGame.sound.playSingleEp(6);
             this.ChangeSpeed();
         }
         else if(item.getName() == nameItem.FLAMES) {
             MainGame.sound.playSingleEp(6);
             this.ChangeLenghtofBomb(2);
         }
         else if(item.getName() == nameItem.BOMBS) {
             MainGame.sound.playSingleEp(6);
             moreBomb = true;
         }
     }

    public String getNum_life() {
        return Integer.toString(num_life);
    }
}
