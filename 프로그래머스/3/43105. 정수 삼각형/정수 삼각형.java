import java.util.Arrays;

class Solution {

    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = triangle.clone();
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[triangle[i].length];
        }
        dp[0][0] = triangle[0][0];



        for (int i = 0; i < triangle.length; i++) {
            if (triangle.length - 1 == i) {
                Arrays.sort(dp[i]);
                answer = dp[i][dp[i].length - 1];
                break;
            }
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i + 1][j] = Math.max(dp[i + 1][j], triangle[i + 1][j] + dp[i][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], triangle[i + 1][j + 1] + dp[i][j]);
            }
        }
        return answer;
    }
}
