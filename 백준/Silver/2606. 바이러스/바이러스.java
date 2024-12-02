import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(br.readLine());
        int link = Integer.parseInt(br.readLine());
        int[] visit = new int[node + 1];
        int[][] graph = new int[link][2];
        int result = 0;

        for (int i = 0; i < link; i++) {
            String[] cur = br.readLine().split(" ");
            graph[i][0] = Integer.parseInt(cur[0]);
            graph[i][1] = Integer.parseInt(cur[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        visit[1] = 1;
        queue.add(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int[] arr : graph) {
                int NS = arr[0];
                int NE = arr[1];
                if (cur == NS && visit[NE] == 0) {
                    visit[NE] = 1;
                    queue.add(NE);
                } else if (cur == NE && visit[NS] == 0) {
                    visit[NS] = 1;
                    queue.add(NS);
                }
            }
        }
        System.out.println(Arrays.stream(visit).sum() - 1);
    }

}
