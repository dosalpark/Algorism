import java.util.*;
class Solution {

    public int[] solution(String s) {
        int[] answer = {};
        Set<String> set = new LinkedHashSet<>();
        String[] arr = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                return o1.length() - o2.length();
            }
        });

        for (String string : arr) {
            for(String str : string.split(",")){
                set.add(str);
            }
        }

        answer = new int[set.size()];
        int i = 0;
        for (String string : set) {
            answer[i] = Integer.parseInt(string);
            i++;
        }

        return answer;
    }
}
