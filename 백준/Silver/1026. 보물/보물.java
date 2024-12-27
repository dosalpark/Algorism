import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int sum = 0;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq1.add(Integer.valueOf(st.nextToken()));
        }
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq2.add(Integer.valueOf(st.nextToken()));
        }

        while (!pq1.isEmpty()) {
            int cur1 = pq1.poll();
            int cur2 = pq2.poll();

            sum += cur1 * cur2;
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}
