import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static boolean flag;
    static int[] start, end;
    static int[][] next;
    static boolean[] visit;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            //출발지 셋팅
            start = new int[2];
            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            //편의점 셋팅
            visit = new boolean[N];
            next = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                next[i][0] = Integer.parseInt(st.nextToken());
                next[i][1] = Integer.parseInt(st.nextToken());
            }
            //도착지 셋팅
            end = new int[2];
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start[0], start[1]});
            flag = false;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (Math.abs(cur[1] - end[1]) + Math.abs(cur[0] - end[0]) <= 1_000) {
                    flag = true;
                    break;
                }

                for (int i = 0; i < next.length; i++) {
                    if (Math.abs(cur[1] - next[i][1]) + Math.abs(cur[0] - next[i][0]) <= 1_000
                        && !visit[i]) {
                        visit[i] = true;
                        queue.add(new int[]{next[i][0], next[i][1]});
                    }
                }
            }
            if (flag) {
                bw.write("happy" + "\n");
            } else {
                bw.write("sad" + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
