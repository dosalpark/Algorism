import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int peopleCount = stages.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i : stages) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i = 1; i <= N; i++) {
            if (peopleCount == 0) {
                list.add(i + " " + 0.0);
            } else {
                int fail = map.getOrDefault(i, 0);
                double percent = (double) fail / peopleCount;
                list.add(i + " " + percent);
                peopleCount -= fail;
            }
        }

        list.sort((o1, o2) -> {
            double rate1 = Double.parseDouble(o1.split(" ")[1]);
            double rate2 = Double.parseDouble(o2.split(" ")[1]);
            if (rate1 == rate2) {
                return Integer.parseInt(o1.split(" ")[0]) - Integer.parseInt(o2.split(" ")[0]);
            } else {
                return Double.compare(rate2, rate1);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i).split(" ")[0]);
        }

        return answer;
    }
}
