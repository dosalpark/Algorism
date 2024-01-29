//단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다
//
////start
//class Solution {
//    public String solution(String s) {
//        String answer = "";
//        String splitString[] = s.split("");
//        int middle = splitString.length/2;
//
//        if(splitString.length % 2 == 0){
//            //짝수일때
//            answer += splitString[middle-1] + splitString[middle];
//        } else {
//            //홀수일때
//            answer += splitString[middle];
//        }
//        return answer;
//    }
//}