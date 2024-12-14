import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static StringTokenizer st;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String name;
        for (int i = 0; i < N; i++) {
            name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                list.add(entry.getKey());
            }
        }
        bw.write(list.size() + "\n");
        Collections.sort(list);
        for (String str : list) {
            bw.write(str + "\n");
        }

        bw.flush();
        bw.close();
    }
}
