import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N;
    static int K;
    static int W;
    static int[] time;
    static int[] dp;
    static int[] inDegree;
    static List<Integer>[] build;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            time = new int[N + 1];
            dp = new int[N + 1];
            inDegree = new int[N + 1];
            build = new List[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
                build[i] = new ArrayList<>();
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                build[start].add(end);
                inDegree[end]++;
            }
            W = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                    dp[i] = time[i];
                }
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (Integer next : build[cur]) {
                    dp[next] = Math.max(dp[next], dp[cur] + time[next]);
                    inDegree[next]--;

                    if (inDegree[next] == 0) {
                        queue.add(next);
                    }

                }
            }
            bw.write(dp[W] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
