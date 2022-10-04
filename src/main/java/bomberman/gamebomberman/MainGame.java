package bomberman.gamebomberman;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class MainGame extends Application implements LoadImage{
    public static final int window_height = 600;
    public static final int window_width = 600;
    int i = 0;
    static int x = 50;
    static int y = 50;
    @Override
    public void start(Stage stage) {
        Bomber player = new Bomber();
        Group allMove = new Group(player.move);
        Balloom balloom = new Balloom(0, 0);
        allMove.getChildren().add(balloom.move);
        Entity grassE = new Grass(5, 3);
        allMove.getChildren().add(grassE.move);
        Scene scene = new Scene(allMove, 600 , 600);
        scene.addEventHandler(KeyEvent.KEY_PRESSED ,player.handler);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}