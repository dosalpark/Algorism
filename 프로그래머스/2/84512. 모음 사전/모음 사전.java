import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String word) {

        List<String> dic = new ArrayList<>();
        go("", new char[]{'A', 'E', 'I', 'O', 'U'}, dic);
        return dic.indexOf(word);
    }

    private void go(String now, char[] chars, List<String> dic) {
        if (now.length() > 5) {
            return;
        }

        dic.add(now);
        for (char ch : chars) {
            go(now + ch, chars, dic);
        }
    }
}
