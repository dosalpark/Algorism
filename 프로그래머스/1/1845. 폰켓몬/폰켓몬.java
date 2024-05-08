import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        if(map.size() > max){
            return max;
        } else {
            return map.size();
        }
    }
}