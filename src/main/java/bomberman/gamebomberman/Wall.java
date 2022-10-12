package bomberman.gamebomberman;

import javafx.scene.image.ImageView;

public class Wall extends Entity {
    public Wall(int x, int y) {
        super(x, y);
        image = new ImageView(wall);
        image.setX(this.x);
        image.setY(this.y);
        image.setFitWidth(SIZE_OF_BOX);
        image.setFitHeight(SIZE_OF_BOX);
        action.getChildren().add(image);
    }
}
