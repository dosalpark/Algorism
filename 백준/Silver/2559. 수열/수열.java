import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[N+1];
        for(int i = 1; i <= K; i++){
            sum[K] += arr[i];
        }
        int max = sum[K];

        for(int i = K+1; i <= N; i++){
            sum[i] = arr[i] + sum[i-1] - arr[i-K];
            max = Math.max(max,sum[i]);
        }
        System.out.println(max);
    }
}