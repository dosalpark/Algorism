import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            String cur = String.valueOf(s.charAt(i));
            if(list.contains(cur)){
                answer[i] = i - list.lastIndexOf(cur);
            } else {
                answer[i] = list.lastIndexOf(cur);
            }
            list.add(cur);
        }
        
        return answer;
    }
}