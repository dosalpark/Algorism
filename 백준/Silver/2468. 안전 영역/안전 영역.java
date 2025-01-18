import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int max;
    static int[][] map;
    static boolean[][] visit;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        max = 0;
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 100; i++) {
            bfs(i);
        }


        bw.write(max + "");
        bw.flush();
        bw.close();
    }

    private static void bfs(int i) {
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int count = 0;
        for (int j = 0; j < N; j++) {
            Arrays.fill(visit[j], false);
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] > i && !visit[y][x]) {
                    count++;
                    visit[y][x] = true;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{y, x});

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int ny, nx;
                        for (int j = 0; j < 4; j++) {
                            ny = cur[0] + dy[j];
                            nx = cur[1] + dx[j];
                            if (0 <= ny && 0 <= nx && ny < N && nx < N && !visit[ny][nx]
                                && map[ny][nx] > i) {
                                visit[ny][nx] = true;
                                queue.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
        }
        max = Math.max(max, count);
    }
}
