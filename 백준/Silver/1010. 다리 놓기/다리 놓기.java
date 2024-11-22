import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String cur = br.readLine();
            int N = Integer.parseInt(cur.split(" ")[0]);
            int M = Integer.parseInt(cur.split(" ")[1]);
            System.out.println(combination(M, N));

        }
    }

    private static long combination(int M, int N) {
        if (N > M - N) {
            N = M - N;
        }
        long answer = 1;
        for (int i = 0; i < N; i++) {
            answer *= (M - i);
            answer /= (i + 1);
        }
        return answer;
    }
}
