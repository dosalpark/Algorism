import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String input = "님이 들어왔습니다.";
        String output = "님이 나갔습니다.";
        
        for(String r : record){
            String[] arr = r.split(" ");
            if(!arr[0].equals("Leave")){
                map.put(arr[1],arr[2]);
            }
        }
        
        for(String re : record){
            String inout = re.split(" ")[0];
            String uid = re.split(" ")[1];
            if(inout.equals("Enter")){
                list.add(map.get(uid) + input);
            } else if (inout.equals("Leave")){
                list.add(map.get(uid) + output);
            }
        }
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
//         
//         
        // return answer;
        return list.stream().map(i -> i).toArray(String[]::new);
    }
}