class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i = 1; i <= number; i++){
            int 약수count = 0;
            for(int j = 1; j <= Math.sqrt(i); j++){
                if(i%j == 0){
                  약수count += 2;  
                    if(j==Math.sqrt(i)){
                        약수count--;
                    }
                } 
            }
            if(약수count > limit) answer += power;
            else answer += 약수count;
        }
        
        return answer;
    }
}