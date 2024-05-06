class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            int gift = n/a * b;
            n = n%a;
    
            answer += gift;
            n += gift;
           
        }
        return answer;
    }
}