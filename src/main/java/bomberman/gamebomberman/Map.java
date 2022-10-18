package bomberman.gamebomberman;

import java.io.*;
import java.util.Scanner;

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
        scan.nextLine();

        char[][] temp = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = scan.nextLine();
            char[] col = row.toCharArray();
            for (int j = 0; j < C; j++) {
                temp[i][j] = col[j];
            }
        }

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                MainGame.map[i][j] = temp[j][i];
            }
        }
    }
}
