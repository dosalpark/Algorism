import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int S, C;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long[] arr = new long[S];
        long s = 1, e = 0;
        long sum = 0;
        for (int i = 0; i < S; i++) {
            arr[i] = Long.parseLong(br.readLine());
            e = Math.max(e, arr[i]);
            sum += arr[i];
        }


        long max = 0;
        while (s <= e) {
            long m = (s + e) / 2;
            int count = 0;
            for (long l : arr) {
                count += (int) (l / m);
            }
            if (count >= C) {
                s = m+1;
                max = (int) m;
            } else {
                e = m-1;
            }
        }


        bw.write(sum - (max * C) + "");
        bw.flush();
        bw.close();
    }
}
