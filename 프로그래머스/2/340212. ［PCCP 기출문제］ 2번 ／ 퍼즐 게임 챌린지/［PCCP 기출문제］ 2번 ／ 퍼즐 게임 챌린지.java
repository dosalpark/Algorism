class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        long min = 1;
        long max = 0;
        for (int diff : diffs) {
            if (diff >= max) {
                max = diff;
            }
        }
        int answer = (int) max;

        while (min <= max) {
            long middle = (min + max) / 2;
            long time = 0;

            for (int i = 0; i < diffs.length; i++) {
                if (middle >= diffs[i]) {
                    time += times[i];
                } else {
                    time += ((times[i - 1] + times[i]) * (diffs[i] - middle) + times[i]);
                }
            }

            if (time <= limit) {
                max = middle - 1;
                answer = (int) Math.min(middle, answer);
            } else {
                min = middle + 1;
            }
        }

        return answer;
    }
}
