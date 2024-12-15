import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        boolean[] isPrism = prism();

        for (int i = M; i <= N; i++) {
            if (isPrism[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static boolean[] prism() {
        boolean[] isPrism = new boolean[N + 1];
        Arrays.fill(isPrism, true);
        isPrism[0] = false;
        isPrism[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrism[i]) {
                for (int j = i * i; j <= N; j = j + i) {
                    isPrism[j] = false;
                }
            }
        }

        return isPrism;
    }
}
