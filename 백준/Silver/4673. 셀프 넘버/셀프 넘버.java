import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        visit = new boolean[10_001];

        for (int i = 1; i < 10_001; i++) {
            if (!visit[i]) {
                dfs(i);
            }
        }

        for (int i = 1; i < 10_001; i++) {
            if (!visit[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int i) {
        int sum = i;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        if (sum < 10_001 && !visit[sum]) {
            visit[sum] = true;
            dfs(sum);
        }
    }
}
