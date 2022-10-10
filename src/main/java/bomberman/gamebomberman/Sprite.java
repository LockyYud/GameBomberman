package bomberman.gamebomberman;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class Sprite {
    public static final int TRANSPARENT_COLOR = 0xffff00ff;

    public static Image makeTransparent(Image inputImage) {
        int W = (int) inputImage.getWidth();
        int H = (int) inputImage.getHeight();
        WritableImage outputImage = new WritableImage(W, H);
        PixelReader reader = inputImage.getPixelReader();
        PixelWriter writer = outputImage.getPixelWriter();
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                int argb = reader.getArgb(x, y);

                if (argb == TRANSPARENT_COLOR) {
                    writer.setArgb(x, y, 0);
                } else {
                    writer.setArgb(x, y, argb);
                }
            }
        }
        return outputImage;
    }
}
