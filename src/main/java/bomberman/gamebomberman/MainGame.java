package bomberman.gamebomberman;

import com.almasb.fxgl.dev.editor.EntityInspector;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;

import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import javax.net.ssl.HandshakeCompletedEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.*;


import java.util.Timer;
import java.util.stream.Collectors;

enum StateGame {
    DEFAULT,
    MENU_START,
    START_GAME,
    NEXT_LEVEL,
    END_GAME,
    MENU_END,
}

public class MainGame extends Application implements LoadImageWithoutBackground, typesItem {
    public static final int window_height = 14 * Entity.SIZE_OF_BOX;
    public static final int window_width = 31 * Entity.SIZE_OF_BOX;
    private StateGame stateGame = StateGame.DEFAULT;
    private boolean ChangeState = true;
    private int level = 0;
    public static int Scoreingame;
    public static int nums_Monster_inGame;

    public static char[][] map = new char[31][13];
    private String[] path_level = new String[3];
    public static Enemy[] monster;
    public static Entity[][] obstacle;
    public static Item[] itemofGame;
    public static Bomber bomber;
    public static boolean EndGame = false;



    @Override
    public void start(Stage stage) {
        AnimationTimer checkStateGame = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (ChangeState) {
                    if (stateGame == StateGame.START_GAME) {
                        stage.setScene(GameLoop(path_level[level]));
                        Scoreingame = 0;
                    } else if (stateGame == StateGame.DEFAULT) {
                        stage.setScene(MenuStart());
                    } else if (stateGame == StateGame.NEXT_LEVEL) {
                        stage.setScene(GameLoop((path_level[level])));
                    }
                    ChangeState = false;
                }
            }
        };
        checkStateGame.start();
        try {
            List<File> filesMap = Files.walk(Paths.get("D:\\Bomberman\\GameBomberman\\src\\main\\resources\\bomberman\\gamebomberman\\Map"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            for (int i = 0; i < 3; i++) {
                path_level[i] = filesMap.get(i).getPath();
            }
        } catch (IOException e) {

        }
        //Setting title to the Stage
        stage.setTitle("Bomberman");
        //Adding scene to the stage
        stage.show();
    }

    private Scene MenuStart() {
        GridPane gridPane = new GridPane();
        Button playgame = new Button("play game");

        //Setting size for the pane
        gridPane.setMinSize(window_height, window_width);

        //Setting the padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        //Setting the Grid alignment
        gridPane.setAlignment(Pos.BASELINE_CENTER);
        gridPane.add(playgame, 0, 0);
        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stateGame = StateGame.START_GAME;
                ChangeState = true;
            }
        };
        playgame.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        //Setting the background color
        gridPane.setStyle("-fx-background-color: BEIGE;");
        return new Scene(gridPane, window_width, window_height);
    }

    private Scene GameLoop(String path) {
        try {
            map = Map.LoadMap(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        EndGame = false;
        Timer timer = new Timer();
        bomber = new Bomber();
        LoadEntity();
        Group root = new Group();
        Text winGame = new Text("Win game");
        Text loseGame = new Text("Lose Game");
        loseGame.setX((int) (window_width / 2));
        loseGame.setY((int) (window_height / 2));

        ImageView background = new ImageView(grass);
        background.setFitWidth(window_width);
        background.setFitHeight(window_height);
        Wall tuong = new Wall();




        root.getChildren().add(background);
        root.getChildren().add(tuong.image);
        for (int i = 0; i < itemofGame.length; i++) {
            if(!itemofGame[i].dead){
                root.getChildren().add(itemofGame[i].action);
            }
        }
        root.getChildren().add(bomber.action);
        root.getChildren().add(bomber.bombombom);
        for (int i = 0; i < obstacle.length; i++) {
            for (int j = 0; j < obstacle[i].length; j++) {
                if (obstacle[i][j] != null) {
                    root.getChildren().add(obstacle[i][j].action);
                }
            }
        }
        for (int i = 0; i < monster.length; i++) {
            root.getChildren().add(monster[i].action);
            timer.schedule(monster[i].task, 1100, 1100);
        }



        Scene scene = new Scene(root, window_width, window_height);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, bomber.handler);

        Label score = new Label("SCORE");
        Label left = new Label("LEFT");
        Text num_left = new Text(bomber.getNum_life());
        left.setLabelFor(num_left);
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setMargin(left, new Insets(5, 20, 20, 20));
        hBox.setMargin(num_left, new Insets(5, 20, 20, 20));
        ObservableList list = hBox.getChildren();
        list.addAll(left, num_left);
        hBox.setLayoutX(0);
        hBox.setLayoutY(13 * Entity.SIZE_OF_BOX);
        hBox.setFillHeight(true);
        root.getChildren().add(hBox);
        AnimationTimer checkScoreandLeft = new AnimationTimer() {
            @Override
            public void handle(long l) {
                num_left.setText(bomber.getNum_life());
            }
        };
        AnimationTimer checkEndGame = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (bomber.num_life == 0) {
                    scene.removeEventHandler(KeyEvent.KEY_PRESSED, bomber.handler);
                    EndGame = true;
                    if (!root.getChildren().contains(loseGame)) {
                        root.getChildren().add(loseGame);
                    }
                }
                if(nums_Monster_inGame == 0 && map[bomber.getX()][bomber.getY()] == 'x') {
                    if(level == 2) {

                    }
                    else {
                        stateGame = StateGame.NEXT_LEVEL;
                        level++;
                        ChangeState = true;
                    }
                }
            }
        };
        AnimationTimer checkCollideBomber = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (int i = 0; i < monster.length; i++) {
                    if (bomber.Collide_with(monster[i])) {
                        bomber.timeline_dead.play();
                    }
                }
            }
        };
        AnimationTimer checkBomberDead = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (int i = 0; i < obstacle.length; i++) {
                    for (int j = 0; j < obstacle[i].length; j++) {
                        if (obstacle[i][j] == null) {
                            continue;
                        }
                        if (obstacle[i][j].dead) {
                            root.getChildren().remove(obstacle[i][j].action);
                            map[i][j] = ' ';
                            obstacle[i][j] = null;
                        }
                    }
                }
                for (int i = 0; i < monster.length; i++) {
                    if (monster[i].dead) {
                        root.getChildren().remove(monster[i].action);
                    }
                }
                if (bomber.dead) {
                    bomber.action.setTranslateX(Entity.SIZE_OF_BOX);
                    bomber.action.setTranslateY(Entity.SIZE_OF_BOX);
                    bomber.dead = false;
                }
            }
        };
        AnimationTimer checkItem = new AnimationTimer() {
            @Override
            public void handle(long l) {
                for (int i = 0; i < itemofGame.length; i++) {
                    if (bomber.Collide_with(itemofGame[i]) && !itemofGame[i].dead) {
                        bomber.Takeitem(itemofGame[i]);
                        map[itemofGame[i].getX()][itemofGame[i].getY()] = ' ';
                        itemofGame[i].dead = true;
                    }
                }
                for(int i = 0 ; i < itemofGame.length; i ++) {
                    if(root.getChildren().contains(itemofGame[i].action) && itemofGame[i].dead) {
                        root.getChildren().remove(itemofGame[i].action);
                    }
                }
            }
        };
        bomber.updateBomerPos.start();
        checkScoreandLeft.start();
        checkEndGame.start();
        checkCollideBomber.start();
        checkItem.start();
        checkBomberDead.start();
        return scene;
    }

    private void LoadEntity() {
        int numofMonter = 0;
        int numofItem = 0;
        obstacle = new Entity[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '1' || map[i][j] == '2') {
                    numofMonter++;
                }
                if (map[i][j] == '*') {
                    obstacle[i][j] = new Brick(i, j);
                }
                if (map[i][j] == 'b' || map[i][j] == 'f' || map[i][j] == 's') {
                    numofItem++;
                }
                if (map[i][j] == 'x') {
                    obstacle[i][j] = new Portal(i, j);
                }
            }
        }
        nums_Monster_inGame = numofMonter;
        monster = new Enemy[numofMonter];
        itemofGame = new Item[numofItem];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '1') {
                    monster[numofMonter - 1] = new Balloom(i, j);
                    numofMonter--;
                    map[i][j] = ' ';
                }
                if (map[i][j] == '2') {
                    monster[numofMonter - 1] = new Oneal(i, j);
                    numofMonter--;
                    map[i][j] = ' ';
                }
                if (map[i][j] == 'b' || map[i][j] == 'f' || map[i][j] == 's') {
                    obstacle[i][j] = new Brick(i, j);
                    itemofGame[numofItem - 1] = new Item(i, j);
                    map[i][j] = '*';
                    numofItem--;
                }
            }
        }
    }
    private void MenuEndGame(String path) {
        GridPane gridPane = new GridPane();
        Text textEndGame = new Text(path);

    }
    public static void main(String args[]) {
        launch(args);
    }
}