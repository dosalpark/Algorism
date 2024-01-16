//함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
//
//        제한 조건
//x는 -10000000 이상, 10000000 이하인 정수입니다.
//n은 1000 이하인 자연수입니다.
//
////start
//class Solution {
//    public long[] solution(int x, int n) {
//        long[] answer = new long[n];
//        //x부터 시작해 x씩 증가 숫자 n개
//        if((-10000000 <= x && x <=10000000 ) && (0 <= n && n < 1000)){
//            for(int i = 0; i < n; i++){
//                //x의 값변형 없게 i + 1 로 조절
//                //int범위 넘어가서 에러.. long으로 형변환
//                answer[i] = (long)x * (i + 1);
//            }
//        }
//        return answer;
//    }
//}
