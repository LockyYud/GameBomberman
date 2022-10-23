package bomberman.gamebomberman;

import javafx.scene.image.ImageView;

public class Item extends Entity {
    private ImageView[] item = new ImageView[7];

    private void construct() {
        item[0] = new ImageView(powerup_bombs);
        item[1] = new ImageView(powerup_flames);
        item[2] = new ImageView(powerup_speed);
        item[3] = new ImageView(powerup_flamepass);
        item[4] = new ImageView(powerup_bombpass);
        item[5] = new ImageView(powerup_detonator);
        item[6] = new ImageView(powerup_wallpass);
    }

    public Item(int x, int y, int i) {
        super(x, y);
        construct();
        item[i].setX(this.x);
        item[i].setY(this.y);
        item[i].setFitWidth(SIZE_OF_BOX);
        item[i].setFitHeight(SIZE_OF_BOX);
        action.getChildren().add(item[i]);
    }

    public static void pickedItem(int x, int y) {
        MainGame.items[x][y].getAction().getChildren().setAll();
    }
}
