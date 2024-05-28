import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[cards.length];
        for (int card : cards) {
            que.add(card);
        }

        while (!que.isEmpty()){
            int cur = que.poll();
            if(visited[cur-1] || cur-1 > cards.length ) continue;
            visited[cur-1] = true;
            int sum = 1;
            while(true){
                int next = cards[cur-1];
                if(visited[next-1] || next-1 > cards.length) break;
                visited[next-1] = true;
                sum++;

                cur = next;
            }
            list.add(sum);
        }
        if(list.size()==1) return answer;
            
        list.sort(Collections.reverseOrder());

        return list.get(0) * list.get(1);
    }
}
