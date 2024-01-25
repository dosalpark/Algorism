//0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
////start
//
//class Solution {
//    public int solution(int[] numbers) {
//        //0~9 더한 값 입력
//        int answer = 45;
//        //numbers배열 길이만큼 돌려서 나온값을 45 -
//        for (int i = 0; i < numbers.length; i++){
//            answer -= numbers[i];
//        }
//        //if가 값 변동이없으면 -1 설정
//        if(answer == 45){
//            answer = -1;
//        }
//        return answer;
//    }
//}