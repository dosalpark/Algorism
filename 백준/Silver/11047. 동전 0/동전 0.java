import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int[] arr = new int[N];
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < arr.length; i++) {
            if(K == 0){
                break;
            }
            int coin = arr[i];
            while (coin <= K ){
                result++;
                K -= coin;
            }
        }
        System.out.println(result);
    }
}