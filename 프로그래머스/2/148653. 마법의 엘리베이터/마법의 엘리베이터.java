
class Solution {
    public int solution(int storey) {
        int answer = 0;
        int floor = 1;
        while (true){
            if(storey == 0){
                break;
            }

            if(storey%10 == 0){
                while(true){
                    storey /= 10;
                    if(storey%10 != 0) break;
                }
            }

            if(storey%10 > 5){
                storey += floor;
            } else if(storey%10 < 5){
                storey -= floor;
            } else {
                if(storey%100 >= 50){
                    storey += floor;
                } else {
                    storey -= floor;
                }
            }
            answer++;
        }
        return answer;
    }
}
