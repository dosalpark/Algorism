import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0){
            return cities.length * 5;
        }

        List<String> list = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String upCity = cities[i].toUpperCase();

            if (list.contains(upCity)) {
                list.remove(upCity);
                list.add(upCity);
                answer++;
            } else {
                if (list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(upCity);
                answer += 5;
            }
        }
        return answer;
    }
}