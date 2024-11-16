import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] distinct = new int[n + 1];
        for (int i = 1; i < distinct.length; i++) {
            if (i == destination) {
                distinct[i] = 0;
            } else {
                distinct[i] = Integer.MAX_VALUE;
            }
        }

        List<Integer>[] moveRoads = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            moveRoads[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            moveRoads[road[0]].add(road[1]);
            moveRoads[road[1]].add(road[0]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{destination, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            cur[1]++;

            for (Integer node : moveRoads[cur[0]]) {
                if (distinct[node] > cur[1]) {
                    distinct[node] = cur[1];
                    pq.add(new int[]{node, cur[1]});
                }
            }
        }

        int index = 0;
        for (int source : sources) {
            if(distinct[source] == Integer.MAX_VALUE){
                answer[index++] = -1;
            } else {
                answer[index++] = distinct[source];
            }
        }
        
        return answer;
    }
}
