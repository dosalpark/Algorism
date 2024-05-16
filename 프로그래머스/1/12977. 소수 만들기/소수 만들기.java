class Solution {
    boolean[] bucket;
    
    public void primeBucket(){
        bucket = new boolean[3001];
        for(int i = 2; i < 3001; i++){
            // System.out.println("i : " + i);
            boolean flag = true;
            for(int j = 2; j <= (int)Math.sqrt(i); j++){
                // System.out.println("i : " + i + "/ j : " + j);
                if(i%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                bucket[i] = true;
            }
        }
    }
    
    public int solution(int[] nums) {
        int answer = 0;
        primeBucket();
        
        for(int i = 0; i < nums.length -2; i++){
            for (int j = i +1; j < nums.length -1; j++){
                for (int k = j +1; k < nums.length; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    // System.out.println("sum? : " + sum);
                    if(bucket[sum]){
                        // System.out.println("bucket? : " + bucket[sum]);
                        answer++;
                    }
                }
            }
        }
        



        return answer;
    }
}