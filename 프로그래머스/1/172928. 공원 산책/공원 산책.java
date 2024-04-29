import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};

        int maxSero = park.length;
        int maxGaro = park[0].length();

        Map<String, int[]> directionMatcher = new HashMap<>();
        directionMatcher.put("N", new int[]{-1, 0});
        directionMatcher.put("S", new int[]{1, 0});
        directionMatcher.put("W", new int[]{0, -1});
        directionMatcher.put("E", new int[]{0, 1});

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                answer[0] = i;
                answer[1] = park[i].indexOf('S');
                break;
            }
        }

        for (String route : routes) {
            String direction = route.split(" ")[0];
            int walk = Integer.parseInt(route.split(" ")[1]);
            boolean flag = true;
            int x = answer[1];
            int y = answer[0];

            for (int i = 1; i <= walk; i++) {
                int[] move = directionMatcher.get(direction);
                x += move[1];
                y += move[0];
                if (y >= maxSero ||
                    x >= maxGaro ||
                    y < 0 ||
                    x < 0) {
                    flag = false;
                    break;
                } else {
                    if (park[y].charAt(x) == 'X') {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                answer[0] = y;
                answer[1] = x;
            }
        }
        return answer;
    }
}