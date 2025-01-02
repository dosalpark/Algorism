import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        int[] order = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int beforeCount = Integer.parseInt(st.nextToken()) + 1;
            int index = 0;
            while (beforeCount > 0) {
                if (order[index] == 0) {
                    beforeCount--;
                }
                index++;
            }

            order[index - 1] = i;
        }

        for (int i : order) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}
