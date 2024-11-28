import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) -1;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] distance = new int[N];
        int[] price = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.parseInt(st1.nextToken());
            price[i] = Integer.parseInt(st2.nextToken());
        }
        int result = 0;

        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            minPrice = Math.min(minPrice,price[i]);
            result += minPrice*distance[i];
        }

        System.out.println(result);
    }
}