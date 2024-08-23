import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, Comparator.comparing(o -> o[0]));
        PriorityQueue<Integer> room = new PriorityQueue<>();

        for (String[] strings : book_time) {
            String inHour = strings[0].split(":")[0];
            String inMin = strings[0].split(":")[1];
            String outHour = strings[1].split(":")[0];
            String outMin = strings[1].split(":")[1];
            int inTime = Integer.parseInt(inHour) * 60 + Integer.parseInt(inMin);
            int outTime = Integer.parseInt(outHour) * 60 + Integer.parseInt(outMin);

            if(room.isEmpty()){
                room.add(outTime);
                if(answer == 0){
                    answer++;
                }
                continue;
            }

            if(room.peek() +10 <= inTime){
                room.poll();
                room.add(outTime);
            } else {
                room.add(outTime);
                answer++;
            }
        }


        return answer;
    }
}
