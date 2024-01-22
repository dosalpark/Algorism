//두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
//예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
//
//제한 조건
//a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
//a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
//a와 b의 대소관계는 정해져있지 않습니다.
////start
// class Solution {
//    public long solution(int a, int b) {
//        long answer = 0;
//        if((-10000000 <= a && a <= 10000000)&&(-10000000 <= a && a <= 10000000)){
//            if(a<b){
//                for (int i = (b-a) +1; i > 0; i-- ){
//                    answer = answer + a;
//                    a++;
//                }
//            }else if (a>b){
//                //a5 b3
//                //반복문 실행횟수 5-3+1= 3
//                //반복문 a를 1씩 증가하면서 i번만큼 돌리기
//                for (int i = (a-b) + 1; i > 0; i-- ){
//                    answer = answer + b;
//                    b++;
//                }
//            }else {
//                answer = a;
//            }
//        }
//        return answer;
//    }
//}