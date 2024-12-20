import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int Q;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                arr[j][i] = arr[j - 1][i] + arr[j][i];
            }
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String[] xy = br.readLine().split(" ");
            int sy = Integer.parseInt(xy[0]) - 1;
            int sx = Integer.parseInt(xy[1]) - 1;
            int ey = Integer.parseInt(xy[2]);
            int ex = Integer.parseInt(xy[3]);

            bw.write(arr[ey][ex] + arr[sy][sx] - arr[ey][sx] - arr[sy][ex] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
