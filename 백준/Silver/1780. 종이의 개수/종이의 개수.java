import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] check;
    static int[][] quad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        quad = new int[N][N];
        check = new int[3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                quad[i][j] = Integer.parseInt(st.nextToken());
                check[quad[i][j] + 1]++;
            }
        }

        if (check[0] == N * N) {
            System.out.println(1 + "\n" + 0 + "\n" + 0);
        } else if (check[1] == N * N) {
            System.out.println(0 + "\n" + 1 + "\n" + 0);
        } else if (check[2] == N * N) {
            System.out.println(0 + "\n" + 0 + "\n" + 1);
        } else {
            Arrays.fill(check, 0);
            int division = N / 3;
            dfs(0, 0, division, division, division);
            dfs(0, division, division, division * 2, division);
            dfs(0, division * 2, division, division * 3, division);
            dfs(division, 0, division * 2, division, division);
            dfs(division, division, division * 2, division * 2, division);
            dfs(division, division * 2, division * 2, N, division);
            dfs(division * 2, 0, N, division, division);
            dfs(division * 2, division, N, division * 2, division);
            dfs(division * 2, division * 2, N, N, division);
            System.out.println(check[0] + "\n" + check[1] + "\n" + check[2]);
        }
    }

    private static void dfs(int sy, int sx, int ey, int ex, int maxLen) {
        if (isAccord(sy, sx, ey, ex, quad)) {
            check[quad[sy][sx] + 1]++;
        } else {
            int division = maxLen / 3;
            dfs(sy, sx, sy + division, sx + division, division);
            dfs(sy, sx + division, sy + division, sx + division * 2, division);
            dfs(sy, sx + division * 2, sy + division, sx + division * 3, division);
            dfs(sy + division, sx, sy + division * 2, sx + division, division);
            dfs(sy + division, sx + division, sy + division * 2, sx + division * 2, division);
            dfs(sy + division, sx + division * 2, sy + division * 2, sx + maxLen, division);
            dfs(sy + division * 2, sx, sy + maxLen, sx + division, division);
            dfs(sy + division * 2, sx + division, sy + maxLen, sx + division * 2, division);
            dfs(sy + division * 2, sx + division * 2, sy + maxLen, sx + maxLen, division);
        }
    }

    private static boolean isAccord(int sy, int sx, int ey, int ex, int[][] quad) {
        int S = quad[sy][sx];
        for (int i = sy; i < ey; i++) {
            for (int j = sx; j < ex; j++) {
                if (quad[i][j] != S) {
                    return false;
                }
            }
        }
        return true;
    }
}
