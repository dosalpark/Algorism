import java.util.Arrays;

class Solution {

    int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = createMap(rows, columns);
        for (int i = 0; i < queries.length; i++) {
            answer[i] = move(queries[i]);

        }
        return answer;
    }

    private int[][] createMap(int rows, int columns) {
        int[][] map = new int[rows][columns];
        int num = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                num++;
                map[i][j] = num;
            }
        }
        return map;
    }

    private int move(int[] query) {

        int y1 = query[0] - 1;
        int x1 = query[1] - 1;
        int y2 = query[2] - 1;
        int x2 = query[3] - 1;
        int first = map[y1][x1];
        int min = first;

        for (int i = y1; i < y2; i++) {

            map[i][x1] = map[i + 1][x1];
            min = Math.min(map[i][x1], min);
        }
        for (int i = x1; i < x2; i++) {

            map[y2][i] = map[y2][i + 1];
            min = Math.min(map[y2][i], min);
        }
        for (int i = y2; i > y1; i--) {

            map[i][x2] = map[i - 1][x2];
            min = Math.min(map[i][x2], min);
        }
        for (int i = x2; i > x1; i--) {
            if (i == x1 + 1) {
                map[y1][i] = first;
                continue;
            }
            map[y1][i] = map[y1][i - 1];
            min = Math.min(map[y1][i], min);
        }

        return min;
    }
}
