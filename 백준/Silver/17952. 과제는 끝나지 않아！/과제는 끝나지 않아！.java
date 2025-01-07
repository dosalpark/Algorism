import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            if (check == 0 && !stack.isEmpty()) {
                int[] cur = stack.pop();
                cur[1]--;
                if (cur[1] == 0) {
                    sum += cur[0];
                } else {
                    stack.add(new int[]{cur[0], cur[1]});
                }
            } else if(check == 1){
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken()) - 1;
                if (time == 0) {
                    sum += score;
                } else {
                    stack.add(new int[]{score, time});
                }
            }
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
