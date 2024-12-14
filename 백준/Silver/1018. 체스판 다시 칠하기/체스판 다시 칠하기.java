import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int X;
    static int Y;
    static int[][] pan;
    static StringTokenizer st;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        pan = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < X; j++) {
                if (arr[j] == 'W') {
                    pan[i][j] = 0;
                } else {
                    pan[i][j] = 1;
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= Y - 8; i++) {
            for (int j = 0; j <= X - 8; j++) {
                result = Math.min(result, panCheck(i, j));
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int panCheck(int y, int x) {
        int result = 0;
        int divide = 0;
        for (int i = y; i < y + 8; i++) {
            divide++;
            for (int j = x; j < x + 8; j++) {
                divide++;
                if (divide % 2 != pan[i][j]) {
                    result++;
                }
            }
        }

        return Math.min(result, 64 - result);
    }
}
