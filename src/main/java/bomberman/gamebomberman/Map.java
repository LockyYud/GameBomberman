package bomberman.gamebomberman;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Map {
    public static char[][] LoadMap(String path) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            char[][] mapLoad;
            fileInputStream = new FileInputStream(path);
            Scanner scanner = new Scanner(fileInputStream);
            int L, R, C;
            L = scanner.nextInt();
            R = scanner.nextInt();
            C = scanner.nextInt();
            mapLoad = new char[C][R];
            String okeoke = scanner.nextLine();
            for (int i = 0; i < R; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < C; j++) {
                    mapLoad[j][i] = line.charAt(j);
                }
            }
            return mapLoad;
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
        return null;
    }
}
