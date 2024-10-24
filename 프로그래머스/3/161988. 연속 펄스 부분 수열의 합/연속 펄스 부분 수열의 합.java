class Solution {

    public long solution(int[] sequence) {
        long answer = 0;
        long a = 0;
        long b = 0;
        long mul = 1;
        for (int i = 0; i < sequence.length; i++) {
            if (a + sequence[i] * mul >= 0) {
                a += sequence[i] * mul;
                answer = Math.max(answer, a);
            } else {
                a = 0;
            }
            mul *= -1;
            if (b + sequence[i] * mul >= 0) {
                b += sequence[i] * mul;
                answer = Math.max(answer, b);
            } else {
                b = 0;
            }
        }
        return answer;
    }
}
