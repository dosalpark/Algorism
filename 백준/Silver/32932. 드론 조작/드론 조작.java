import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static BufferedReader br;
    static BufferedWriter bw;
    static Set<String> crack;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        crack = new HashSet<>();
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            crack.add(st.nextToken() + " " + st.nextToken());
        }
        int x = 0;
        int y = 0;
        char[] control = br.readLine().toCharArray();
        for (int i = 0; i < M; i++) {
            int nextMove = 0;
            switch (control[i]) {
                case 'R':
                    nextMove = 0;
                    break;
                case 'L':
                    nextMove = 1;
                    break;
                case 'U':
                    nextMove = 2;
                    break;
                case 'D':
                    nextMove = 3;
            }
            int nx = x + dx[nextMove];
            int ny = y + dy[nextMove];

            if (!crack.contains(nx + " " + ny)) {
                x = nx;
                y = ny;
            }
        }

        bw.write(x + " " + y);
        bw.flush();
        bw.close();
    }
}
