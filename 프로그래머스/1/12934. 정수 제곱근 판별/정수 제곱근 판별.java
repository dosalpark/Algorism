class Solution {
    public long solution(long n) {
        long answer = -1;
        //이렇게 했으나 n이 0이 들어오면 -1을 for문 빠져나가버림
        // for(long i = 0; i < n ; i++){
        for(long i = 0; i <= n ; i++){
            //i*i = n이 나오면 제곱근으로 판단.
            if(i*i==n){
                //제곱근일 경우 i에 +1해서 제곱근 answer에 대입
                answer = (i + 1) * (i + 1);
                break;
            //아닐경우 answer에 -1 입력
            }
        }
        return answer;
    }
}