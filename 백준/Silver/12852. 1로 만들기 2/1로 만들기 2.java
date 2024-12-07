import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, N});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int count = cur[0];
            int lastNum = cur[cur.length - 1];

            if (lastNum == 1) {
                result(cur);
                return;
            }

            queue.add(newArr(cur, count + 1, lastNum - 1));
            if (lastNum % 3 == 0) {
                queue.add(newArr(cur, count + 1, lastNum / 3));
            }
            if (lastNum % 2 == 0) {
                queue.add(newArr(cur, count + 1, lastNum / 2));
            }
        }
    }

    private static int[] newArr(int[] cur, int count, int lastNum) {
        int[] newArr = new int[cur.length + 1];
        newArr[0] = count;
        for (int i = 1; i < cur.length; i++) {
            newArr[i] = cur[i];
        }
        newArr[newArr.length - 1] = lastNum;
        return newArr;
    }

    private static void result(int[] cur) {
        StringBuilder sb = new StringBuilder();
        sb.append(cur[0]).append("\n");
        for (int i = 1; i < cur.length; i++) {
            sb.append(cur[i]).append(" ");
        }

        System.out.println(sb);
    }
}
