import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    int maxValue;

    public String[] solution(String[] orders, int[] course) {
        List<String> ans = new ArrayList<>();
        for (int n : course) {
            Map<String, Integer> map = new HashMap<>();
            maxValue = 0;
            for (String order : orders) {
                int len = order.length();
                if (len < n) {
                    continue;
                }
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                boolean[] visit = new boolean[order.length()];
                combination(len, n, 0, map, arr, visit);
            }
            if (maxValue <= 1) {
                continue;
            }

            for (Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
                String key = stringIntegerEntry.getKey();
                int value = stringIntegerEntry.getValue();
                if (value == maxValue) {
                    ans.add(key);
                }
            }
        }
        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }

    private void combination(int len, int check, int start, Map<String, Integer> map, char[] arr,
        boolean[] visit) {
        if (check == 0) {
            addMap(map, arr, visit);
            return;
        }
        for (int i = start; i < len; i++) {
            visit[i] = true;
            combination(len, check - 1, i + 1, map, arr, visit);
            visit[i] = false;
        }
    }

    private void addMap(Map<String, Integer> map, char[] arr, boolean[] visit) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                sb.append(arr[i]);
            }
        }
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        maxValue = Math.max(maxValue, map.get(sb.toString()));
    }
}
