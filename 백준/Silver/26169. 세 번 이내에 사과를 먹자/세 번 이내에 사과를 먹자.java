import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int Y;
    static int X;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[][] pan;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        pan = new int[5][5];
        flag = false;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                pan[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dfs(new Apple(Y, X, pan[Y][X] == 1 ? 1 : 0, 0));

        bw.write(flag ? "1" : "0");
        bw.flush();
        bw.close();

    }

    private static void dfs(Apple apple) {
        if (apple.eat >= 2) {
            flag = true;
            return;
        }
        if (apple.count >= 3 || flag) {
            return;
        }

        int temp = pan[apple.y][apple.x];
        pan[apple.y][apple.x] = -1;

        for (int i = 0; i < 4; i++) {
            int ny = apple.y + dy[i];
            int nx = apple.x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < 5 && nx < 5 && pan[ny][nx] != -1) {
                if (pan[ny][nx] == 1) {
                    dfs(new Apple(ny, nx, apple.eat + 1, apple.count + 1));
                } else {
                    dfs(new Apple(ny, nx, apple.eat, apple.count + 1));
                }
            }
        }

        pan[apple.y][apple.x] = temp;
    }

    private static class Apple {

        int y, x, eat, count;

        public Apple(int y, int x, int eat, int count) {
            this.y = y;
            this.x = x;
            this.eat = eat;
            this.count = count;
        }
    }

}
