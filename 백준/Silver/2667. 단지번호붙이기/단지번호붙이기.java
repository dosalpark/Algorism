import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = arr[j] - 48;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1) {
                    map[y][x] = 0;
                    pq.add(dfs(y, x, N, 1));
                }
            }
        }
        System.out.println(pq.size());
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    private static int dfs(int y, int x, int N, int count) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0 <= ny && ny < N && 0 <= nx && nx < N && map[ny][nx] == 1) {
                map[ny][nx] = 0;
                count = dfs(ny, nx, N, count + 1);
            }
        }
        return count;
    }

}
