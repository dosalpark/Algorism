//자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
//        예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
//
//제한사항
//N의 범위 : 100,000,000 이하의 자연수
//
////start
//import java.util.*;
//
//public class Solution {
//    public int solution(int n) {
//        int answer = 0;
//        int mok = 0;
//        if (n <= 100000000){
//            //입력받은 값이 0이 될때까지 돌음
//            while(n!=0){
//                //입력받은 값 10으로 나눠서 나머지값 저장
//                mok = n%10;
//                answer = answer + mok;
//                n = n / 10;
//            }
//        }
//        return answer;
//    }
//}