import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for(int i : topping){
            left.put(i,left.getOrDefault(i,0)+1);
        }

        for(int i = topping.length -1; i >= 0; i--) {
            if(left.get(topping[i]) > 1){
                left.put(topping[i], left.get(topping[i]) -1);
            } else if (left.get(topping[i]) == 1){
                left.remove(topping[i]);
            }
            right.put(topping[i], left.getOrDefault(topping[i],0)+1);

            if(left.size() == right.size()){
                answer++;
            }
        }

        return answer;
    }
}
