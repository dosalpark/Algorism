class Solution {

    boolean[] visit;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (!visit[i]) {
                answer++;
                dfs(computers, i);
            }
        }
        return answer;
    }

    private void dfs(int[][] computers, int now) {
        visit[now] = true;
        for (int i = 0; i < computers[now].length; i++) {
            if (!visit[i] && computers[now][i] == 1) {
                dfs(computers, i);
            }
        }
    }
}
