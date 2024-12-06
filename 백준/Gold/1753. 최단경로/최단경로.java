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
        String[] VE = br.readLine().split(" ");
        int V = Integer.parseInt(VE[0]);
        int E = Integer.parseInt(VE[1]);
        int start = Integer.parseInt(br.readLine());

        List<int[]>[] lists = new List[V + 1];
        int[] costs = new int[V + 1];

        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        for (int i = 1; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            String[] read = br.readLine().split(" ");
            int S = Integer.parseInt(read[0]);
            int G = Integer.parseInt(read[1]);
            int cost = Integer.parseInt(read[2]);
            lists[S].add(new int[]{G, cost});
        }

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
        for (int i = 1; i < costs.length; i++) {
            if(costs[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            } else {
                System.out.println(costs[i]);
            }
        }
    }
}
