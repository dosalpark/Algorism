class Solution {

    int[][] dungeons;

    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        this.dungeons = dungeons;

        for (int i = 0; i < dungeons.length; i++) {
            boolean[] visit = new boolean[dungeons.length];
            int sum = dfs(k, visit, i, 0);
            answer = Math.max(sum, answer);
        }
        return answer;
    }

    private int dfs(int k, boolean[] visit, int in, int sum) {
        if (dungeons[in][0] <= k) {
            visit[in] = true;
            k -= dungeons[in][1];
            sum += 1;
        } else {
            return sum;
        }

        int max = sum;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i]) {
                max = Math.max(max,dfs(k, visit, i, sum));
            }
        }
        visit[in] = false;
        return max;
    }
}
