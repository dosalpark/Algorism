class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        //최소크기 3*3
        for(int i = 3; i < sum; i++){
            int j = sum / i;
            
            if(j >= 3 && sum % i == 0){
                int x = Math.max(i,j);
                int y = Math.min(i,j);
                int yellowCheck = (x-2) * (y-2);
                
                if(yellow==yellowCheck){
                    answer[0] = x;
                    answer[1] = y;
                    return answer;
                }
            }   
        }
        return answer;
    }
}