import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int Q;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.valueOf(st.nextToken()));
        }
        for (int i = 1; i <= N; i++) {
            arr[i] = pq.poll() + arr[i - 1];
        }

        int s, e;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            bw.write(arr[e] - arr[s - 1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
