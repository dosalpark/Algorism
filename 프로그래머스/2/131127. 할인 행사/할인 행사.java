import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        List<String> wishList = new LinkedList<>();
        for(int i = 0; i < number.length; i++){
            for(int j = 0; j < number[i]; j++){
                wishList.add(want[i]);
            }
        }


        for (int i = 0; i <= discount.length -10; i++){

            List<String> day10Discount = new ArrayList<>(List.of(Arrays.copyOfRange(discount,i,i+10)));
            for (String s : wishList) {
                day10Discount.remove(s);
            }
            if(day10Discount.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}