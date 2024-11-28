import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] ZO = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];
        boolean[] initCheck = new boolean[2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if (paper[i][j] == 0) {
                    if (!initCheck[0]) {
                        initCheck[0] = true;
                    }
                } else {
                    if (!initCheck[1]) {
                        initCheck[1] = true;
                    }
                }
            }
        }

        if (!initCheck[0]) {
            ZO[1]++;
        } else if (!initCheck[1]) {
            ZO[0]++;
        } else {
            dfs(0, 0, N / 2, N / 2, paper);
            dfs(0, N / 2, N / 2, N, paper);
            dfs(N / 2, 0, N, N / 2, paper);
            dfs(N / 2, N / 2, N, N, paper);
        }

        System.out.println(ZO[0] + "\n" + ZO[1]);
    }

    private static void dfs(int sy, int sx, int ey, int ex, int[][] paper) {
        if (isAccord(sy, sx, ey, ex, paper)) {
            ZO[paper[sy][sx]]++;
        } else {
            dfs(sy, sx, (sy + ey) / 2, (sx + ex) / 2, paper);
            dfs(sy, (sx + ex) / 2, (sy + ey) / 2, ex, paper);
            dfs((sy + ey) / 2, sx, ey, (sx + ex) / 2, paper);
            dfs((sy + ey) / 2, (sx + ex) / 2, ey, ex, paper);
        }

    }

    private static boolean isAccord(int sy, int sx, int ey, int ex, int[][] paper) {
        int S = paper[sy][sx];
        for (int i = sy; i < ey; i++) {
            for (int j = sx; j < ex; j++) {
                if (paper[i][j] != S) {
                    return false;
                }
            }
        }
        return true;
    }
}
