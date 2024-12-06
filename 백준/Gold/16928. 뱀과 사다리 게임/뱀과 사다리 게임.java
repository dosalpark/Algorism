import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        boolean[] visit = new boolean[101];
        int[] map = new int[101];

        for (int i = 0; i < 101; i++) {
            map[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            String[] cur = br.readLine().split(" ");
            int S = Integer.parseInt(cur[0]);
            int G = Integer.parseInt(cur[1]);
            map[S] = G;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0];
            int count = cur[1];
            if (now == 100) {
                System.out.println(count);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;
                if (next <= 100 && !visit[next]) {
                    visit[next] = true;
                    queue.add(new int[]{map[next], count + 1});
                }
            }
        }
    }
}
