import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(0);
            return;
        }
        List<Integer> prime = primes(N);
        int L = 0;
        int R = 0;
        int sum = prime.get(0);

        int result = 0;

        while (R < prime.size()){
            if(sum == N){
                result++;
            }

            if(sum > N){
                sum -= prime.get(L);
                L++;
            } else {
                if(R+1 < prime.size()){
                    sum += prime.get(R+1);
                }
                R++;
            }
        }
        System.out.println(result);
    }

    private static List<Integer> primes(int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2; i < isPrime.length; i++){
            if(isPrime[i]){
                list.add(i);
            }
        }
        return list;
    }

}
