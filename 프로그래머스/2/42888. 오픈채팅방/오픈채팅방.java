import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String enter = "님이 들어왔습니다.";
        String exit = "님이 나갔습니다.";
        int count = 0;
        Map<String, String> uidMap = new HashMap<>();

        for(String r : record){
            String action = r.split(" ")[0];
            if(action.equals("Leave")) continue;
            String uid = r.split(" ")[1];
            String name = r.split(" ")[2];
            uidMap.put(uid,name);
        }

        List<String> list = new ArrayList<>();
        for(String r : record){
            String action = r.split(" ")[0];
            String uid = r.split(" ")[1];
            if(action.equals("Change")) {
                continue;
            } else if(action.equals("Enter")){
                list.add(uidMap.get(uid)+enter);
            } else {
                list.add(uidMap.get(uid)+exit);
            }
        }
        return list.toArray(String[]::new);
    }
}
