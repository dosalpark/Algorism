import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> sumNums = new ArrayList<>();
        createPrime();
        
        for(int i = 0; i < nums.length -2; i++){
            for(int j = i+1; j < nums.length -1; j++){
                for(int k = j+1; k < nums.length; k++){
                    sumNums.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        
        for(Integer now : sumNums){
            if(set.contains(now)){
                answer++;
            }
        }

        return answer;
    }
    
    private void createPrime(){
        for(int i = 2; i <= 3000; i++){
            boolean flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                set.add(i);
            }
        }
    }
}