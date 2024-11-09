class Solution {

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            boolean[] visit = new boolean[n-1];
            visit[i] = true;
            int cnt = dfs(wires[i][0], wires, 1, visit);
            int check = (n-cnt) - cnt;

            answer = Math.min(answer, Math.abs(check));
        }
        return answer;
    }

    private int dfs(int connect, int[][] wires, int count, boolean[] visit) {
        for (int i = 0; i < wires.length; i++) {
            if ((wires[i][0] == connect || wires[i][1] == connect) && !visit[i]) {
                visit[i] = true;
                if (wires[i][0] == connect) {
                    count = dfs(wires[i][1], wires, count + 1, visit);
                } else {
                    count = dfs(wires[i][0], wires, count + 1, visit);
                }
            }
        }
        return count;
    }

}
