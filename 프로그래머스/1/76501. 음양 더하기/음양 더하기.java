class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++){
            int sum = absolutes[i];
            if(!signs[i]){
                sum *= -1;
            }
            
            answer += sum;
            
        }
        return answer;
    }
}