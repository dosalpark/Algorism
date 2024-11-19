import java.util.Arrays;

class Solution {

    public int solution(int[][] scores) {
        int answer = 1;
        int[] OH = scores[0];
        int OHSum = OH[0] + OH[1];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });

        int maxB = 0;
        for (int i = 0; i < scores.length; i++) {
            int A = scores[i][0];
            int B = scores[i][1];
            if (OH[0] < A && OH[1] < B) {
                return -1;
            }
            if (B >= maxB) {
                maxB = B;
                if (A + B > OHSum) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
