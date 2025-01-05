import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long total;
    static int[] arr;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        long sum1 = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum1 += arr[i];
        }

        total = Long.parseLong(br.readLine());
        if(sum1 <= total){
            bw.write(max+"");
        } else {

            long start = 0, end = max, mid = (start + end) / 2;

            while (start != mid) {
                long sum = 0;
                for (int i = 0; i < N; i++) {
                    if (mid < arr[i]) {
                        sum += mid;
                    } else {
                        sum += arr[i];
                    }
                }

                if (sum > total) {
                    end = mid;
                } else {
                    start = mid;
                }
                mid = (start + end) / 2;
            }
            bw.write(start + "");
        }
        bw.flush();
        bw.close();
    }
}
