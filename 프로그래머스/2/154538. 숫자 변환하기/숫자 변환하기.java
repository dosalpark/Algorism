import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        if(x > y){
            return -1;
        }
        return bfs(x,y,n);
    }

    public int bfs(int x, int y, int n){
        Queue<Integer> xQue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int cnt = 0;
        xQue.offer(x);
        visited.add(x);

        while (!xQue.isEmpty()){
            int size = xQue.size();
            for(int i = 0; i < size; i++){
                int transX = xQue.poll();
                if(transX == y){
                    return cnt;
                }

                if(transX+n <= y && !visited.contains(transX+n)){
                    xQue.offer(transX+n);
                    visited.add(transX+n);
                }
                if(transX*2 <= y && !visited.contains(transX*2)){
                    xQue.offer(transX*2);
                    visited.add(transX*2);
                }
                if(transX*3 <= y && !visited.contains(transX*3)){
                    xQue.offer(transX*3);
                    visited.add(transX*3);
                }
            }
            cnt++;
        }
        
        return -1;
    }
}