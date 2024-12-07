import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;
        int L = 0;
        int R = arr.length - 1;

        while (L < R) {
            int sum = arr[R] + arr[L];
            int absSum = Math.abs(sum);
            if(sum == 0){
                result[0] = arr[L];
                result[1] = arr[R];
                break;
            }
            if (min > absSum) {
                min = absSum;
                result[0] = arr[L];
                result[1] = arr[R];
            }
            if(sum > 0){
                R--;
            } else {
                L++;
            }
        }
        System.out.println(result[0] + " " + result[1]);

    }
}
