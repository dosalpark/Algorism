import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int j = 0; j < commands.length; j++){
            List<Integer> list = new ArrayList<>();
            for(int i = commands[j][0] -1; i < commands[j][1]; i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            answer[j] = list.get(commands[j][2]-1);
        }
        
        return answer;
    }
}