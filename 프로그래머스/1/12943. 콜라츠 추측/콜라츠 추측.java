class Solution {
    public int solution(int num) {
        int answer = 0;
        if(num == 1){
            return 0;
        }
        
        long numLong = num;
        
        while(answer < 500){
            answer++;
            if(numLong % 2 == 0){
                numLong /= 2;
            } else {
                numLong = (numLong * 3) +1;
            }
            
            if(numLong == 1){
                break;
            }
            
        }
        
        return answer == 500 ? -1 : answer;
    }
}