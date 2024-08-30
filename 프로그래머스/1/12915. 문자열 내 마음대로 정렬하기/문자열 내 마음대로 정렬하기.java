import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        Arrays.sort(strings, Comparator.comparing(o1 -> o1.charAt(n)));
        return strings;
        
    }
}