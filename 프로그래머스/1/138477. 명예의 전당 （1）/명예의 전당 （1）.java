import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> bucket = new ArrayList<>();

        for (int i = 0; i < score.length; i++){
            bucket.add(score[i]);
            Collections.sort(bucket);
            if(bucket.size() > k)
                bucket.remove(0);
            answer[i] = bucket.get(0);
        }
        return answer;
    }
}