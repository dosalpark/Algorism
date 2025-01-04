import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[] moveCost = new int[N + 1];
        Arrays.fill(moveCost, Integer.MAX_VALUE);
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int s, e, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e, c});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.add(new Node(start, 0));
        moveCost[start] = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            if(moveCost[cur.node] < cur.cost){
                continue;
            }
            

            for (int[] next : graph[cur.node]) {
                int nNode = next[0];
                int nCost = next[1];
                if (moveCost[nNode] > cur.cost + nCost) {
                    moveCost[nNode] = cur.cost + nCost;
                    queue.add(new Node(nNode, cur.cost + nCost));
                }
            }
        }

        bw.write(moveCost[end] + "");
        bw.flush();
        bw.close();
    }

    private static class Node {

        int node, cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
