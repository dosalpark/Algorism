class Solution {
    public int solution(int n) {
        if(n == 1){
            return 1;
        }
        int answer = 0;
        int left = 1;
        int right = 2;
        int sum = 3;

        while (right <= n && left <= n) {
            if (sum >= n) {
                if (sum == n) {
                    answer++;
                }
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        return answer;
    }
}