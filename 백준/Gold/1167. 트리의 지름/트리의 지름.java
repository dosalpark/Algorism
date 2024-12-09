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

        List<int[]>[] tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            String[] arr = br.readLine().split(" ");
            int node = Integer.parseInt(arr[0]);
            int j = 1;
            while (!arr[j].equals("-1")) {
                int connectedNode = Integer.parseInt(arr[j]);
                int weight = Integer.parseInt(arr[j + 1]);
                tree[node].add(new int[]{connectedNode, weight});
                j += 2;
            }
        }

        int[] node = bfs(1,N,tree);
        int[] maxNode = bfs(node[0],N,tree);

        System.out.println(maxNode[1]);
    }

    private static int[] bfs(int start, int N, List<int[]>[] tree) {
        boolean[] visit = new boolean[N+1];
        int maxDistance = 0;
        int maxDistanceNode = start;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visit[start] = true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int node = cur[0];
            int distance = cur[1];
            for (int[] next : tree[node]) {
                if(!visit[next[0]]){
                    visit[next[0]] = true;
                    int sumDistance = distance + next[1];
                    if(sumDistance > maxDistance){
                        maxDistance = sumDistance;
                        maxDistanceNode = next[0];
                    }
                    queue.add(new int[]{next[0], sumDistance});
                }
            }
        }
        return new int[]{maxDistanceNode,maxDistance};
    }
}
