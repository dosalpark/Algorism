import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> count = new HashSet<>();

        for(int i = 0; i<numbers.length; i++){
            int a = numbers[i];
            for(int j = 0; j<numbers.length; j++){
                if(i != j){
                    count.add(a+numbers[j]);
                }
            }
        }

        answer = new int[count.size()];

        int index = 0;
        for(Integer i : count){
            answer[index] = i;
            index++;
        }

        Arrays.sort(answer);

        return answer;
}
}