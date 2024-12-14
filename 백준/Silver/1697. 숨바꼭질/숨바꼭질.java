import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int X;
    static int Y;
    static StringTokenizer st;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[100_001];

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{X, 0});
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int num = cur[0];
            int count = cur[1];
            if (num == Y) {
                bw.write(String.valueOf(count));
                break;
            }
            count++;

            int[] nextNum = {num - 1, num + 1, num * 2};
            for (int next : nextNum) {
                if (next >= 0 && next <= 100000 && !visit[next]) {
                    visit[next] = true;
                    que.add(new int[]{next, count});
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
