import java.util.PriorityQueue;

class Solution {
    public int solution(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr){
            pq.add(i);
        }

        while (pq.size() >= 2){
            int one = pq.poll();
            int two = pq.poll();

            int gcb = gcb(one,two);

            pq.add(one * (two / gcb));
        }
        return pq.poll();
    }

    private int gcb(int one, int two) {

        if(two%one == 0){
            return one;
        }
        return gcb(two%one,one);
    }
}
