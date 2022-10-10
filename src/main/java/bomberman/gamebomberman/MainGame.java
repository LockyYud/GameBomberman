package bomberman.gamebomberman;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

import java.io.FileInputStream;
import java.util.Timer;

public class MainGame extends Application implements LoadImage{
    public static final int window_height = 600;
    public static final int window_width = 600;
    public static char[][] map = new char[8][8];
    @Override
    public void start(Stage stage) {
        Bomber bomber = new Bomber();
        //Creating a Group object
        Balloom balloom = new Balloom(5,5);
        Group root = new Group(bomber.move);
        root.getChildren().add(balloom.move);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 500);
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

    public static void main(String args[]){
        launch(args);
    }
}