import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pque = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> que = new LinkedList<>();
        for(int i : priorities){
            pque.add(i);
            que.add(i);
        }

        
        while(true){
            if(que.peek() == pque.peek() && location ==0){
                pque.poll();
                break;
            }
            if(que.peek() == pque.peek()){
                que.poll();
                pque.poll();
                if(location == 0) location = que.size();
                location--;
                answer++;
            } else {
                int cur = que.poll();
                que.add(cur);
                if(location == 0) location = que.size();
                location--;
            }
        }
        
        return priorities.length - pque.size();
    }
}

//911111 119111 0
//911111 19111'1' 5
//911111  911111 1 -> 11111  111'1'1 4
//1111 11'1'1 3
//111 1'1'1  2
//11 '1'1  1
//