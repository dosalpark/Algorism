import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        //스테이지에 멈춰있는 사람이 몇인지 구하기
        Map<Integer,Integer> standMap = new HashMap<>();
        
        for(int i = 0; i < stages.length; i++){ //0~4
            standMap.put(stages[i],standMap.getOrDefault(stages[i],0) +1);
        }
        
        //스테이지별 실패율
        double users = stages.length;
        Map<Integer,Double> failMap = new HashMap<>();
        
        for (int i = 1; i <= N; i++){
            if(standMap.containsKey(i)){
                failMap.put(i, standMap.get(i)/users);
                users -= standMap.get(i);
            }else{
                failMap.put(i, 0.0);
            }
        }
        
        
        List<Integer> sortStages = new ArrayList<>(failMap.keySet());
        Collections.sort(sortStages, (s1, s2) -> failMap.get(s2).compareTo(failMap.get(s1)));
        
        for(int i = 0; i < N; i++){
            answer[i] = sortStages.get(i);
        } 
        
        return answer;
    }
}