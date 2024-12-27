import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 2];
        int[][] TP = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            TP[i] = new int[]{time, pay};
        }
        for (int i = N; i >= 1; i--) {
            if (i + TP[i][0] > N +1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], TP[i][1] + dp[i + TP[i][0]]);
            }
        }

        bw.write(dp[1] + "");
        bw.flush();
        bw.close();
    }
}
