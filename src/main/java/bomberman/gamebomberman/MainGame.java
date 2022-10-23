package bomberman.gamebomberman;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGame extends Application implements LoadImageWithoutBackground{
    public static final int WINDOW_WIDTH = 31;
    public static final int WINDOW_HEIGHT = 13;

    public static char[][] map = new char[WINDOW_WIDTH][WINDOW_HEIGHT];
    public static char[][] item_pos = new char[WINDOW_WIDTH][WINDOW_HEIGHT];
    public static Entity[][] entities_on = new Entity[WINDOW_WIDTH][WINDOW_HEIGHT];
    public static Entity[][] entities_under = new Entity[WINDOW_WIDTH][WINDOW_HEIGHT];
    public static Entity[][] items = new Entity[WINDOW_WIDTH][WINDOW_HEIGHT];
    private static Group root = new Group();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        //Creating a Group object
//        setMap();
//        render();
        Balloom balloom = new Balloom(5, 5);
        Entity bomb = new Bomb(9, 1, 3);
        entities_on[9][1] = bomb;
        setMap();
        render();
        balloom.action.toFront();
        //Creating a scene object
        Scene scene = new Scene(root, WINDOW_WIDTH * Entity.SIZE_OF_BOX,
                WINDOW_HEIGHT * Entity.SIZE_OF_BOX);
        //Setting title to the Stage
        stage.setTitle("Writing pixels ");

        //Adding scene to the stage
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
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
                } else if (map[i][j] == 'b') {
                    Entity brick = new Brick(i, j);
                    entities_on[i][j] = brick;
                    Entity item = new Item(i, j, 0);
                    items[i][j] = item;
                    item_pos[i][j] = 'b';
                    map[i][j] = '*';
                } else if (map[i][j] == 'f') {
                    Entity brick = new Brick(i, j);
                    entities_on[i][j] = brick;
                    Entity item = new Item(i, j, 1);
                    items[i][j] = item;
                    item_pos[i][j] = 'f';
                    map[i][j] = '*';
                } else if (map[i][j] == 's') {
                    Entity brick = new Brick(i, j);
                    entities_on[i][j] = brick;
                    Entity item = new Item(i, j, 2);
                    items[i][j] = item;
                    item_pos[i][j] = 's';
                    map[i][j] = '*';
                }
            }
        }
    }

    private static void render() {
        for (int i = 0; i < WINDOW_WIDTH; i++) {
            for (int j = 0; j < WINDOW_HEIGHT; j++) {
                root.getChildren().add(entities_under[i][j].getAction());
            }
        }
        for (int i = 0; i < WINDOW_WIDTH; i++) {
            for (int j = 0; j < WINDOW_HEIGHT; j++) {
                if (items[i][j] != null) {
                    root.getChildren().add(items[i][j].getAction());
                }
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
}