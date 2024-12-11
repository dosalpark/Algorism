import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<Integer>[] graphs = new List[N + 1];
            for (int i = 1; i < graphs.length; i++) {
                graphs[i] = new ArrayList<>();
            }
            int[] twoNode = new int[2];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                if (i == N - 1) {
                    twoNode[0] = parent;
                    twoNode[1] = child;
                    continue;
                }
                graphs[child].add(parent);
            }

            List<Integer> parentCheck = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(twoNode[0]);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                parentCheck.add(cur);
                if (!graphs[cur].isEmpty()) {
                    queue.add(graphs[cur].get(0));
                }
            }

            queue.add(twoNode[1]);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (parentCheck.contains(cur)) {
                    System.out.println(cur);
                    break;
                }
                if (!graphs[cur].isEmpty()) {
                    queue.add(graphs[cur].get(0));
                }
            }
        }
    }
}
