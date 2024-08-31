import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Queue<Integer> que = new LinkedList<>();
        int before = arr[0];
        que.add(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == before){
                continue;
            }
            que.add(arr[i]);
            before = arr[i];
        }
        
        answer = new int[que.size()];
        int index = 0;
        while(!que.isEmpty()){
            answer[index] = que.poll();
            index++;
        }
        

        return answer;
    }
}