import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NS = br.readLine().split(" ");
        int N = Integer.parseInt(NS[0]);
        int S = Integer.parseInt(NS[1]);
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = Integer.MAX_VALUE;
        int L = 0;
        int R = 0;
        int sum = arr[0];

        while (R < arr.length) {
            if (sum >= S && R - L < result) {
                result = R - L;
            }

            if (sum >= S) {
                sum -= arr[L];
                L++;
            } else {
                if (R + 1 < arr.length) {
                    sum += arr[R + 1];
                }
                R++;
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? 0 : result + 1);
    }
}
