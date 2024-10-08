class Solution {
    public int solution(int n) {
        int answer = 0;
        int checkN = Integer.bitCount(n);
        int checkNext = 0;
        while(true){
            n++;
            checkNext = Integer.bitCount(n);
            if(checkN == checkNext){
                answer = n;
                break;
            }
        }

        return answer;
    }
}