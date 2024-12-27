import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[][] body;
    static int[] score;
    static int N;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        body = new int[N][2];
        score = new int[N];
        Arrays.fill(score,1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            body[i][0] = Integer.parseInt(st.nextToken());
            body[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (body[i][0] < body[j][0] && body[i][1] < body[j][1]) {
                    score[i]++;
                }
            }
        }
        for (int i : score) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }
}
