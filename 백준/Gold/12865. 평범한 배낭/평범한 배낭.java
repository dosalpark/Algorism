import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int V;
    static StringTokenizer st;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        dp = new int[N+1][V + 1];

        int[][] NV = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            NV[i][0] = Integer.parseInt(st.nextToken());
            NV[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (NV[i-1][0] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], NV[i-1][1] + dp[i - 1][j - NV[i-1][0]]);
                }
            }
        }

        System.out.println(dp[N][V]);
    }
}
