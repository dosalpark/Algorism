//정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
//
//        제한 사항
//n은 0 이상 3000이하인 정수입니다.
//
////start
//class Solution {
//    public int solution(int n) {
//        int answer = 0;
//        //n의 범위 제한
//        if(0<= n || n <=3000){
//            //n이 i로 나누어질때 answer에 i를 추가
//            for (int i = 1; i <= n; i++){
//                if (n%i == 0) {
//                    answer += i;
//                }
//            }
//        }
//        return answer;
//    }
//}