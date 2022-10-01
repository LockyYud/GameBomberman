package bomberman.gamebomberman;

import java.util.Scanner;

public class Map {
    char[][] map;

    public Map(String _path) {
        Scanner scan = new Scanner(getClass().getResourceAsStream(_path));

        int L = scan.nextInt();
        int R = scan.nextInt();
        int C = scan.nextInt();
        String get = scan.nextLine();

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = scan.nextLine();
            char[] col = row.toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = col[j];
            }
        }
    }

    public char[][] getMap() {
        return map;
    }
}
