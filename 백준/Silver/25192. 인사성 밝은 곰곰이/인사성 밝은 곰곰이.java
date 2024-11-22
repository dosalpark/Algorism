import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        Set<String> in = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String now = br.readLine();
            if (now.equals("ENTER")) {
                result += in.size();
                in.clear();
            } else {
                in.add(now);
            }
        }
        System.out.println(result + in.size());
    }
}
