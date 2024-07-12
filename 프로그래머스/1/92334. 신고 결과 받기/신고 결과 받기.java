//신고당한 횟수 저장해야하고
//key사람/value 날신고한사람 -> 일단 자기가 신고한사람으

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> index = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>(); 
        
        for(int i = 0; i < id_list.length; i++){
            
            index.put(id_list[i],i);
            map.put(id_list[i],new HashSet());
        }
        
        for(String 신고 : report){
            String 신고자 = 신고.split(" ")[0];
            String 용의자 = 신고.split(" ")[1];
            map.get(용의자).add(신고자);
        }
        
        for(String 용의자 : id_list){
            if(map.get(용의자).size() >= k){
                for(String 신고자 : map.get(용의자)){
                    answer[index.get(신고자)]++;
                }
            
            }
        }
        
        return answer;
    }
}