package bomberman.gamebomberman;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Pair;

import javax.xml.stream.events.EndDocument;
import java.util.Timer;
import java.util.TimerTask;


public class Balloom extends Enemy {
    public Balloom(){};
    private Boolean canMove = false;
    TranslateTransition transition = new TranslateTransition();
    public Balloom(int posX, int posY) {
        super(posX, posY);
        left[0] = new ImageView(balloom_left1);
        left[1] = new ImageView(balloom_left2);
        left[2] = new ImageView(balloom_left3);
        right[0] = new ImageView(balloom_right1);
        right[1] = new ImageView(balloom_right2);
        right[2] = new ImageView(balloom_right3);
        image_dead = new ImageView(balloom_dead);
        image_dead.setFitWidth(SIZE_OF_BOX);
        image_dead.setFitHeight(SIZE_OF_BOX);
        for(int i = 0; i < 3; i++) {
            left[i].setFitHeight(SIZE_OF_BOX);
            left[i].setFitWidth(SIZE_OF_BOX);
            right[i].setFitHeight(SIZE_OF_BOX);
            right[i].setFitWidth(SIZE_OF_BOX);
        }
        action.getChildren().add(move_right);
        action.getChildren().add(move_left);
        this.SetTimeline();
        timeline_left.play();
        timeline_right.play();
        task = new TimerTask() {
            @Override
            public void run() {
                if(Math.random() > 0.5){
                    makeDirection();
                }
                while (!canMove(x + direction.getKey().intValue()
                        ,y + direction.getValue().intValue())){
                    makeDirection();
                }
                if(direction.equals(new Pair<>(0,1))) {
                    transition = tran_down;
                } else if (direction.equals(new Pair<>(0,-1))) {
                    transition = tran_up;
                } else if (direction.equals(new Pair<>(1,0))) {
                    transition = tran_right;
                } else if (direction.equals(new Pair<>(-1,0))) {
                    transition = tran_left;
                }
                if(!dead && !MainGame.EndGame && transition.getStatus() != Animation.Status.RUNNING) {
                    transition.play();
                    x = x + direction.getKey().intValue();
                    y = y + direction.getValue().intValue();
                }
//                System.out.println(x + " " + y);
            }
        };
    }

    @Override
    protected void makeDirection() {
        randomDirection();
    }
}
