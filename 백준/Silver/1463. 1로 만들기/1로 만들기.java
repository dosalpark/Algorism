import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == 1) {
                System.out.println(cur[1]);
                break;
            }
            if (cur[0] % 3 == 0 && cur[0] / 3 >= 1) {
                queue.add(new int[]{cur[0] / 3, cur[1]+1});
            }
            if (cur[0] % 2 == 0 && cur[0] / 2 >= 1) {
                queue.add(new int[]{cur[0] / 2, cur[1]+1});
            }
            if (cur[0] - 1 >= 1) {
                queue.add(new int[]{cur[0] - 1, cur[1]+1});
            }
        }
    }
}