import java.util.HashSet;
import java.util.Set;

class Solution {

    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < skip.length(); i++) {
            set.add(skip.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int j = 0;
            while (j < index) {
                ch = (char) (ch + 1);
                if('z' < ch){
                    ch = 'a';
                }
                if(!set.contains(ch)){
                    j++;
                }
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}
