import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int result = N;

        Map<Character, Integer> map;
        String line;
        for (int i = 0; i < N; i++) {
            map = new HashMap<>();
            line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (j == 0 || !map.containsKey(ch)) {
                    map.put(ch, j);
                } else {
                    if (map.get(ch) != j - 1) {
                        result--;
                        break;
                    }
                    map.put(ch,j);
                }
            }

        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
