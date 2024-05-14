import java.util.*;
class Solution {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    String[] maps;

    public int bfs(int startY, int startX, char end) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        int answer = 0;
        que.add(new int[]{startY, startX, 0});
        visited[startY][startX] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            if (maps[now[0]].charAt(now[1]) == end) {
                if (answer != 0) {
                    answer = Math.min(answer, now[2]);
                } else {
                    answer = now[2];
                }
                return answer;
            }

            for (int i = 0; i < 4; i++) {
                int x = now[1] + dx[i];
                int y = now[0] + dy[i];
                int sum = now[2];

                if (x >= 0 && y >= 0 && maps.length > y && maps[0].length() > x
                    && maps[y].charAt(x) != 'X' && !visited[y][x]) {
                    que.add(new int[]{y, x, sum + 1});
                    visited[y][x] = true;
                }
            }
        }
        return answer;
    }
        
    public int solution(String[] maps) {
        this.maps = maps;
        int x = maps[0].length();
        int y = maps.length;
        int[] start = new int[2];
        int[] flag = new int[2];

        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                if (maps[j].charAt(i) == 'S') {
                    start[0] = j;
                    start[1] = i;
                } else if (maps[j].charAt(i) == 'L') {
                    flag[0] = j;
                    flag[1] = i;
                }
            }
        }
        int a = bfs(start[0], start[1], 'L');
        if (a == 0) {
            return -1;
        }
        int b = bfs(flag[0], flag[1], 'E');
        if (b == 0) {
            return -1;
        }

        return a + b;
    }
}