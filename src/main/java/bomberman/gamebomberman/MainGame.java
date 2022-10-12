package bomberman.gamebomberman;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class MainGame extends Application {
    public static final int WINDOW_HEIGHT = 13;
    public static final int WINDOW_WIDTH = 31;
    public static char[][] map = new char[WINDOW_WIDTH][WINDOW_HEIGHT];
    private static List<Entity> entities = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Bomber bomber = new Bomber();
        //Creating a Group object
        Balloom balloom = new Balloom(5,5);
        setMap();
        Group root = new Group(bomber.getAction());
        root.getChildren().add(balloom.getAction());
        for (Entity i : entities) {
            root.getChildren().add(i.getAction());
        }
        bomber.action.toFront();
        balloom.action.toFront();

        //Creating a scene object
        Scene scene = new Scene(root, WINDOW_WIDTH * Entity.SIZE_OF_BOX,
                WINDOW_HEIGHT * Entity.SIZE_OF_BOX);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, bomber.handler);
        //Setting title to the Stage
        stage.setTitle("Writing pixels ");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
        Timer timer = new Timer();
        timer.schedule(balloom.timer,5000,1000);
    }

    public static void setMap() {
        String path = "/bomberman/gamebomberman/level/Level1.txt";
        Map nMap = new Map(path);
        nMap.LoadMap();
        for (int i = 0; i < WINDOW_HEIGHT; i++) {
            for (int j = 0; j < WINDOW_WIDTH; j++) {
                Entity grass = new Grass(j, i);
                entities.add(grass);
                if (map[i][j] == '#') {
                    Entity wall = new Wall(j, i);
                    entities.add(wall);
                } else if (map[i][j] == '*') {
                    Entity brick = new Brick(j, i);
                    entities.add(brick);
                }
            }
        }
    }

    public static void main(String args[]){
        launch(args);
    }
}