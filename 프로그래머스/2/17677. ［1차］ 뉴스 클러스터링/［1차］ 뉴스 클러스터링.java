import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> normalValue(String str, String pt) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            String checkStr = "" + str.charAt(i - 1) + str.charAt(i);
            if (checkStr.matches(pt)) {
                list.add(checkStr);
            }
        }
        return list;
    }

    public int solution(String str1, String str2) {
        int answer = 0;
        String pt = "^[a-z][a-z]$";
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.equals(str2)){
            return 65536;
        }

        List<String> checkedStr1 = normalValue(str1, pt);
        List<String> checkedStr2 = normalValue(str2, pt);
        int equalCount = 0;
        int totalCount = 0;

        for (String str : checkedStr1) {
            if (checkedStr2.contains(str)) {
                equalCount++;
                checkedStr2.remove(str);
            }
            totalCount++;
        }
        for(String str : checkedStr2){
            totalCount++;
        }



        double du = (double) equalCount / totalCount;
        answer = (int) (du * 65536);
        return answer;
    }
}
