import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        int index = -1;
        char last = words[0].charAt(0);
        boolean flag = false;
        Set<String> set = new HashSet<>();

        for(String word : words){
            index++;
            int beforeSetSize = set.size();
            set.add(word);

            if(word.charAt(0) != last || beforeSetSize == set.size()){
                flag = true;
                break;
            }
            last = word.charAt(word.length()-1);
        }

        if(flag){
            answer[0] = (index % n) +1;
            answer[1] = (index / n) +1;
        }

        return answer;
    }
}
