import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0, right = people.length -1;
        System.out.println("left + \" / \" + right = " + left + " / " + right);

        while (true){
            if(left == right){
                answer++;
                break;
            }


            if(people[right] + people[left] <= limit){
                answer++;
                if(left+1 == right){
                    break;
                }
                right--; left++;
            } else if(people[right] <= limit){
                answer++;
                if(right==left){
                    break;
                }
                right--;
            }
        }

        return answer;
    }
}
