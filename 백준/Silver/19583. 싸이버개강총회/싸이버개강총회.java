import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int startTime = timeConveter(st.nextToken());
        int endTime = timeConveter(st.nextToken());
        int closeTime = timeConveter(st.nextToken());
        Map<String, Boolean> map = new HashMap<>();

        String line;
        while ((line = br.readLine()) != null) {
            int enterTime = timeConveter(line.split(" ")[0]);
            String name = line.split(" ")[1];
            if (enterTime <= startTime) {
                map.put(name, false);
            } else if (endTime <= enterTime && enterTime <= closeTime && map.containsKey(name)) {
                map.put(name, true);
            }
        }

        int result = 0;
        for (Boolean value : map.values()) {
            if (value) {
                result++;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static int timeConveter(String s) {
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}
