import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int num : arr){
            if(num%divisor == 0){
                list.add(num);
            }
        }
        
        if(list.isEmpty()){
            return new int[] {-1};
        } else {
            return list.stream().sorted().mapToInt(s -> s).toArray();
        }
    }
}