import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int Q;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numMap = new HashMap<>();

        String name;
        for (int i = 1; i <= N; i++) {
            name = br.readLine();
            nameMap.put(name, i);
            numMap.put(i, name);
        }

        String query;
        for (int i = 0; i < Q; i++) {
            query = br.readLine();
            if ('0' <= query.charAt(0) && query.charAt(0) <= '9') {
                bw.write(numMap.get(Integer.parseInt(query)) + "\n");
            } else {
                bw.write(nameMap.get(query) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
