//정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//0 < n ≤ 1000
//
////start
//class Solution {
//    public int solution(int n) {
//        int answer = 0;
//
//        //n의 입력범위
//        if(0 < n && n <= 1000){
//            //i를 2씩 증가하면서 짝수값만 answer에 취합
//            for (int i = 0; i <= n; i=i+2){
//                answer += i;
//            }
//        }
//        return answer;
//    }
//}