import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int solution(int[] elements) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < elements.length; i++) {
                list.add(elements[i]);
            }
        }
        Set<Integer> set = new HashSet<>();
        int len = 1;
        set.add(Arrays.stream(elements).sum());
        while (len < elements.length) {
            for(int i = 0; i < elements.length; i++){
                int add = 0;
                for(int j = 0; j < len; j++){
                    add += list.get(i+j);
                }
                set.add(add);
            }
            len++;
        }
        return set.size();
    }
}
