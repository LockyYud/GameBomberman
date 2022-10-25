package bomberman.gamebomberman;

import java.io.*;
import java.util.Scanner;

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
            MainGame.map = new char[C][R];
            String okeoke = scanner.nextLine();
            for (int i = 0; i < R; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < C; j++) {
                    MainGame.map[j][i] = line.charAt(j);
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
    }
}
