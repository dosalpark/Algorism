import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int M, N, K;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] map;
    static PriorityQueue<Integer> pq;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());//세로
        N = Integer.parseInt(st.nextToken());//가로
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        pq = new PriorityQueue<>();

        int sx, sy, ex, ey;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            painting(sx, sy, ex, ey);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    pq.add(dfs(i, j));
                }
            }
        }

        bw.write(pq.size() + "\n");
        while (!pq.isEmpty()) {
            bw.write(pq.poll() + " ");
        }

        bw.flush();
        bw.close();
    }

    private static int dfs(int y, int x) {
        map[y][x] = 1;
        int count = 1;

        int ny, nx;
        for (int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];
            if (0 <= ny && 0 <= nx && ny < M && nx < N && map[ny][nx] == 0) {
                count += dfs(ny, nx);
            }
        }
        return count;
    }

    private static void painting(int sx, int sy, int ex, int ey) {
        for (int i = sy; i < ey; i++) {
            for (int j = sx; j < ex; j++) {
                map[i][j] = 1;
            }
        }
    }
}
