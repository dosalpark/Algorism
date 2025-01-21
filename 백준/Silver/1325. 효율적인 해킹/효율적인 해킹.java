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
    static int N, M;
    static int max;
    static List<Integer>[] graph;
    static boolean[] visit;
    static int[] virus;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        virus = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int endPoint = Integer.parseInt(st.nextToken());
            int startPoint = Integer.parseInt(st.nextToken());
            graph[startPoint].add(endPoint);
        }


        max = 0;
        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        for (int i = 1; i <= N; i++) {
            if (virus[i] == max) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void bfs(int i) {
        int count = 1;
        visit = new boolean[N + 1];
        visit[i] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Integer next : graph[cur]) {
                if (!visit[next]) {
                    visit[next] = true;
                    count++;
                    queue.add(next);
                }
            }

        }
        virus[i] = count;
        max = Math.max(max, count);
    }
}
