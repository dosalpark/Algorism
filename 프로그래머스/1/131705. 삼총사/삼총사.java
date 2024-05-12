import java.util.*;
class Solution {
    int[] number;
    boolean[] visited;
    int answer;
    
    public void dfs(int index, int sum, int depth, boolean[] visited){
        //탈출
        if(depth==3){
            if(sum==0){
                answer++;
            }
            return;
        }
        
        //동작
        System.out.println("index : " + index + "/ sum : " + sum + "/ depth : " + depth);
        for(int i = index; i < number.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, sum+number[i], depth+1, visited);    
                visited[i] = false;
            }
        }
        
    }
    
    public int solution(int[] number) {
        this.number = number;
        answer = 0;
        visited = new boolean[number.length];
        
        
        dfs(0,0,0, visited);
        
        return answer;
    }
}