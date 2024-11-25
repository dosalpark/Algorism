import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int re = 1, dp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        recursive(N);
        dp(N);

        System.out.println(re + " " + dp);
    }

    private static void dp(int N) {
        int[] arr = new int[N + 1];
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp++;
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    }

    private static int recursive(int N) {
        if (N == 1 || N == 2) {
            return 1;
        } else {
            re++;
            return recursive(N - 1) + recursive(N - 2);
        }
    }

}