import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int 작업걸리는시간 = (100 - progresses[0]) / speeds[0];
        if((100 - progresses[0]) % speeds[0] != 0){
            작업걸리는시간++;
        }

        int sum = 1;
        List<Integer> list = new ArrayList<>();


        for(int i = 1; i < progresses.length; i++){
            int diff = 100 - progresses[i];
            int days = diff / speeds[i];
            if(diff % speeds[i] != 0){
                days++;
            }

            if(작업걸리는시간 < days){
                //앞순서보다 늦게성공되면 누적했던 sum을 list에 저장하고 sum 1로 변경
                list.add(sum);
                sum = 1;
                작업걸리는시간 = days;
            } else {
                //앞순서보다 동시? 빨리 성공되면 sum을 증가시키고 넘어감
                sum++;
            }
        }
        list.add(sum);

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
