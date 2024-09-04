import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[][] three = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] index = {0,0,0};
        int[] count = {0,0,0};

        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < 3; j++){
                if(answers[i] == three[j][index[j]]){
                    count[j]++;
                    }
                index[j]++;
                if(index[j] >= three[j].length){
                    index[j] = 0;
                }
            }
        }

        int max = Math.max(count[0], Math.max(count[1],count[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i ++){
            if(count[i] == max){
                list.add(i);
            }
        }
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i) + 1;
        }

        return answer;
    }
}
