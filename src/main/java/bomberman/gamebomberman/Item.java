package bomberman.gamebomberman;

import javafx.scene.image.ImageView;

public class Item extends Entity implements typesItem{
    private nameItem name;

    public nameItem getName() {
        return name;
    }

    public Item(int posX, int posY) {
        this.x = posX;
        this.y = posY;
        if(MainGame.map[x][y] == 's') {
            name = nameItem.SPEED;
        }
        if(MainGame.map[x][y] == 'f') {
            name = nameItem.FLAMES;
        }
        if(MainGame.map[x][y] == 'b') {
            name = nameItem.BOMBS;
        }
        image = item[name.ordinal()];
        image.setFitWidth(SIZE_OF_BOX);
        image.setFitHeight(SIZE_OF_BOX);
        action.getChildren().add(image);
        action.setTranslateX(x * SIZE_OF_BOX);
        action.setTranslateY(y * SIZE_OF_BOX);
    }
}
