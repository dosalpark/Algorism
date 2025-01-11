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
    static StringTokenizer st;
    static int N, M;
    static char[][] map;
    static int wolf = 0, sheep = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];
                if (map[i][j] == 'v') {
                    wolf++;
                } else if (map[i][j] == 'k') {
                    sheep++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        bw.write(sheep + " " + wolf);
        bw.flush();
        bw.close();
    }

    private static void bfs(int y, int x) {
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        Queue<XY> queue = new LinkedList<>();
        queue.add(new XY(x, y));
        int w = 0, s = 0;
        if (map[y][x] == 'v') {
            w++;
        } else if (map[y][x] == 'k') {
            s++;
        }
        map[y][x] = '#';
        while (!queue.isEmpty()) {
            XY cur = queue.poll();

            int ny, nx;
            for (int i = 0; i < 4; i++) {
                ny = cur.Y + dy[i];
                nx = cur.X + dx[i];
                if (check(ny, nx)) {
                    if (map[ny][nx] == 'v') {
                        w++;
                    } else if (map[ny][nx] == 'k') {
                        s++;
                    }
                    map[ny][nx] = '#';
                    queue.add(new XY(nx, ny));
                }
            }
        }
        if(s > w){
            wolf -= w;
        } else {
            sheep -= s;
        }
    }

    private static boolean check(int y, int x) {
        return 0 <= y && 0 <= x && y < N && x < M && map[y][x] != '#';
    }

    private static class XY {

        int X, Y;

        public XY(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }

}
