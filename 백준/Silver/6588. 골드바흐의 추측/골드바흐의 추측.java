import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    //    static int M, N;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        String str;
        while (!(str = br.readLine()).equals("0")) {
            int convert = Integer.parseInt(str);
            queue.add(convert);
        }
        isPrime = new boolean[1_000_001];
        Arrays.fill(isPrime, true);
        Sieve();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int a = 0, b = 0;
            for (int i = 2; i <= cur/2; i++) {
                if (isPrime[i] && isPrime[cur - i]) {
                    a = i;
                    b = cur - i;
                    break;
                }
            }
            if (a == 0 && b == 0) {
                bw.write("Goldbach's conjecture is wrong." + "\n");
            } else {
                bw.write(cur + " = " + a + " + " + b + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void Sieve() {
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < 1_000_001; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 1_000_001; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
