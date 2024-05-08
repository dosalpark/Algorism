import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Set<String> distinctReport = new HashSet<>(List.of(report));
        Map<String, Integer> idIndexMap = new HashMap<>();
        Map<String, Set<String>> badUserReportersMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            idIndexMap.put(id_list[i], i);
            badUserReportersMap.put(id_list[i], new HashSet<>());
        }

        for (String re : distinctReport) {
            String badUser = re.split(" ")[1];
            String reporter = re.split(" ")[0];
            badUserReportersMap.get(badUser).add(reporter);
        }

        for (int i = 0; i < id_list.length; i++) {
            if (badUserReportersMap.get(id_list[i]).size() >= k) {
                for (String reporter : badUserReportersMap.get(id_list[i])) {
                    answer[idIndexMap.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}