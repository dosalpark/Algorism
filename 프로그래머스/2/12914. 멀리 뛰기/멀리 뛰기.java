class Solution {
    public long solution(int n) {
        long answer = 1;
        long n1 = 1; 
        long n2 = 1; 
        
        for (int i = 1; i < n; i++) {
            answer = (n1 + n2) % 1234567;
            n1 = n2;
            n2 = answer;
        }
        
        return answer;
    }
}