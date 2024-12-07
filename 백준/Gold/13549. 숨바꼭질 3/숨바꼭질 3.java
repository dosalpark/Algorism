import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] SE = br.readLine().split(" ");
        int start = Integer.parseInt(SE[0]);
        int end = Integer.parseInt(SE[1]);

        if (start > end) {
            System.out.println(start - end);
        } else {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            int[] visit = new int[100_001];
            Arrays.fill(visit, Integer.MAX_VALUE);
            visit[end] = 0;
            pq.add(new int[]{end, 0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int now = cur[0];
                int count = cur[1];
                if (now == start) {
                    System.out.println(count);
                    return;
                }
                if (now % 2 == 0 && now / 2 >= 0 && visit[now / 2] > count) {
                    visit[now / 2] = count;
                    pq.add(new int[]{now / 2, count});
                }
                count++;
                if (now + 1 < visit.length && visit[now + 1] > count) {
                    visit[now + 1] = count;
                    pq.add(new int[]{now + 1, count});
                }
                if (now - 1 >= 0 && visit[now - 1] > count) {
                    visit[now - 1] = count;
                    pq.add(new int[]{now - 1, count});
                }
            }
        }
    }
}
