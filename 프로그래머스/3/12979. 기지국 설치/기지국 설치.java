import java.util.ArrayList;
import java.util.List;

class Solution {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int oneLine = w * 2 + 1;
        List<int[]> notInstall = new ArrayList<>();
        if (stations[0] - w - 1 > 0) {
            notInstall.add(new int[]{1, stations[0] - w - 1});
        }

        for (int i = 0; i < stations.length; i++) {
            int S = stations[i] + w + 1;
            int E;
            if (i == stations.length - 1) {
                E = n;
            } else {
                E = stations[i + 1] - w - 1;
            }

            if (S <= E) {
                notInstall.add(new int[]{S, E});
            }
        }

        for (int[] ints : notInstall) {
            int len = ints[1] - ints[0] + 1;
            answer += len % oneLine == 0 ? len / oneLine : len / oneLine + 1;
        }
        return answer;
    }
}
