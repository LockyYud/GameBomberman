package bomberman.gamebomberman;
import com.almasb.fxgl.dev.editor.EntityInspector;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;

import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.text.BreakIterator;
import java.util.*;


import java.util.Timer;
public class MainGame extends Application implements LoadImageWithoutBackground{
    public static final int window_height = 13 * Entity.SIZE_OF_BOX;
    public static final int window_width = 31 * Entity.SIZE_OF_BOX;

    public static char[][] map = new char[31][13];
    public static Enemy[] monster;
    public static Entity[][] obstacle;
    public static Bomber bomber;
    private static Group root = new Group();
    public Timer timer = new Timer();
    AnimationTimer checkDead = new AnimationTimer() {
        @Override
        public void handle(long l) {
            for(int i = 0 ; i < obstacle.length; i++) {
                for(int j = 0; j < obstacle[i].length; j++) {
                    if(obstacle[i][j] == null) {
                        continue;
                    }
                    if(obstacle[i][j].dead) {
                        root.getChildren().remove(obstacle[i][j].action);
                        map[i][j] = ' ';
                        obstacle[i][j] = null;
                    }
                }
            }
            for(int i = 0; i < monster.length; i++) {
                if(monster[i].dead) {
                    root.getChildren().remove(monster[i].action);
                }
            }
            if(bomber.dead) {
                bomber.action.setTranslateX(Entity.SIZE_OF_BOX);
                bomber.action.setTranslateY(Entity.SIZE_OF_BOX);
                bomber.dead = false;
            }
        }
    };
    @Override
    public void start(Stage stage) {
        ImageView background = new ImageView(grass);
        background.setFitWidth(window_width);
        background.setFitHeight(window_height);
        root.getChildren().add(background);
        String path = "D:\\Bomberman\\GameBomberman\\src\\main\\resources\\bomberman\\gamebomberman\\Map\\level1.txt";
        try{
            Map.LoadMap(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Wall tuong = new Wall();
        root.getChildren().add(tuong.image);
        bomber = new Bomber();
        root.getChildren().add(bomber.action);
        LoadEntity();
        for(int i = 0; i < obstacle.length; i++) {
            for (int j = 0; j < obstacle[i].length; j++) {
                if(obstacle[i][j] != null) {
                    root.getChildren().add(obstacle[i][j].action);
                }
            }
        }
        for(int i = 0; i < monster.length; i++) {
            root.getChildren().add(monster[i].action);
            timer.schedule(monster[i].task,1000,1000);
        }

        //Creating a scene object
        Scene scene = new Scene(root, window_width, window_height);
        //Setting title to the Stage
        stage.setTitle("Bomberman");
        scene.addEventHandler(KeyEvent.KEY_PRESSED, bomber.handler);
        //Adding scene to the stage
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
        root.getChildren().add(bomber.bombombom);
        checkDead.start();
        bomber.updateBomerPos.start();
    }
    private void LoadEntity () {
        int numofMonter = 0;
        obstacle = new Entity[map.length][map[0].length];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == '1' || map[i][j] == '2') {
                    numofMonter++;
                }
                if(map[i][j] == '*') {
                    obstacle[i][j] = new Brick(i,j);
                }
                if(map[i][j] == 'x') {
                    obstacle[i][j] = new Portal(i,j);
                }
            }
        }
        monster = new Enemy[numofMonter];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == '1') {
                    monster[numofMonter - 1] = new Balloom(i,j);
                    numofMonter--;
                }
                if(map[i][j] == '2') {
                    monster[numofMonter - 1] = new Oneal(i,j);
                    numofMonter--;
                }
            }
        }
    }
    public static void main(String args[]){
        launch(args);
    }
}