import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N, M, result;
    static int[][] land;
    static StringTokenizer st;
    static int[] dx = {1, -1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while (!(line = br.readLine()).equals("0 0")) {
            N = Integer.parseInt(line.split(" ")[0]);
            M = Integer.parseInt(line.split(" ")[1]);
            land = new int[M][N];
            result = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (land[i][j] == 1) {
                        result++;
                        bfs(i, j);
                    }
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        land[y][x] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int ny, nx;
            for (int i = 0; i < 8; i++) {
                ny = cur[0] + dy[i];
                nx = cur[1] + dx[i];
                if (0 <= ny && 0 <= nx && ny < M && nx < N && land[ny][nx] == 1) {
                    queue.add(new int[]{ny, nx});
                    land[ny][nx] = 0;
                }
            }
        }
    }
}
