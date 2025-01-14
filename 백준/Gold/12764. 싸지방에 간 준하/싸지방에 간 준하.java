import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
//        int[][] arr = new int[N][2];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            pq.add(new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])});
//            arr[i][0] = Integer.parseInt(split[0]);
//            arr[i][1] = Integer.parseInt(split[1]);
//            pq.add(new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])});
        }
//        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int[] count = new int[N + 1];
        int[] timeOut = new int[N + 1];
        int seat = 0;
//        Map<Integer, Integer> timeOutMap = new HashMap<>();

        while (!pq.isEmpty()){
        int[] ints = pq.poll();
//        for (int[] ints : arr) {
            //자리가 차있는지 map에서 확인
            boolean flag = false;
            for (int i = 1; i <= seat; i++) {
                if (timeOut[i] != 0 && timeOut[i] <= ints[0]) {
                    flag = true;
                    timeOut[i] = ints[1];
                    count[i]++;
                    break;
                }
            }
            //flag가 변경되지 않았으면 추가하고 끝나는 시간 입력
            if (!flag) {
                seat++;
                timeOut[seat] = ints[1];
                count[seat]++;
            }
        }

//            //자리가 차있는지 map에서 확인
//            boolean flag = false;
//            for(int i = 1; i <= seat; i++){
//                if(timeOutMap.containsKey(i) && timeOutMap.get(i) <= cur[0]){
//                    flag = true;
//                    timeOutMap.put(i,cur[1]);
//                    count[i]++;
//                    break;
//                }
//            }
//            //flag가 변경되지 않았으면 추가하고 끝나는 시간 입력
//            if(!flag){
//                seat++;
//                timeOutMap.put(seat,cur[1]);
//                count[seat]++;
//            }
//        }
//    }
        bw.write(seat + "\n");
        for (int i = 1; i <= seat; i++) {
            bw.write(count[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
