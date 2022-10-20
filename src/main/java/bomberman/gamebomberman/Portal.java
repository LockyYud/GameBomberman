package bomberman.gamebomberman;

import javafx.scene.image.ImageView;

public class Portal extends Entity {
    public Portal(int x, int y) {
        super(x,y);
        image = new ImageView(portal);
//        image.setX(this.x);
//        image.setY(this.y);
        image.setFitWidth(SIZE_OF_BOX);
        image.setFitHeight(SIZE_OF_BOX);
        action.getChildren().add(image);
    }
}
