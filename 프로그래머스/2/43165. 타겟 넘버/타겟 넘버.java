import java.util.*;
class Solution {
    int answer;
    int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        answer = 0;
        numbers = numbers;
        target = target;

        go(0,0, target, numbers);

        return answer;
    }

    private void go(int depth, int sum, int target, int[] numbers){
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        int number = numbers[depth];

        go(depth+1,sum + number, target, numbers);
        go(depth+1,sum - number, target, numbers);
    }
}