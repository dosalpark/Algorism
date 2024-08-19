import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<String> que = new LinkedList<>();
        que.add(y+" "+0);
        
        while(true){
            if(que.isEmpty()){
                answer = -1;
                break;
            }    
            
            String cur = que.poll();
            int ny = Integer.parseInt(cur.split(" ")[0]);
            int count = Integer.parseInt(cur.split(" ")[1]);
            
            if(ny == x){
                answer = count;
                break;
            }
            int nCount = count+1;
            if(ny-n >= x){
                que.add(ny-n+" "+nCount);
            }
            if(ny%2 == 0 && ny/2 >= x){
                que.add(ny/2+" "+nCount);
            }
            if(ny%3 == 0 && ny/3 >= x){
                que.add(ny/3+" "+nCount);
            }

        }
        
        return answer;
    }
}