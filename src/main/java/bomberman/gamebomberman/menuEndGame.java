package bomberman.gamebomberman;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class menuEndGame {
    BorderPane borderPanel = new BorderPane();
    public EventHandler<MouseEvent> handlerNewGame;
    public EventHandler<MouseEvent> handlerContinue;
    Text EndGame;
    Text Score;
    Button NewGame;
    Button Continue;
    HBox hBox = new HBox();

    public void setEndGame(String paht) {
        EndGame.setText(paht);
        EndGame.setTranslateX((borderPanel.getMinWidth() - EndGame.getLayoutBounds().getWidth())/2);
        EndGame.setTranslateY(20);
        Score.setText("Score: " + Integer.toString(MainGame.Scoreingame));
//        Score.setTranslateX((borderPanel.getMinWidth() - Score.getLayoutBounds().getWidth())/2);
//        Score.setTranslateY(100);
    }

    public TranslateTransition transition = new TranslateTransition();
    public menuEndGame(String path) {
        EndGame = new Text(path);
        EndGame.setStyle("-fx-font-family: \"Courier New\";");
        Score = new Text("Score:");
        Score.setStyle("-fx-font-family: \"Courier New\";" +
                "-fx-font-size: 14pt;" +
                "    -fx-text-fill: rgb(49, 89, 23);\n" +
                "    -fx-border-color: rgb(49, 89, 23);\n" +
                "    -fx-border-radius: 5;\n" +
                "    -fx-padding: 3 6 6 6;");
        NewGame = new Button("New Game");
        Continue = new Button("Menu Game");

        NewGame.setStyle("    -fx-text-fill: rgb(49, 89, 23);\n" +
                "    -fx-border-color: rgb(49, 89, 23);\n" +
                "    -fx-border-radius: 5;\n" +
                "    -fx-padding: 3 6 6 6;");
        Continue.setStyle("    -fx-text-fill: rgb(49, 89, 23);\n" +
                "    -fx-border-color: rgb(49, 89, 23);\n" +
                "    -fx-border-radius: 5;\n" +
                "    -fx-padding: 3 6 6 6;");
        hBox.getChildren().addAll(NewGame, Continue);
        hBox.setMargin(NewGame, new Insets(0,20,50,20));
        hBox.setMargin(Continue, new Insets(0,20,50,20));
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        EndGame.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        EndGame.setFill(Color.GREEN);
        borderPanel.setMinSize(450,250);
        borderPanel.setMaxSize(450,250);
        borderPanel.setStyle("    -fx-border-color: rgb(101,136,52);\n" +
                "    -fx-border-style: solid inside;\n" +
                "    -fx-border-width: 3;\n" +
                "    -fx-border-insets: -1;" +
                "    -fx-font-size: 16pt;\n" +
                "    -fx-font-family: \"Courier New\";\n" +
                "    -fx-base: rgb(132, 145, 47);\n" +
                "    -fx-background: rgb(45,51,23);");
        borderPanel.setBackground(Background.fill(Color.rgb(225, 228, 203)));
        borderPanel.setTop(EndGame);
        borderPanel.setCenter(Score);
        borderPanel.setBottom(hBox);
        transition.setDuration(Duration.millis(2000));
        transition.setNode(borderPanel);
        EndGame.setTranslateX((borderPanel.getMaxWidth() - EndGame.getLayoutBounds().getWidth())/2);
        EndGame.setTranslateY(20);
        borderPanel.setTranslateX((MainGame.window_width - borderPanel.getMaxWidth())/2);
        borderPanel.setTranslateY(MainGame.window_height);
        transition.setToX((MainGame.window_width - borderPanel.getMaxWidth())/2);
        transition.setToY((MainGame.window_height - borderPanel.getMaxHeight())/2);
    }
    public void addHandle() {
        NewGame.addEventHandler(MouseEvent.MOUSE_CLICKED,handlerNewGame);
        Continue.addEventHandler(MouseEvent.MOUSE_CLICKED,handlerContinue);
    }
}