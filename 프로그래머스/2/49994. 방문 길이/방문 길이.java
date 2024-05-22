import java.util.*;
class Solution {    
    public int solution(String dirs) {
        int[][] dydx = {{1,0},{-1,0},{0,-1},{0,1}};
        
        int answer = 0;
        Set<String> set = new HashSet<>();
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0});
        
        for(int i = 0; i < dirs.length(); i++){
            int[] now = que.poll();
            char move = dirs.charAt(i);
            int go = 0;
            if(move == 'U') go = 0;
            else if(move == 'D') go = 1;
            else if(move == 'L') go = 2;
            else if(move == 'R') go = 3;
            
            int ny = now[0]+dydx[go][0];
            int nx = now[1]+dydx[go][1];
            
            if(ny >= -5 && ny <=5 && nx >= -5 && nx <=5){
                que.add(new int[]{ny,nx});
                // System.out.println("nowY-" + now[0] + "/ nowX- "+ now[1] + "/ moveY-" +ny + "/ moveX-" + nx);
                set.add(now[0]+","+now[1]+","+ny+","+nx);
                set.add(ny+","+nx+","+now[0]+","+now[1]);
            } else {
                que.add(now);
            }
        }        
        return set.size()/2;
    }
}