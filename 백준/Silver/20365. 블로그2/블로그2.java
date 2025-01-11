import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        int b = check(arr, 'B');
        int r = check(arr, 'R');

        bw.write(Math.min(b, r) + "");
        bw.flush();
        bw.close();
    }

    private static int check(char[] arr, char cur) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != cur || (i > 0 && arr[i] == cur && arr[i - 1] == cur)) {
                continue;
            }
            if (arr[i] == cur && (i == 0 || arr[i - 1] != cur)) {
                result++;
            }
        }
        return result + 1;
    }
}
