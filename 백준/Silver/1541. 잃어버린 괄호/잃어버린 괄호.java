import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        List<String> numSign = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
                if (i == expression.length() - 1) {
                    numSign.add(sb.toString());
                }
            } else {
                numSign.add(sb.toString());
                sb.setLength(0);
                numSign.add(ch + "");
                sb.setLength(0);
            }
        }
        int init = Integer.parseInt(numSign.get(0));
        int index;
        for (index = 1; index < numSign.size(); index = index + 2) {
            String sign = numSign.get(index);
            if (sign.equals("+")) {
                init = init + Integer.parseInt(numSign.get(index + 1));
            } else {
                break;
            }
        }

        int bucket = 0;
        for (int i = index; i < numSign.size(); i = i + 2) {
            String sign = numSign.get(i);
            if (sign.equals("+")) {
                bucket = bucket + Integer.parseInt(numSign.get(i + 1));
            } else if (sign.equals("-")) {
                init = init - Integer.parseInt(numSign.get(i + 1));
                init = init - bucket;
                bucket = 0;
            }

        }

        System.out.println(init - bucket);
    }
}