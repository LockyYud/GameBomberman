package bomberman.gamebomberman;

import javafx.scene.image.ImageView;

public class Wall extends Entity {
    public Wall(int x, int y) {
        super(x, y);
        image = new ImageView(wall);
        image.setX(this.x);
        image.setY(this.y);
        image.setFitWidth(SIZE_OF_BOX);
        image.setFitWidth(SIZE_OF_BOX);
        move.getChildren().add(image);
    }
}
