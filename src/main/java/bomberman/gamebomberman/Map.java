package bomberman.gamebomberman;

import java.io.*;
import java.util.Scanner;

<<<<<<< HEAD
public abstract class Map {
    public static void LoadMap(String path) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            Scanner scanner = new Scanner(fileInputStream);
            int L, R, C;
            L = scanner.nextInt();
            R = scanner.nextInt();
            C = scanner.nextInt();
            MainGame.map = new char[R][C];
            String okeoke = scanner.nextLine();
            for (int i = 0; i < R; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < C; j++) {
                    MainGame.map[i][j] = line.charAt(j);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
=======
public class Map {
    private String path;

    public Map(String path) {
        this.path = path;
    }

    public void LoadMap() {
        Scanner scan = new Scanner(getClass().getResourceAsStream(path));

        int L = scan.nextInt();
        int R = scan.nextInt();
        int C = scan.nextInt();
        String get = scan.nextLine();

        MainGame.map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = scan.nextLine();
            char[] col = row.toCharArray();
            for (int j = 0; j < C; j++) {
                MainGame.map[i][j] = col[j];
            }
        }

>>>>>>> parent of 8da81cb (Recode Bomb)
    }
}
