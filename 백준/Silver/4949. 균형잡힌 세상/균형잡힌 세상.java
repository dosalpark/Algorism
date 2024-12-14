import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int X;
    static int Y;
    static StringTokenizer st;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        boolean falseCheck;
        Stack<Character> stack;
        while (!(line = br.readLine()).equals(".")) {
            falseCheck = true;
            stack = new Stack<>();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == '(' || ch == '[') {
                    stack.add(ch);
                    continue;
                }

                if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        falseCheck = false;
                        break;
                    }
                    stack.pop();
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        falseCheck = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty() && falseCheck) {
                bw.write("yes" + "\n");
            } else {
                bw.write("no" + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
