import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int T;
    static boolean[] eratosthenes;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        sieve(10_001);

        while (T-- > 0) {
            int cur = Integer.parseInt(br.readLine());
            for (int i = cur / 2; i >= 2; i--) {
                if (eratosthenes[i] && eratosthenes[cur - i]) {
                    bw.write(i + " " + (cur - i) + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
    }

    private static void sieve(int max) {
        eratosthenes = new boolean[max];
        Arrays.fill(eratosthenes, true);
        eratosthenes[0] = false;
        eratosthenes[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (eratosthenes[i]) {
                for (int j = i * i; j < max; j = j + i) {
                    eratosthenes[j] = false;
                }
            }
        }
    }
}
