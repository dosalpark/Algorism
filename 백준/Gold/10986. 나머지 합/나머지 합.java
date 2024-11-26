import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[] arr = new int[N];
        int[] divisionNumbers = new int[M];
        long answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = i == 0 ? Integer.parseInt(st.nextToken()) % M
                : (arr[i - 1] + Integer.parseInt(st.nextToken())) % M;
            divisionNumbers[arr[i]]++;

            if (arr[i] == 0) {
                answer++;
            }
        }
        for (int num : divisionNumbers) {
            answer += (long) num * (num - 1) / 2;
        }
        System.out.println(answer);
    }
}