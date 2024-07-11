import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int round = attacks[attacks.length-1][0];
        int endtime = bandage[0];
        int secondheal = bandage[1];
        int timeheal = bandage[2];
        int sumtime = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] attack : attacks){
            map.put(attack[0],attack[1]);
        }
        
        
        for(int i = 1; i <= round; i++){
            System.out.println("현재라운드:" + i);
            if(map.containsKey(i)){
                int damage = map.get(i);
                answer -= damage;
                sumtime = 0;
                System.out.println("[타격]현재체력:" + answer);
                
                if(answer <= 0){
                    answer = -1;
                    System.out.println("[DIE]");
                    break;
                }
            } else {
                answer = answer + secondheal > health ? health : answer + secondheal;
                sumtime++;
                System.out.println("[초당회복]현재체력:" + answer);
                
                if(sumtime == endtime){
                    sumtime = 0;
                    answer = answer + timeheal > health ? health : answer + timeheal;
                    System.out.println("[추가회복]현재체력:" + answer);
                }
            }
        }
        return answer;
    }
}
