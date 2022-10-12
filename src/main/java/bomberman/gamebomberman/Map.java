package bomberman.gamebomberman;

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
        String get = scan.nextLine();

        MainGame.map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = scan.nextLine();
            char[] col = row.toCharArray();
            for (int j = 0; j < C; j++) {
                MainGame.map[i][j] = col[j];
            }
        }

    }
}
