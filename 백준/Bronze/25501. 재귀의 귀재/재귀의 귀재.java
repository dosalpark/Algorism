import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] result = isPalindrome(br.readLine());
            System.out.println(result[0] + " " + result[1]);
//            bw.write(result[0] + " " + result[1]);
//            if (T != 1) {
//                bw.write("\n");
//            }
        }
//        bw.flush();
//        bw.close();
    }

    public static int[] recursion(String s, int l, int r, int count) {
        if (l >= r) {
            return new int[]{1, count};
        } else if (s.charAt(l) != s.charAt(r)) {
            return new int[]{0, count};
        } else {
            return recursion(s, l + 1, r - 1, count + 1);
        }
    }

    public static int[] isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1, 1);
    }
}