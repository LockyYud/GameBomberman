package bomberman.gamebomberman;
import com.almasb.fxgl.dev.editor.EntityInspector;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
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
    public static final int window_height = 31 * Entity.SIZE_OF_BOX;
    public static final int window_width = 13 * Entity.SIZE_OF_BOX;

    public static char[][] map = new char[13][31];
    private List<Enemy> monster = new ArrayList<>();
    private List<Entity> obstacle = new ArrayList<>();
    private static Group root = new Group();
    public Timer timer = new Timer();
    @Override
    public void start(Stage stage) {
        ImageView background = new ImageView(grass);
        background.setFitWidth(window_height);
        background.setFitHeight(window_width);
        root.getChildren().add(background);
        String path = "D:\\Bomberman\\GameBomberman\\src\\main\\resources\\bomberman\\gamebomberman\\Map\\level1.txt";
        try{
            Map.LoadMap(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Wall tuong = new Wall();
        root.getChildren().add(tuong.image);
        Bomber bomber = new Bomber();
        root.getChildren().add(bomber.action);
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == '*') obstacle.add(new Brick(j,i));
                if(map[i][j] == 'x') obstacle.add(new Portal(j,i));
                if(map[i][j] == '1') monster.add(new Balloom(j,i));
                if(map[i][j] == '2') monster.add(new Oneal(j,i));
            }
        }
        for(Enemy element : monster) {
            root.getChildren().add(element.action);
            timer.schedule(element.task,1000,1000);
        }
        for(Entity element : obstacle) {
            root.getChildren().add(element.action);
        }
        AnimationTimer okeoke = new AnimationTimer() {
            @Override
            public void handle(long l) {

            }
        };
        //Creating a scene object
        Scene scene = new Scene(root, window_height, window_width);
        //Setting title to the Stage
        stage.setTitle("Writing pixels ");
        scene.addEventHandler(KeyEvent.KEY_PRESSED, bomber.handler);
        //Adding scene to the stage
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
//        okeoke.start();


//        Bomb bomb1 = new Bomb(7,1,1);
//        Scene scene = new Scene(new Group(bomb1.action), window_height, window_width);
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}