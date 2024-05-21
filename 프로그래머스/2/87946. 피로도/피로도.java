class Solution {
    int answer;

    public void dfs(int k, int[][] dungeons, boolean[] visited, int sum){
        answer = Math.max(answer, sum);

        for(int i = 0; i < dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, visited, sum +1);
                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);

        return answer;
    }
}
