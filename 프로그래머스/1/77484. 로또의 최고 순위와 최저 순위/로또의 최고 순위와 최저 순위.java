class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int contain = 0;
        int zero = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    contain++;
                    break;
                }
            }

        }
        answer[0] = 7 - (contain + zero);
        answer[1] = 7 - contain;
        
        if(zero + contain < 2){
            answer[0] = answer[1] = 6;
        }
            
        if(answer[1] == 7)
            answer[1] = 6;

        
        



        return answer;
    }
}