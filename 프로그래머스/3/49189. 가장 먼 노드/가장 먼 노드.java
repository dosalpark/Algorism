import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int solution(int n, int[][] edge) {
        int answer = 0;
        //1. 위치 담을 배열 생성
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        //2. 출발지 목적지를 연결할 PQ배열 생성
        List<Integer>[] lists = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        //3. edge에 있는 경로를 각 PQ에 저장
        for (int[] e : edge) {
            int S = e[0];
            int E = e[1];
            lists[S].add(E);
            lists[E].add(S);
        }

        //4. while문으로 queue 넣어서 시작
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int S = cur[0];
            int len = cur[1];

            for (Integer integer : lists[S]) {
                if (len + 1 < distance[integer]) {
                    distance[integer] = len + 1;
                    q.add(new int[]{integer, len + 1});
                }
            }
        }

        //5. 위치담은 배열에서 제일 큰값 뽑아서 카운팅
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 2; i < distance.length; i++) {
            pq.add(distance[i]);
        }
        int max = pq.peek();
        while (pq.peek() == max){
            pq.poll();
            answer++;
        }

        return answer;
    }
}
