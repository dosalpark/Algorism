import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static BufferedWriter bw;
    static Stack<Integer> stack;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        String commend;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            commend = st.nextToken();
            if (commend.equals("push")) {
                int cur = Integer.parseInt(st.nextToken());
                stack.add(cur);
            } else if (commend.equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(stack.pop() + "\n");
                }
            } else if (commend.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (commend.equals("empty")) {
                if (stack.isEmpty()) {
                    bw.write("1" + "\n");
                } else {
                    bw.write("0" + "\n");
                }
            } else if (commend.equals("top")) {
                if (stack.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
