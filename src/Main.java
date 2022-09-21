package com.example.loadmap;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Group root = new Group();
        Scene scene = new Scene(root,  930 ,390);
        stage.setTitle("Map");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void getMap(char[][] map, Group root) throws FileNotFoundException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
