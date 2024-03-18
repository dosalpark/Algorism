import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        //맞춘개수 확인
        int cnt = 0; 
        //알아보지못하는 숫자
        int zero = 0;
        // 맞은 숫자와 순위를 합친값
        int rank = 7;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
            } else if (lottos[i] != 0){
                for(int j = 0; j < win_nums.length; j++){
                    if(lottos[i] == win_nums[j]){
                        cnt++;
                    }
                }
            }       
        }
        if(cnt==0){
            cnt = 6;
        } else {
            cnt = rank - cnt; 
        }
        
        if(cnt-zero < 1){
            zero = 1;
        } else {
            zero = cnt - zero;
        }
        answer = new int[]{zero,cnt};
        
        return answer;
    }
}