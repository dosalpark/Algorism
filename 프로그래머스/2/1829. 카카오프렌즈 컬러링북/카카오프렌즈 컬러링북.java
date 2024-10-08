class Solution {

    int[] dy = {0, 1, -1, 0};
    int[] dx = {1, 0, 0, -1};
    int[][] picture;

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        this.picture = picture;
        boolean[][] visit = new boolean[picture.length][picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                visit[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visit[i][j]) {
                    answer[0]++;
                    int sizeOfArea = dfs(i, j, picture[i][j], 0, visit);
                    answer[1] = Math.max(answer[1], sizeOfArea);
                }

            }
        }
        
        return answer;
    }

    private int dfs(int y, int x, int now, int count, boolean[][] visit) {
        visit[y][x] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < picture.length && nx >= 0 && nx < picture[0].length
                && !visit[ny][nx] && now == picture[ny][nx]) {
                count = dfs(ny, nx, now, count, visit);
            }
        }

        return count;
    }
}
