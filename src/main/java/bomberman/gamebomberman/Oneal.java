package bomberman.gamebomberman;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

import java.util.Timer;
import java.util.TimerTask;

public class Oneal extends Enemy implements LoadImageWithoutBackground{
    public Oneal(){}
    private Pair<Integer, Integer> direction = new Pair<>(1,0);
    private Boolean canMove = false;
    TranslateTransition transition = new TranslateTransition();
    public Oneal (int posX,int posY) {
        super(posX,posY);
        left[0] = new ImageView(oneal_left1);
        left[1] = new ImageView(oneal_left2);
        left[2] = new ImageView(oneal_left3);
        right[0] = new ImageView(oneal_right1);
        right[1] = new ImageView(oneal_right2);
        right[2] = new ImageView(oneal_right3);
        for(int i = 0; i < 3; i++) {
            left[i].setFitWidth(SIZE_OF_BOX);
            left[i].setFitHeight(SIZE_OF_BOX);
            right[i].setFitWidth(SIZE_OF_BOX);
            right[i].setFitHeight(SIZE_OF_BOX);
        }
        this.SetTimeline();
        action.getChildren().add(move_left);
        action.getChildren().add(move_right);
        timeline_left.play();
        task = new TimerTask() {
            @Override
            public void run() {
                if(MainGame.map[y + direction.getValue().intValue()][x + direction.getKey().intValue()] != ' ') {
                    canMove = false;
                }
                if(canMove){
                    transition.play();
                    x = x + direction.getKey().intValue();
                    y = y + direction.getValue().intValue();
                } else {
                    canMove = true;
                    makeDirection();
                    if(direction.equals(new Pair<>(0,1))) {
                        transition = tran_down;
                    } else if (direction.equals(new Pair<>(0,-1))) {
                        transition = tran_up;
                    } else if (direction.equals(new Pair<>(1,0))) {
                        transition = tran_right;
                    } else if (direction.equals(new Pair<>(-1,0))) {
                        transition = tran_left;
                    }
                }
            }
        };
    }

    @Override
    protected void makeDirection() {
        randomDirection();
    }
}
