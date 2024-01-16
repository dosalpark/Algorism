//임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
//n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
//
//제한 사항
//n은 1이상, 50000000000000 이하인 양의 정수입니다.
//
////start
//class Solution {
//    public long solution(long n) {
//        long answer = -1;
//        //이렇게 했으나 n이 0이 들어오면 -1을 for문 빠져나가버림
//        // for(long i = 0; i < n ; i++){
//        for(long i = 0; i <= n ; i++){
//            //i*i = n이 나오면 제곱근으로 판단.
//            if(i*i==n){
//                //제곱근일 경우 i에 +1해서 제곱근 answer에 대입
//                answer = (i + 1) * (i + 1);
//                break;
//                //아닐경우 answer에 -1 입력
//            }
//        }
//        return answer;
//    }
//}