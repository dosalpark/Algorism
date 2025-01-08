import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        if (Pattern.matches("(10[0]+[1]+|01)+", str)) {
            bw.write("SUBMARINE");
        } else {
            bw.write("NOISE");
        }

        bw.flush();
        bw.close();
    }
}
