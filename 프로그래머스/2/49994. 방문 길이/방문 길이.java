import java.util.ArrayList;
import java.util.List;

class Solution {

    public int solution(String dirs) {
        int[] now = {0, 0};
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<String> list = new ArrayList<>();

        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int moving = 0;
            switch (ch) {
                case 'U':
                    moving = 0;
                    break;
                case 'D':
                    moving = 1;
                    break;
                case 'R':
                    moving = 2;
                    break;
                case 'L':
                    moving = 3;
                    break;
            }

            if (now[0] + move[moving][0] >= -5 && now[0] + move[moving][0] <= 5 &&
                now[1] + move[moving][1] >= -5 && now[1] + move[moving][1] <= 5) {
                String d = "" + now[0] + now[1];
                String n = "" + (now[0] + move[moving][0]) + (now[1] + move[moving][1]);

                if (!list.contains(d + n)) {
                    list.add(d + n);
                    list.add(n + d);
                }
                now[0] = now[0] + move[moving][0];
                now[1] = now[1] + move[moving][1];

            }


        }
        return list.size() / 2;
    }
}
