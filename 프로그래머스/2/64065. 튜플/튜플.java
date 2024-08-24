import java.util.*;
class Solution {

    public int[] solution(String s) {
        int[] answer = {};
        Set<String> set = new HashSet<>();
        String[] arr = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                return o1.length() - o2.length();
            }
        });
        answer = new int[arr.length];


        int i = 0;
        for (String string : arr) {
            for(String str : string.split(",")){
                if(set.add(str)){
                    answer[i] = Integer.parseInt(str);
                    i++;
                };
            }
        }

        return answer;
    }
}
