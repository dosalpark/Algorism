import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] subNode;
    static boolean[] visit;
    static List<Integer>[] nodes;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        subNode = new int[N + 1];
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
        dfs(R);

        for (int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(subNode[query]);
        }
    }

    private static int dfs(int start) {
        visit[start] = true;
        int count = 1;
        for (Integer next : nodes[start]) {
            if (!visit[next]) {
                count += dfs(next);
            }
        }
        subNode[start] = count;
        return count;
    }
}
