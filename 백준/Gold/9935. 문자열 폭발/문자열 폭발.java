import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strArr = br.readLine().toCharArray();
        char[] c4 = br.readLine().toCharArray();
        char lastCH = c4[c4.length - 1];

        Stack<Character> stack = new Stack<>();
        for (char ch : strArr) {
            stack.add(ch);
            if (ch == lastCH && stack.size() >= c4.length) {
                boolean isBoom = true;
                for (int i = 0; i < c4.length; i++) {
                    if (stack.get(stack.size() - c4.length + i) != c4[i]) {
                        isBoom = false;
                        break;
                    }
                }
                if (isBoom) {
                    for (int i = 0; i < c4.length; i++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character c : stack) {
            result.append(c);
        }
        System.out.println(result.length() == 0 ? "FRULA" : result);
    }

}
