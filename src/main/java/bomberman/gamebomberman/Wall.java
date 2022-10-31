package bomberman.gamebomberman;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Wall extends Entity {
    public Wall(int x, int y) {
        action.setTranslateX(x * SIZE_OF_BOX);
        action.setTranslateY(y * SIZE_OF_BOX);
        image = new ImageView(wall);
        image.setX(this.x);
        image.setY(this.y);
        image.setFitWidth(SIZE_OF_BOX);
        image.setFitHeight(SIZE_OF_BOX);
        action.getChildren().add(image);
    }
    public Wall() {
        String path = "C:\\Users\\Cevenn\\Documents\\GitHub\\GameBomberman\\src\\main\\resources\\bomberman\\gamebomberman\\Map\\level1.txt";
        try{
            Map.LoadMap(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bomber bomber = new Bomber();
        int width = (int) wall.getWidth();
        int height = (int) wall.getHeight();
        WritableImage wImage = new WritableImage(MainGame.window_width, MainGame.window_height);
        PixelReader reader = wall.getPixelReader();
        PixelWriter writer = wImage.getPixelWriter();
        for(int i = 0; i < MainGame.map.length; i++) {
            for (int j = 0; j < MainGame.map[i].length; j++) {
                if(MainGame.map[i][j] == '#') {
                    for(int m = 0; m < width; m++) {
                        for(int n = 0; n < height; n++) {
                            Color color = reader.getColor(m,n);
                            for(int k = 0; k < 2; k++){
                                for(int a = 0; a < 2; a++) {
                                    writer.setColor(i * Entity.SIZE_OF_BOX + m * 2 + k
                                            ,  j * Entity.SIZE_OF_BOX + n * 2 + a,color);
                                }
                            }
                        }
                    }
                }
            }
        }
        image = new ImageView(wImage);
    }
}
