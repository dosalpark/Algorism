import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int doughPrice = Integer.parseInt(st.nextToken());
        int toppingPrice = Integer.parseInt(st.nextToken());
        int doughCalorie = Integer.parseInt(br.readLine());

        Integer[] toppingCalories = new Integer[N];
        for (int i = 0; i < N; i++) {
            toppingCalories[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(toppingCalories, (o1, o2) -> o2 - o1);

        double bestPizza = (double) doughCalorie / doughPrice;

        int onToppingCalories = doughCalorie;
        int toppingCount = 0;

        for (int i = 0; i < toppingCalories.length; i++) {
            toppingCount++;
            onToppingCalories += toppingCalories[i];

            double newBestPizza = (double) onToppingCalories / (doughPrice + (toppingPrice * toppingCount));
            if (bestPizza < newBestPizza) {
                bestPizza = newBestPizza;
            } else {
                break;    
            }
        }

        bw.write((int) bestPizza + "\n");
        bw.flush();
        bw.close();
    }
}