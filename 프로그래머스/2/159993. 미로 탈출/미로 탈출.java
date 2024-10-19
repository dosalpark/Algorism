import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    String[] maps;

    public int solution(String[] maps) {
        this.maps = maps;
        int[] start = new int[]{0, 0};
        int[] check = new int[]{0, 0};
        int[] end = new int[]{0, 0};

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char ch = maps[i].charAt(j);
                if (ch == 'S') {
                    start = new int[]{i, j};
                }
                if (ch == 'L') {
                    check = new int[]{i, j};
                }
                if (ch == 'E') {
                    end = new int[]{i, j};
                }
            }
        }
        int checkCount = go(new int[]{start[0], start[1]}, check);
        int endCount = go(new int[]{check[0], check[1]}, end);

        return (checkCount == -1 || endCount == -1) ? -1 : checkCount + endCount;
    }

    private int go(int[] now, int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()];

        queue.add(new int[]{now[0], now[1], 0});
        visit[now[0]][now[1]] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int count = cur[2];

            if (cur[0] == target[0] && cur[1] == target[1]) {
                return cur[2];
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (0 <= ny && 0 <= nx && ny < visit.length && nx < visit[0].length
                    && maps[ny].charAt(nx) != 'X' && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    queue.add(new int[]{ny, nx, count + 1});
                }
            }
        }
        return -1;
    }
}
