import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> que = new LinkedList<>();
        
        if(cacheSize == 0){
            return 5 * cities.length;
        }

        for (String city : cities) {
            city = city.toLowerCase();
            if(que.size() < cacheSize){
                if(que.contains(city)){
                    que.remove(city);
                    answer -=4;
                }
               que.add(city);
               answer += 5;
               continue;
            }

            if(que.contains(city)){
                que.remove(city);
                answer++;
            } else {
                que.poll();
                answer += 5;
            }
            que.add(city);
        }
        return answer;
    }
}
