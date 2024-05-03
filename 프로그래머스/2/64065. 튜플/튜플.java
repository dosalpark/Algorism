import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(String s) {
        Map<String, Integer> resultMap = new HashMap<>();
        
        s = s.substring(2,s.length() -2);
        String[] sArray = s.split("\\},\\{");
        
        for(String str : sArray){
            String[] numArr = str.split(",");
            for(String num : numArr){ 
                resultMap.put(num, resultMap.getOrDefault(num, 0) + 1);    
            }
        }
        
        List<String> keyList = new ArrayList<>(resultMap.keySet());
        keyList.sort((s1, s2) -> resultMap.get(s2) - resultMap.get(s1));
        
        int[] answer = new int[keyList.size()];
            
        for(int i = 0; i < answer.length; i++){
            answer[i] = Integer.parseInt(keyList.get(i));
        }
        
        return answer;
    }
}