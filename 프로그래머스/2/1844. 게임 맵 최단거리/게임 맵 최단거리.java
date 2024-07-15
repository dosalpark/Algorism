//

import java.util.*;
class Solution {
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0,1});
    
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int y = cur[0];
            int x = cur[1];
            int count = cur[2];
            
            if(y == maps.length -1 && x == maps[0].length -1){
                return count;
            }
            
            for(int i = 0; i < 4; i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(nx >= 0 && ny >= 0 && nx < maps[0].length && ny < maps.length && maps[ny][nx] == 1){
                    maps[ny][nx] = 0;
                    que.add(new int []{ny,nx,count+1});
                }
            }
        }
        
        return -1;
    }
    
}