import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(int[] arr) {
        int[] answer;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (i != min) {
                list.add(i);
            }
        }
        if(list.size() == 0){
            answer = new int[]{-1};
        } else {
            answer = new int[arr.length-1];
            answer = list.stream().mapToInt(i -> i).toArray();
        }

        return answer;
    }
}
