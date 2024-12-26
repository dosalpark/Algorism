import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] cost;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, Q;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cost = new int[N + 1][N + 1];
        for (int i = 1; i < cost.length; i++) {
            for (int j = 1; j < cost[i].length; j++) {
                if (i != j) {
                    cost[i][j] = N+1;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cost[u][v] = 0;
            if (b == 0) {
                cost[v][u] = 1;
            } else {
                cost[v][u] = 0;
            }
        }

        for (int n = 1; n <= N; n++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][n] + cost[n][j]);
                }
            }
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(cost[s][e] + "\n");
        }

        bw.flush();
        bw.close();

    }
}
