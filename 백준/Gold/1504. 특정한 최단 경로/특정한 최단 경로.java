import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NE = br.readLine().split(" ");
        int N = Integer.parseInt(NE[0]);
        int E = Integer.parseInt(NE[1]);

        List<int[]>[] lists = new List[N + 1];
        for (int i = 1; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            String[] read = br.readLine().split(" ");
            int S = Integer.parseInt(read[0]);
            int G = Integer.parseInt(read[1]);
            int cost = Integer.parseInt(read[2]);
            lists[S].add(new int[]{G, cost});
            lists[G].add(new int[]{S, cost});
        }
        String[] V12 = br.readLine().split(" ");
        int V1 = Integer.parseInt(V12[0]);
        int V2 = Integer.parseInt(V12[1]);

        int[] oneToN = distance(1, lists, N);
        int[] v1ToN = distance(V1, lists, N);
        int[] v2ToN = distance(V2, lists, N);

        int sum1 = Integer.MAX_VALUE;
        int sum2 = Integer.MAX_VALUE;
        if (oneToN[V1] != Integer.MAX_VALUE && v1ToN[V2] != Integer.MAX_VALUE
            && v2ToN[N] != Integer.MAX_VALUE) {
            sum1 = oneToN[V1] + v1ToN[V2] + v2ToN[N];
        }
        if (oneToN[V2] != Integer.MAX_VALUE && v2ToN[V1] != Integer.MAX_VALUE
            && v1ToN[N] != Integer.MAX_VALUE) {
            sum2 = oneToN[V2] + v2ToN[V1] + v1ToN[N];
        }
        if (sum1 == Integer.MAX_VALUE && sum2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(sum1, sum2));
        }
    }

    private static int[] distance(int start, List<int[]>[] lists, int N) {
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            for (int[] ints : lists[now]) {
                int next = ints[0];
                int nextCost = ints[1];
                if (costs[next] > cost + nextCost) {
                    costs[next] = cost + nextCost;
                    pq.add(new int[]{next, cost + nextCost});
                }
            }
        }
        return costs;
    }
}
