import java.util.Arrays;

class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int maxLen = B.length - 1;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[maxLen - i];
        }

        return answer;
    }
}
