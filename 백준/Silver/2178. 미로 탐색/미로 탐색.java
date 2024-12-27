import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] pan;
    static int N, M;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pan = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                pan[i][j] = line[j] - '0';
            }
        }

        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(0, 0, 1));

        while (!queue.isEmpty()) {
            Move cur = queue.poll();
            if (cur.y == N - 1 && cur.x == M - 1) {
                bw.write(cur.count + "");
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (0 <= ny && 0 <= nx && ny < N && nx < M && pan[ny][nx] != 0) {
                    if (pan[ny][nx] == 1 || pan[ny][nx] > cur.count + 1) {
                        queue.add(new Move(ny, nx, cur.count + 1));
                        pan[ny][nx] = cur.count + 1;
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }

    private static class Move {

        int y, x, count;

        public Move(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

}
