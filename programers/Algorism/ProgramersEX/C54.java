//2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
//두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
//요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다.
//예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
//
////start
//import java.util.*;
//class Solution {
//    public String solution(int a, int b) {
//        List<Integer> one = new ArrayList<>(Arrays.asList(1,3,5,7,8,10,12));
//        List<Integer> two = new ArrayList<>(Arrays.asList(4,6,9,11));
//        //첫날이 금요일이니 +4
//        b += 4;
//
//        //달에따라서 일수 추가
//        for(int i = 1; i < a; i++){
//            if(one.contains(i)){
//                b += 31;
//            } else if (two.contains(i)){
//                b += 30;
//            } else {
//                b += 29;
//            }
//        }
//        //요일수(7)로 나눔
//        switch(b%7){
//            case 0: return "SUN";
//            case 1: return "MON";
//            case 2: return "TUE";
//            case 3: return "WED";
//            case 4: return "THU";
//            case 5: return "FRI";
//            case 6: return "SAT";
//            default: return "-1";
//        }
//    }
//}