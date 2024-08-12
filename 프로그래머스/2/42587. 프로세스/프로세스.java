import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();

        for(int priority : priorities){
            list.add(priority);
            pq.add(priority);
        }
        int length = priorities.length;
        int index = 0;

        while(true){
            int cur = pq.poll();
            if(cur == list.get(index)){
                list.set(index,0);
                answer++;

                if(index == location){
                    break;
                }
                continue;
            }

            pq.add(cur);
            index++;

            if(index >= length){
                index = 0;
            }
        }


        return answer;
    }
}
