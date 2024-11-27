import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> rooms = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String time = br.readLine();
            int[] SE = new int[]{Integer.parseInt(time.split(" ")[0]),
                Integer.parseInt(time.split(" ")[1])};
            rooms.add(SE);
        }

        rooms.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int beforeEndTime = rooms.get(0)[1];
        int result = 1;

        for (int i = 1; i < N; i++) {
            int[] SE = rooms.get(i);
            int nextStartTime = SE[0];
            if (nextStartTime >= beforeEndTime) {
                result++;
                beforeEndTime = SE[1];
            }
        }

        System.out.println(result);
    }
}