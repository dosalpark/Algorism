import java.util.*;

class Solution {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int min = Math.min(Arrays.stream(picks).sum() * 5, minerals.length);
        List<String> list = new ArrayList<>();
        int diaSum = 0;
        int ironSum = 0;
        int stoneSum = 0;
        for (int i = 0; i < min; i++) {
            if (minerals[i].equals("diamond")) {
                diaSum += 1;
                ironSum += 5;
                stoneSum += 25;
            } else if (minerals[i].equals("iron")) {
                diaSum += 1;
                ironSum += 1;
                stoneSum += 5;
            } else {
                diaSum += 1;
                ironSum += 1;
                stoneSum += 1;
            }

            if ((i + 1) % 5 == 0 || i == min - 1) {
                list.add(diaSum + " " + ironSum + " " + stoneSum);
                diaSum = 0;
                ironSum = 0;
                stoneSum = 0;
            }
        }
        list.sort((o1, o2) -> {
            if (Integer.parseInt(o1.split(" ")[2]) == Integer.parseInt(o2.split(" ")[2])) {
                if (Integer.parseInt(o2.split(" ")[1]) == Integer.parseInt(o1.split(" ")[1])) {
                    return Integer.parseInt(o2.split(" ")[0]) - Integer.parseInt(o1.split(" ")[0]);
                }
                return Integer.parseInt(o2.split(" ")[1]) - Integer.parseInt(o1.split(" ")[1]);
            }
            return Integer.parseInt(o2.split(" ")[2]) - Integer.parseInt(o1.split(" ")[2]);
        });

        for (int i = 0; i < list.size(); i++) {
            String[] cur = list.get(i).split(" ");
            if (picks[0] != 0) {
                answer += Integer.parseInt(cur[0]);
                picks[0]--;
                continue;
            }
            if (picks[1] != 0) {
                answer += Integer.parseInt(cur[1]);
                picks[1]--;
                continue;
            }
            answer += Integer.parseInt(cur[2]);
        }
        return answer;
    }
}