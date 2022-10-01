package bomberman.gamebomberman;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.Key;
import java.util.concurrent.TransferQueue;
public class MainGame extends Application implements LoadImage{
    public static final int window_height = 600;
    public static final int window_width = 600;
    int i = 0;
    static int x = 50;
    static int y = 50;
    @Override
    public void start(Stage stage) {
        Bomer player = new Bomer();
        Scene scene = new Scene(player.move, 600 , 600);
        scene.addEventHandler(KeyEvent.KEY_PRESSED ,player.handler);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]){
        launch(args);
    }
}