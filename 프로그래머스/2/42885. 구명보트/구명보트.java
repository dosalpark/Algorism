import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int f = 0;
        int l = people.length -1;

        while(f <= l){
            if(limit >= people[f] + people[l]){
                answer++;
                f++;
                l--;
                continue;
            } else {
                answer++;
                l--;
            }
        }

        return answer;
    }
}