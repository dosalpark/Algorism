import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static Queue<String>[] queues;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        queues = new Queue[N];
        for (int i = 0; i < N; i++) {
            queues[i] = new LinkedList<>();
            String[] arr = br.readLine().split(" ");
            for (String s : arr) {
                queues[i].add(s);
            }
        }

        String[] pollQue = new String[N];
        for (int i = 0; i < N; i++) {
            pollQue[i] = queues[i].poll();
        }

        String[] answer = br.readLine().split(" ");
        boolean flag = false;
        for (String s : answer) {
            flag = false;
            for (int i = 0; i < pollQue.length; i++) {
                if (s.equals(pollQue[i])) {
                    flag = true;
                    if (!queues[i].isEmpty()) {
                        pollQue[i] = queues[i].poll();
                    } else {
                        pollQue[i] = "";
                    }
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        for (String s : pollQue) {
            if(!s.isEmpty()){
                flag = false;
                break;
            }
        }

        if (!flag) {
            bw.write("Impossible");
        } else {
            bw.write("Possible");
        }
        bw.flush();
        bw.close();
    }
}
