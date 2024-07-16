import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < want.length; i++){
            for(int j = 0; j < number[i]; j++){
                list.add(want[i]);
            }
        }
        
        for(int i = 0; i < discount.length -9; i++){

            List<String> copyList = new ArrayList<>(list);
            for(int j = i; j < i+10; j++){
                if(copyList.contains(discount[j])){
                    copyList.remove(discount[j]);
                } else {
                    break;
                }
            }
            if(copyList.isEmpty()) answer++;
        }
        
        return answer;
    }
}

//13-9
//4

