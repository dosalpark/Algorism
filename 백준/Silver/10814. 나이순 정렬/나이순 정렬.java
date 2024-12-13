import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new String[]{st.nextToken(), st.nextToken()});
        }
        list.sort((o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));

        for (int i = 0; i < list.size(); i++) {
            String[] cur = list.get(i);
            bw.write(cur[0] + " " + cur[1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
