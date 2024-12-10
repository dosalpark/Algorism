import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node>[] nodes = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] cur = br.readLine().split(" ");
            int start = Integer.parseInt(cur[0]);
            int goal = Integer.parseInt(cur[1]);
            int distance = Integer.parseInt(cur[2]);
            nodes[start].add(new Node(goal, distance));
            nodes[goal].add(new Node(start, distance));
        }

        int[] startFirstNode = bfs(1, N, nodes);
        int[] nodeDiameter = bfs(startFirstNode[0], N, nodes);

        System.out.println(nodeDiameter[1]);
    }

    private static int[] bfs(int start, int N, List<Node>[] tree) {
        boolean[] visit = new boolean[N + 1];
        int maxDistance = 0;
        int maxDistanceNode = start;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visit[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int node = cur.node;
            int distance = cur.distance;
            for (Node next : tree[node]) {
                if (!visit[next.node]) {
                    visit[next.node] = true;
                    int sumDistance = distance + next.distance;
                    if (sumDistance > maxDistance) {
                        maxDistance = sumDistance;
                        maxDistanceNode = next.node;
                    }
                    queue.add(new Node(next.node, sumDistance));
                }
            }
        }
        return new int[]{maxDistanceNode, maxDistance};
    }

    private static class Node {

        private int node;
        private int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
