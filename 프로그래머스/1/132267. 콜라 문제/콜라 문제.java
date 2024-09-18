class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(true){
            if(n < a){
                break;
            }
            int check = (n / a) * b;
            answer += check;
            n = (n % a) + check;
        }
        return answer;
    }
}