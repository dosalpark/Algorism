class Solution {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int max = Math.max(n, m);
        int min = Math.min(n, m);

        answer[0] = gcb(max, min);
        answer[1] = (max*min) / answer[0];

        return answer;
    }

    private int gcb(int max, int min) {
        if (max % min == 0) {
            return min;
        }
        return gcb(min, max % min);
    }
}
