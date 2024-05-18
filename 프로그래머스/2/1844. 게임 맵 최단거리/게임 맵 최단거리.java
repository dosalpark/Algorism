import java.util.*;
class Solution {
    public int bfs(int[][] maps){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0,0,1});
        maps[0][0] = 0;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0] == maps.length -1 && cur[1] == maps[0].length -1){
                return cur[2];
            }

            for(int i = 0; i < 4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(ny >= 0 && nx >= 0 && ny < maps.length && nx < maps[0].length && maps[ny][nx] == 1){
                    que.add(new int[] {ny,nx,cur[2]+1});
                    maps[ny][nx] = 0;
                    
                }
            }
        }
        return -1;

    }

    public int solution(int[][] maps) {
        int answer = 0;

        answer = bfs(maps);
        return answer;
    }
}
