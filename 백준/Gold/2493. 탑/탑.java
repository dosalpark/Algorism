import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] top = new int[N];
        int[] result = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < top[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek()[0];
            }

            stack.add(new int[]{i + 1, top[i]});
        }


        for (int i = 0; i < result.length; i++) {
            bw.write(result[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
