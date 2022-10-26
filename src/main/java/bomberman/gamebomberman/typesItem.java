package bomberman.gamebomberman;

import javafx.scene.image.ImageView;

public interface typesItem extends LoadImageWithoutBackground{
    public enum nameItem{
        BOMBPASS,
        BOMBS,
        DETONATOR,
        FLAMEPASS,
        FLAMES,
        SPEED,
        WALLPASS
    }
    ImageView[] item = {new ImageView(powerup_bombpass), new ImageView(powerup_bombs), new ImageView(powerup_detonator)
            , new ImageView(powerup_flamepass), new ImageView(powerup_flames)
            , new ImageView(powerup_speed), new ImageView(powerup_wallpass)};
}
