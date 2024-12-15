import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static long[] cables;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cables = new long[N];

        long low = 0;
        long high = 1;
        for (int i = 0; i < N; i++) {
            cables[i] = Long.parseLong(br.readLine());
            high += cables[i];
        }
        long mid = (high + low) / 2;
        int conversionCable;

        while (mid != low) {
            conversionCable = 0;

            for (long cable : cables) {
                conversionCable += (int) (cable / mid);
            }
            if (conversionCable >= M) {
                low = mid;
                mid = (low + high) / 2;
            } else {
                high = mid;
                mid = (low + high) / 2;
            }
        }

        bw.write(mid + "");

        bw.flush();
        bw.close();
    }
}
