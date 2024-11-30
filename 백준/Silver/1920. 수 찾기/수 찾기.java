import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(lower(array, num)).append("\n");
        }
        System.out.println(sb);
    }

    private static int lower(int[] array, int num) {
        int low = 0;
        int high = array.length-1;
        int mid;
        while (low < high) {
            mid = (high + low) / 2;
            if (num <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (array[low] == num) {
            return 1;
        } else {
            return 0;
        }
    }
}
