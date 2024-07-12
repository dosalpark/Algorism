import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        map.put("R",0);
        map.put("C",0);
        map.put("J",0);
        map.put("A",0);
        map.put("T",0);
        map.put("F",0);
        map.put("M",0);
        map.put("N",0);
        
        for(int i = 0; i < choices.length; i++){
            int score = choices[i] - 4;
            
            if(score < 0){
                String type = "" + survey[i].charAt(0);
                map.put(type, map.get(type) + Math.abs(score));
            } else if(score > 0){
                String type = "" + survey[i].charAt(1);
                map.put(type, map.get(type) + Math.abs(score));
            }
        }
        
        answer.append(checkChoice("R","T"));
        answer.append(checkChoice("C","F"));
        answer.append(checkChoice("J","M"));
        answer.append(checkChoice("A","N"));     
        
        return answer.toString();
    }
    
    private String checkChoice(String first, String second){
        if(map.get(first) >= map.get(second)){
            return first;
        } else {
            return second;
        }
    }
}