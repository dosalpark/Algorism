import java.util.Map;
import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.put(name, map.getOrDefault(name,0) +1);
        }
        for (String name : completion) {
            map.put(name,map.get(name)-1);
        }

        for (String name : map.keySet()) {
            if(map.get(name) != 0){
                answer = name;
                break;
            }
        }
        
        //Iterator 사용
//        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String,Integer> entry = iterator.next();
//            if (entry.getValue() != 0){
//                answer = entry.getKey();
//                break;
//            }
//        }
        return answer;
    }
}