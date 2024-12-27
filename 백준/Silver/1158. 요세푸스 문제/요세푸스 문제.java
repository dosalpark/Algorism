import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] body;
    static int[] score;
    static int N, K;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        bw.write("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                int cycle = queue.poll();
                queue.add(cycle);
            }
            int cur = queue.poll();
            if (queue.isEmpty()) {
                bw.write(cur + "");
            } else {
                bw.write(cur + ", ");
            }
        }

        bw.write(">");
        bw.flush();
        bw.close();
    }
}
