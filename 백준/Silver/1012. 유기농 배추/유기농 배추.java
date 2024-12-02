import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int bug;
    static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String MNK = br.readLine();
            M = Integer.parseInt(MNK.split(" ")[0]);
            N = Integer.parseInt(MNK.split(" ")[1]);
            K = Integer.parseInt(MNK.split(" ")[2]);
            map = settingMap(br);
            bug = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        bug++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(bug);
        }
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < M && 0 <= ny && ny < N && map[nx][ny] == 1) {
                map[nx][ny] = 9;
                dfs(nx, ny);
            }
        }
    }

    private static int[][] settingMap(BufferedReader br) throws IOException {
        int[][] map = new int[M][N];
        for (int i = 0; i < K; i++) {
            String[] cur = br.readLine().split(" ");
            int X = Integer.parseInt(cur[0]);
            int Y = Integer.parseInt(cur[1]);
            map[X][Y] = 1;
        }
        return map;
    }

}
