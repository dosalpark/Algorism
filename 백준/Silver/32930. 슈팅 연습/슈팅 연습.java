import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static BufferedReader br;
    static BufferedWriter bw;
    static boolean[] visit;
    static List<int[]> target;
    static int result;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + M];
        target = new ArrayList<>();
        result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            target.add(
                new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int y = 0;
        int x = 0;
        for (int i = 0; i < M; i++) {
            int maxScore = 0;
            int maxScoreTarget = 0;
            for (int j = 0; j < target.size(); j++) {
                if (!visit[j]) {
                    int yDistance = y - target.get(j)[0];
                    int xDistance = x - target.get(j)[1];
                    int nowScore = yDistance * yDistance + xDistance * xDistance;
                    if (nowScore > maxScore) {
                        maxScore = nowScore;
                        maxScoreTarget = j;
                    }
                }
            }
            visit[maxScoreTarget] = true;
            result += maxScore;

            int[] maxTarget = target.get(maxScoreTarget);
            y = maxTarget[0];
            x = maxTarget[1];

            st = new StringTokenizer(br.readLine());
            target.add(
                new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
