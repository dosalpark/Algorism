class Solution {
    public int solution(int n) {
        int answer = 1;
        int nDivision = n/2 +1;
        
        for(int i = 1; i < n; i++){
            int sum = i;
            int add = i+1;
            
            while(true){
                if(n == sum){
                    answer++;
                    break;
                } else if (sum > n){
                    break;
                }               
                sum += add;
                add++;
            }            
        }
        return answer;
    }
}