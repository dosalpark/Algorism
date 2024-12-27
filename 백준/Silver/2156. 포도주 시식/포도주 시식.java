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
        int[] wine = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        if (N > 0) {
            dp[1] = wine[1];
        }
        if (N > 1) {
            dp[2] = wine[2] + dp[1];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1],
                Math.max(dp[i - 2] + wine[i],
                    dp[i - 3] + wine[i - 1] + wine[i])
            );
        }

        bw.write(dp[N] + "");
        bw.flush();
        bw.close();
    }
}
