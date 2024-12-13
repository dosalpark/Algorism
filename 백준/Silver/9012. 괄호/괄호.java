import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            vpsCheck(br.readLine());
        }

        bw.flush();
        bw.close();
    }

    private static void vpsCheck(String str) throws IOException {
        int o = 0;
        int c = 0;
        String init = "NO";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                o++;
            } else {
                c++;
            }
            if (c > o) {
                bw.write(init + "\n");
                return;
            }
        }
        if (o == c) {
            init = "YES";
        }
        bw.write(init + "\n");
    }
}
