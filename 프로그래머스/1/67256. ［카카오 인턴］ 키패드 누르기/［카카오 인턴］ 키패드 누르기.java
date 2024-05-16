import java.util.Map;
import java.util.HashMap;
class Solution {
    public boolean isRight(String hand, int[] number, int[] left_finger, int[] right_finger){
        int rightX = Math.abs(number[1] - right_finger[1]);
        int leftX = Math.abs(number[1] - left_finger[1]);
        int rightY = Math.abs(number[0] - right_finger[0]);
        int leftY = Math.abs(number[0] - left_finger[0]);
        int right = rightX + rightY;                              
        int left = leftX + leftY;
        
        if(left == right){
            if(hand.equals("right")){
                return true;
            } else {
                return false;
            }
        } else if (left < right){
            return false;
        } else {
            return true;
        }
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] left_finger = new int[]{3,0}, right_finger = new int[]{3,2};
        
        Map<Integer,int[]> map = new HashMap();
        map.put(0, new int[]{3,1});
        int n = 1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                map.put(n, new int[]{i,j});
                n++;
            }
        }
        
        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                answer += "L";
                left_finger = map.get(number);
            } else if(number == 3 || number == 6 || number == 9){
                answer += "R";
                right_finger = map.get(number);
            } else {
                int[] numberPosition = map.get(number);
                if(isRight(hand, numberPosition, left_finger, right_finger)){
                    answer += "R";
                    right_finger = map.get(number);
                } else {
                    answer += "L";
                    left_finger = map.get(number);
                }
            }
        }
        return answer;
    }
}