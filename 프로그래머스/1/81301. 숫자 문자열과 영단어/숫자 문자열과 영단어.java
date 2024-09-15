import java.util.HashMap;
import java.util.Map;

class Solution {

    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine"};
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        int i = 0;
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('0' <= ch && ch <= '9') {
                answer.append(ch);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                while (true) {
                    if (i == s.length() - 1) {
                        break;
                    }
                    i++;
                    sb.append(s.charAt(i));
                    if (map.containsKey(sb.toString())) {
                        answer.append(map.get(sb.toString()));
                        break;
                    }
                }

            }
        }
        return Integer.parseInt(answer.toString());
    }
}
