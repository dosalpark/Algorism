import java.util.LinkedList;
import java.util.Queue;

class Solution {

    boolean flag;
    boolean[][] visited;

    public int[] solution(String[][] places) {
        int[] answer = new int[]{1, 1, 1, 1, 1};
        for (int q = 0; q < places.length; q++) {
            flag = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[q][i].charAt(j) == 'P') {
                        visited = new boolean[5][5];
                        bfs(new Count(i, j, 0), places[q]);
                        if (flag) {
                            answer[q] = 0;
                            break;
                        }
                    }
                }
                if (flag) break;
            }
        }
        return answer;
    }

    private void bfs(Count start, String[] place) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Count> queue = new LinkedList<>();
        queue.add(start);
        visited[start.getY()][start.getX()] = true;

        while (!queue.isEmpty()) {
            Count cur = queue.poll();
            int x = cur.getX();
            int y = cur.getY();
            int count = cur.getCount();

            if (count > 0 && place[y].charAt(x) == 'P') {
                flag = true;
                return;
            }

            if (count >= 2) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[ny][nx] && place[ny].charAt(nx) != 'X') {
                    visited[ny][nx] = true;
                    queue.add(new Count(ny, nx, count + 1));
                }
            }
        }
    }
}

class Count {
    int y;
    int x;
    int count;

    public Count(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }

    int getY() {
        return this.y;
    }

    int getX() {
        return this.x;
    }

    int getCount() {
        return this.count;
    }
}
