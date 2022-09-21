package com.example.loadmap;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LoadMap extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Group root = new Group();
        //Grass
        Image grass = new Image(getClass().getResourceAsStream("Image/grass.png"));
        //Brick
        Image brick = new Image(getClass().getResourceAsStream("Image/brick.png"));
        //Wall
        Image wall = new Image(getClass().getResourceAsStream("Image/wall.png"));
        //Portal
        Image portal = new Image(getClass().getResourceAsStream("Image/portal.png"));

        Map map = new Map("Map/Level1.txt");
        getMap(map.getMap(), root);

        Scene scene = new Scene(root,  930 ,390);

        stage.setTitle("Map");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void getMap(char[][] map, Group root) throws FileNotFoundException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                getImage(map[i][j], (double) j * 30, (double) i * 30, root);
            }
        }
    }

    public void getImage(char symbol, double x, double y, Group root) throws FileNotFoundException {
        String path = "";
        if (symbol == '#') {
            path = "Image/wall.png";
        } else if (symbol == '*') {
            path = "Image/brick.png";
        } else if (symbol == 'x') {
            path = "Image/portal.png";
        } else if (symbol == ' ') {
            path = "Image/grass.png";
        } else if (symbol == 'f') {
            path = "Image/powerup_bombs.png";
        } else if (symbol == 'p') {
            path = "Image/player_left.png";
        } else if (symbol == '1') {
            path = "Image/balloom_dead.png";
        } else if (symbol == '2') {
            path = "Image/doll_dead.png";
        }
        Image image = new Image(getClass().getResourceAsStream(path));
        ImageView imageView = new ImageView(image);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        imageView.setPreserveRatio(true);
        root.getChildren().add(imageView);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
