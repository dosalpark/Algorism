import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        //1. set에다 넣어서 gem 종류 확인
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int maxGem = set.size();
        
        //2. gem을 종류별로모을수있는 최솟값 설정
        int minLen = Integer.MAX_VALUE;

        //3. 투포인터 L,R 생성 및 gem count 할수있도록 Map 생성
        int L = 0, R = 0;
        Map<String, Integer> gemsCount = new HashMap<>();
        
        //4-1. R이 gems의 len을 넘지않을때까지 실행
        while (R < gems.length) {
            gemsCount.put(gems[R], gemsCount.getOrDefault(gems[R], 0) + 1);
            R++;

            //4-2. 종류가 맞다면 minLen 보다 차가 적은지 확인하고 적으면 answer 저장
            //     L을 좁혀가면서 갯수가 맞을때까지 실행
            while (gemsCount.size() == maxGem) {
                if (R - L < minLen) {
                    minLen = R - L;
                    answer[0] = L + 1;
                    answer[1] = R;
                }

                gemsCount.put(gems[L], gemsCount.get(gems[L]) - 1);
                if (gemsCount.get(gems[L]) == 0) {
                    gemsCount.remove(gems[L]);
                }
                L++;
            }
        }

        return answer;
    }
}
