import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int K = Integer.parseInt(line.split(" ")[1]);

        int answer = factorial(N) / (factorial(K) * factorial(N - K));
        System.out.println(answer);
    }

    private static int factorial(int i) {
        if (i == 0) {
            return 1;
        }
        return i * factorial(i - 1);
    }
}
