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

    static BufferedReader br;
    static BufferedWriter bw;
    static int N, M, result;
    static boolean[] visit;
    static List<List<Integer>> graph;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] read = br.readLine().split(" ");
            int a = Integer.parseInt(read[0]);
            int b = Integer.parseInt(read[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        result = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                result++;
                bfs(i);
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visit[i] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer near : graph.get(cur)) {
                if (!visit[near]) {
                    visit[near] = true;
                    queue.add(near);
                }
            }
        }
    }
}
