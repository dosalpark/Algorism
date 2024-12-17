import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long len = (int) (max - min + 1);
        boolean[] notSquareNoNo = new boolean[(int) len];

        for(int i = 2; (long) i * i <= max; i++){
            long square = (long) i * i;
            long start = min%square == 0 ? min : (min/square +1) * square;

            for(long j = start; j <= max; j += square){
                notSquareNoNo[(int) (j-min)] = true;
            }
        }
        int result = 0;
        for (boolean b : notSquareNoNo) {
            if(!b){
                result++;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}