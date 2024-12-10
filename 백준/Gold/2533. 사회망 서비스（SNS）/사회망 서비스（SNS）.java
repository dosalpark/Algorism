import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static int[][] dp;
    static boolean[] visit;
    static List<Integer>[] nodes;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];
        visit = new boolean[N + 1];
        nodes = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] cur = br.readLine().split(" ");
            int start = Integer.parseInt(cur[0]);
            int goal = Integer.parseInt(cur[1]);
            nodes[start].add(goal);
            nodes[goal].add(start);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    private static void dfs(int start) {
        //dp 0 - 얼리어답터 X | dp 1 - 얼리어답터
        visit[start] = true;
        dp[start][1] = 1;

        for (Integer next : nodes[start]) {
            if (!visit[next]) {
                visit[next] = true;
                dfs(next);
                dp[start][0] += dp[next][1];
                dp[start][1] += Math.min(dp[next][1], dp[next][0]);
            }
        }
    }
}
