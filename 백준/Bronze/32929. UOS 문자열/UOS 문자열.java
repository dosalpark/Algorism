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
        char[] UOS = new char[]{'U', 'O', 'S'};
        int result = N % 3 - 1;
        if (result < 0) {
            result = 2;
        }

        bw.write(UOS[result]);
        bw.flush();
        bw.close();
    }
}
