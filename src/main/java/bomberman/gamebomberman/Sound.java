//package bomberman.gamebomberman;
//
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import java.net.URL;
//
////import static bomberman.gamebomberman.MainGame.sound;
//
//public class Sound {
//    Clip clip;
//    URL[] soundURL = new URL[7];
//
//    public Sound() {
//        soundURL[0] = getClass().getResource("/bomberman/gamebomberman/sound/bomb.wav");
//        soundURL[1] = getClass().getResource("/bomberman/gamebomberman/sound/clear.wav");
//        soundURL[2] = getClass().getResource("/bomberman/gamebomberman/sound/player_dead.wav");
//        soundURL[3] = getClass().getResource("/bomberman/gamebomberman/sound/enemy_dead.wav");
//        soundURL[4] = getClass().getResource("/bomberman/gamebomberman/sound/background.wav");
//        soundURL[5] = getClass().getResource("/bomberman/gamebomberman/sound/intro.wav");
//        soundURL[6] = getClass().getResource("/bomberman/gamebomberman/sound/pick.wav");
//    }
//
//    public void setSoundURL(int i) {
//        try {
//            AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundURL[i]);
//            clip = AudioSystem.getClip();
//            clip.open(inputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void play() {
//        clip.start();
//    }
//
//    public void loop() {
//        clip.loop(Clip.LOOP_CONTINUOUSLY);
//    }
//
//    public void stop() {
//        clip.stop();
//    }
//
//    public void playMusic(int i) {
//        sound.setSoundURL(i);
//        sound.play();
//        sound.loop();
//    }
//
//    public void stopMusic() {
//        sound.stop();
//    }
//
//    public void playSingleEp(int i) {
//        sound.setSoundURL(i);
//        sound.play();
//    }
//}
