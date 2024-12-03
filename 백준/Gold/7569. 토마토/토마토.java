import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMH = br.readLine().split(" ");
        int N = Integer.parseInt(NMH[0]);
        int M = Integer.parseInt(NMH[1]);
        int H = Integer.parseInt(NMH[2]);
        Queue<int[]> queue = new LinkedList<>();
        int zeroCount = 0;

        int[][][] map = new int[H][M][N];
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    if (map[h][i][j] == 1) {
                        queue.add(new int[]{h, i, j, 0});
                    } else if (map[h][i][j] == 0) {
                        zeroCount++;
                    }
                }
            }
        }

        if (queue.isEmpty()) {
            System.out.println(-1);
        } else {
            int[] dy = {0, 0, 1, -1};
            int[] dx = {1, -1, 0, 0};
            int[] dh = {-1, 1};
            int maxDay = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int h = cur[0];
                int y = cur[1];
                int x = cur[2];
                int dayCount = cur[3];
                maxDay = Math.max(maxDay, dayCount);

                for (int i = 0; i < 4; i++) {
                    int ny = dy[i] + y;
                    int nx = dx[i] + x;
                    if (0 <= ny && 0 <= nx && ny < M && nx < N && map[h][ny][nx] == 0) {
                        queue.add(new int[]{h, ny, nx, dayCount + 1});
                        map[h][ny][nx] = 1;
                        zeroCount--;
                    }
                }
                for (int i = 0; i < 2; i++) {
                    int nh = dh[i] + h;
                    if (0 <= nh && nh < H && map[nh][y][x] == 0) {
                        queue.add(new int[]{nh, y, x, dayCount + 1});
                        map[nh][y][x] = 1;
                        zeroCount--;
                    }
                }
            }
            if (zeroCount == 0) {
                System.out.println(maxDay);
            } else {
                System.out.println(-1);
            }
        }
    }
}
