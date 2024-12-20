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
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.valueOf(st.nextToken()));
        }
        int result = 0;
        while (!pq.isEmpty()) {
            int o1 = pq.poll();
            int o2 = pq.isEmpty() ? 0 : pq.poll();

            o1--;
            o2--;
            if (o1 > 0) {
                pq.add(o1);
            }
            if (o2 > 0) {
                pq.add(o2);
            }
            result++;
            if(result > 1440){
                result = -1;
                break;
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
