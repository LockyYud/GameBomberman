package bomberman.gamebomberman;
import javafx.application.Application;
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

import java.util.*;


import java.util.Timer;
public class MainGame extends Application implements LoadImageWithoutBackground{
    public static final int window_height = 31 * Entity.SIZE_OF_BOX;
    public static final int window_width = 13 * Entity.SIZE_OF_BOX;

<<<<<<< HEAD
    public static char[][] map = new char[window_width][window_height];
    public static Entity[][] entities_on = new Entity[window_width][window_height];
    public static Entity[][] entities_under = new Entity[window_width][window_height];
    private static Group root = new Group();
=======

public class MainGame extends Application {
    public static final int WINDOW_HEIGHT = 13;
    public static final int WINDOW_WIDTH = 31;
    public static char[][] map = new char[WINDOW_WIDTH][WINDOW_HEIGHT];
    private static List<Entity> entities = new ArrayList<>();
>>>>>>> parent of 8da81cb (Recode Bomb)

    @Override
    public void start(Stage stage) {
        String path = "D:\\Bomberman\\GameBomberman\\src\\main\\resources\\bomberman\\gamebomberman\\Map\\level1.txt";
        try{
            Map.LoadMap(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = (int) wall.getWidth();
        int height = (int) wall.getHeight();
        WritableImage wImage = new WritableImage(window_height, window_width);
        PixelReader reader = wall.getPixelReader();
        PixelWriter writer = wImage.getPixelWriter();
        for(int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == '#') {
                    for(int m = 0; m < width; m++) {
                        for(int n = 0; n < height; n++) {
                            Color color = reader.getColor(m,n);
                            for(int k = 0; k < 2; k++){
                                for(int a = 0; a < 2; a++) {
                                    writer.setColor(j * Entity.SIZE_OF_BOX + m * 2 + k,  i * Entity.SIZE_OF_BOX + n * 2 + a,color);
                                }
                            }
                        }
                    }
                }
            }
        }
        ImageView imageView = new ImageView(wImage);
        Group root = new Group(imageView);
        //Creating a Group object
<<<<<<< HEAD
//        setMap();
//        render();
=======
        Balloom balloom = new Balloom(5,5);
        setMap();
        Group root = new Group(bomber.getAction());
        root.getChildren().add(balloom.getAction());
        for (Entity i : entities) {
            root.getChildren().add(i.getAction());
        }
        bomber.action.toFront();
        balloom.action.toFront();

>>>>>>> parent of 8da81cb (Recode Bomb)
        //Creating a scene object
        Scene scene = new Scene(root, window_width * Entity.SIZE_OF_BOX,
                window_height * Entity.SIZE_OF_BOX);
        //Setting title to the Stage
        stage.setTitle("Writing pixels ");

        //Adding scene to the stage
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();

<<<<<<< HEAD
=======
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
>>>>>>> parent of 8da81cb (Recode Bomb)
    }

    public static void main(String args[]){
        launch(args);
    }
}