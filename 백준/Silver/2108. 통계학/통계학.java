import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            int number = Integer.parseInt(br.readLine());
            bw.write("" + number + "\n" + number + "\n" + number + "\n" + "0");
        } else {
            int[] numbers = new int[N];
            int distinct = 0;
            double sum = 0.0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(br.readLine());
                sum += numbers[i];
                map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
                distinct = Math.max(distinct, map.get(numbers[i]));
            }

            Arrays.sort(numbers);
            bw.write("" + Math.round(sum / N) + "\n");
            bw.write("" + numbers[N / 2] + "\n");
            if (distinct <= 1) {
                bw.write("" + numbers[1] + "\n");
            } else {
                List<Integer> list = new ArrayList<>();
                for (Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                    if (integerIntegerEntry.getValue() == distinct) {
                        list.add(integerIntegerEntry.getKey());
                    }
                }
                if (list.size() == 1) {
                    bw.write("" + list.get(0) + "\n");
                } else {
                    Collections.sort(list);
                    bw.write("" + list.get(1) + "\n");
                }
            }
            bw.write("" + (numbers[N - 1] - numbers[0]));
        }
        bw.flush();
        bw.close();
    }
}
