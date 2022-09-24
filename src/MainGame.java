import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.security.Key;
import java.util.concurrent.TransferQueue;
public class MainGame extends Application {
    public static final int window_height = 600;
    public static final int window_width = 600;
    public static final int size_of_box = 50;
    @Override
    public void start(Stage stage) {

    }

    public static void main(String args[]){
        launch(args);
    }
}