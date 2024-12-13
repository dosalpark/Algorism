import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int count = 0;
        while (N>=0){
            if(N % 5 == 0){
                count += N/5;
                System.out.println(count);
                return;
            }
            N -= 3;
            count++;
        }

        System.out.println(-1);
    }
}
