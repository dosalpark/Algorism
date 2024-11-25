import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int re = 1, dp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] RGB = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][3];
        dp[0] = RGB[0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        dp[i][0] = Math.min(dp[i-1][1] + RGB[i][0], dp[i-1][2] + RGB[i][0]);
                        break;
                    case 1:
                        dp[i][1] = Math.min(dp[i-1][0] + RGB[i][1], dp[i-1][2] + RGB[i][1]);
                        break;
                    case 2:
                        dp[i][2] = Math.min(dp[i-1][0] + RGB[i][2], dp[i-1][1] + RGB[i][2]);
                        break;
                }
            }
            if(i == N-1){
                System.out.println(Math.min(dp[i][0], Math.min(dp[i][1], dp[i][2])));
            }

        }
    }
}