package bomberman.gamebomberman;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

public abstract class otherMenu {
    protected Group group = new Group();
    public EventHandler<MouseEvent> handler;
}
class menuEndGame extends otherMenu{

}