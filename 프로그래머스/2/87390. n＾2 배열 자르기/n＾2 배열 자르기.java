class Solution {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int index = 0;
        for (long i = left; i <= right; i++) {
            if (i / n == 0) {
                answer[index] = (int) (i % n + 1);
            } else {
                if (i / n >= i % n) {
                    answer[index] = (int) (i / n + 1);
                } else {
                    answer[index] = (int) (i % n + 1);
                }
            }

            index++;
        }
        return answer;
    }
}
