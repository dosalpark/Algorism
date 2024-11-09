import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {


    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        //1. 마을 수 만큼 도착지, 이동거리 저장 할 List배열 생성
        List<int[]>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        //2. road에서 이동할수있는 마을 및 이동거리 위에서 생성한 리스트에 저장
        for (int[] ints : road) {
            int start = ints[0];
            int end = ints[1];
            int weight = ints[2];
            graph[start].add(new int[]{end,weight});
            graph[end].add(new int[]{start,weight});
        }

        //3. 최단 이동거리 저장 할 배열 생성
        int[] weightSave = new int[N+1];
        Arrays.fill(weightSave,Integer.MAX_VALUE);
        weightSave[1] = 0;

        //4. 가중치를 낮은순으로 저장할 PriorityQueue 생성 및 시작점 PQ에 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{1,0});

        //5. 돌면서 저장거리가 낮으면 저장
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            int nowNode = cur[0];
            int nowWeight = cur[1];

            for (int[] next : graph[nowNode]) {
                int nextNode = next[0];
                int nextWeight = next[1];

                if(weightSave[nextNode] > nowWeight+nextWeight && K >= nowWeight+nextWeight){
                    int sumWeight = nowWeight + nextWeight;
                    weightSave[nextNode] = sumWeight;
                    pq.add(new int[]{nextNode, sumWeight});
                }
            }
        }

        //6. 이동거리 저장할 배열에서 K와 값이 같거나 적으면 answer + 1
        for (int i = 1; i < weightSave.length; i++) {
            if(weightSave[i]!= Integer.MAX_VALUE) answer++;
        }
        return answer;
    }
}
