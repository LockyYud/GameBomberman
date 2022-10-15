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
    public static Entity[][] entities_on = new Entity[WINDOW_WIDTH][WINDOW_HEIGHT];
    public static Entity[][] entities_under = new Entity[WINDOW_WIDTH][WINDOW_HEIGHT];
    private static Group root = new Group();

    @Override
    public void start(Stage stage) {
        Bomber bomber = new Bomber();
        //Creating a Group object
        Balloom balloom = new Balloom(5,5);
        setMap();
        root.getChildren().add(bomber.getAction());
        root.getChildren().add(balloom.getAction());
        bomber.getAction().toFront();
        Entity bomb = new Bomb(3, 9, 2);
        entities_on[3][9] = bomb;
        render();
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
        for (int i = 0; i < WINDOW_WIDTH; i++) {
            for (int j = 0; j < WINDOW_HEIGHT; j++) {
                Entity grass = new Grass(i, j);
                entities_under[i][j] = grass;
                if (map[i][j] == '#') {
                    Entity wall = new Wall(i, j);
                    entities_on[i][j] = wall;
                } else if (map[i][j] == '*') {
                    Entity brick = new Brick(i, j);
                    entities_on[i][j] = brick;
                }
            }
        }
    }

    public static void main(String args[]){
        launch(args);
    }

    private static void render() {
        for (int i = 0; i < WINDOW_WIDTH; i++) {
            for (int j = 0; j < WINDOW_HEIGHT; j++) {
                root.getChildren().add(entities_under[i][j].getAction());
            }
        }
        for (int i = 0; i < WINDOW_WIDTH; i++) {
            for (int j = 0; j < WINDOW_HEIGHT; j++) {
                if (entities_on[i][j] != null) {
                    root.getChildren().add(entities_on[i][j].getAction());
                }
            }
        }
    }

    public static void setBrickExplode(int x, int y) {
        if (entities_on[x][y] instanceof Brick) {
            ((Brick) entities_on[x][y]).explode();
            entities_on[x][y] = null;
            map[x][y] = ' ';
        }
    }
}