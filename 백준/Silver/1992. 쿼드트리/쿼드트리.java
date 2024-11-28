import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] quad = new int[N][N];
        boolean[] initCheck = new boolean[2];
        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < str.length; j++) {
                quad[i][j] = str[j] - '0';
                if (quad[i][j] == 0) {
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
            System.out.println("1");
        } else if (!initCheck[1]) {
            System.out.println("0");
        } else {
            StringBuilder sb = new StringBuilder("(");
            sb.append(dfs(0, 0, N / 2, N / 2, quad));
            sb.append(dfs(0, N / 2, N / 2, N, quad));
            sb.append(dfs(N / 2, 0, N, N / 2, quad));
            sb.append(dfs(N / 2, N / 2, N, N, quad));
            sb.append(")");
            System.out.println(sb);
        }
    }

    private static String dfs(int sy, int sx, int ey, int ex, int[][] quad) {
        if (isAccord(sy, sx, ey, ex, quad)) {
            return String.valueOf(quad[sy][sx]);
        } else {
            StringBuilder sb = new StringBuilder("(");
            sb.append(dfs(sy, sx, (sy + ey) / 2, (sx + ex) / 2, quad));
            sb.append(dfs(sy, (sx + ex) / 2, (sy + ey) / 2, ex, quad));
            sb.append(dfs((sy + ey) / 2, sx, ey, (sx + ex) / 2, quad));
            sb.append(dfs((sy + ey) / 2, (sx + ex) / 2, ey, ex, quad));
            sb.append(")");
            return sb.toString();
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
