import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static Queue<Integer> MQ;
    static Queue<Integer> SQ;
    static int[] charConverterNum = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1,
        1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] name = br.readLine().split(" ");
        MQ = new LinkedList<>();
        int index = 0;
        for (; index < Math.min(N, M); index++) {
            MQ.add(charConverterNum[name[0].charAt(index) - 'A']);
            MQ.add(charConverterNum[name[1].charAt(index) - 'A']);
        }
        if (N > M) {
            for (; index < N; index++) {
                MQ.add(charConverterNum[name[0].charAt(index) - 'A']);
            }
        } else {
            for (; index < M; index++) {
                MQ.add(charConverterNum[name[1].charAt(index) - 'A']);
            }
        }

        while (MQ.size() > 2) {
            MQ = mixture(MQ);
        }

        bw.write((MQ.poll() * 10 + MQ.poll()) + "%");



        bw.flush();
        bw.close();

    }

    private static Queue<Integer> mixture(Queue<Integer> mq) {
        SQ = new LinkedList<>();
        int before = mq.poll();

        while (!mq.isEmpty()) {
            int cur = mq.poll();
            SQ.add((cur + before) % 10);
            before = cur;
        }
        return SQ;
    }
}
