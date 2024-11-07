import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> genreSumMap = new HashMap<>();
        Map<String, List<int[]>> indexMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            //누적시간 구하기
            genreSumMap.put(genres[i], genreSumMap.getOrDefault(genres[i], 0) + plays[i]);
            //각 인덱스별 시간 구하기
            List<int[]> list;
            if (indexMap.containsKey(genres[i])) {
                list = indexMap.get(genres[i]);
            } else {
                list = new ArrayList<>();
            }
            list.add(new int[]{i, plays[i]});
            indexMap.put(genres[i], list);
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(genreSumMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Entry<String, Integer> entry : entryList) {
            List<int[]> getIndexList = indexMap.get(entry.getKey());
            if (getIndexList.size() <= 1) {
                answerList.add(getIndexList.get(0)[0]);
            } else {
                Collections.sort(getIndexList, (o1, o2) -> {
                    return o2[1] - o1[1];
                });

                for (int i = 0; i < 2; i++) {
                    answerList.add(getIndexList.get(i)[0]);
                }
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
