import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> sortMap = new HashMap<>();
        sortMap.put("code", 0);
        sortMap.put("date", 1);
        sortMap.put("maximum", 2);
        sortMap.put("remain", 3);

        Arrays.sort(data, (o1, o2) -> {
            return o1[sortMap.get(sort_by)]-o2[sortMap.get(sort_by)];
        });

        List<int[]> answer = new ArrayList<>();
        for (int[] singleData : data) {
            if (singleData[sortMap.get(ext)] < val_ext) {
                answer.add(singleData);
            }
        }
        return answer.toArray(int[][]::new);
    }
}