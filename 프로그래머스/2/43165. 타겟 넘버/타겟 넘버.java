class Solution {
    int answer;
    int target;
    int[] numbers;
    
    public void dfs(int index, int sum){
        //탈출
        if(index >= numbers.length){
            if(target==sum ){
                answer++;
            }
            return;
        }
        
        //동작
        dfs(index+1,sum+numbers[index]);
        dfs(index+1,sum-numbers[index]);
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        
        dfs(0,0);
        return answer;
    }
}