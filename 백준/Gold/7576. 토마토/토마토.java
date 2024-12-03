import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        Queue<int[]> queue = new LinkedList<>();
        int zeroCount = 0;

        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                } else if(map[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        if (queue.isEmpty()) {
            System.out.println(-1);
        } else {
            int[] dy = {0, 0, 1, -1};
            int[] dx = {1, -1, 0, 0};
            int maxDay = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int y = cur[0];
                int x = cur[1];
                int dayCount = cur[2];
                maxDay = Math.max(maxDay, dayCount);

                for (int i = 0; i < 4; i++) {
                    int ny = dy[i] + y;
                    int nx = dx[i] + x;
                    if (0 <= ny && 0 <= nx && ny < M && nx < N && map[ny][nx] == 0) {
                        queue.add(new int[]{ny, nx, dayCount + 1});
                        map[ny][nx] = 1;
                        zeroCount--;
                    }
                }
            }
            if(zeroCount == 0){
                System.out.println(maxDay);
            } else {
                System.out.println(-1);
            }
        }
    }
}
