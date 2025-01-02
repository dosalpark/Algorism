import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int result;
    static Deque<Integer> que;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] findNum = new int[M];
        for (int i = 0; i < M; i++) {
            findNum[i] = Integer.parseInt(st.nextToken());
        }
        que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            que.add(i);
        }

        result = 0;
        for (int num : findNum) {
            int count = 0;
            while (que.peekFirst() != num) {
                count++;
                que.addLast(que.pollFirst());
            }
            if (que.size() / 2 >= count) {
                result += count;
            } else {
                result += que.size() - count;
            }
            que.pollFirst();
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
