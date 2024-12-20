import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        Queue<Long> queue = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            queue.add((long) cur);
            max = Math.max(max, cur);
        }

        long[] dp = new long[max + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for (int i = 5; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        while (!queue.isEmpty()) {
            long cur = queue.poll();
            bw.write(dp[(int) cur] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
