//두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
//
//        예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
//        두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
//
////start
//class Solution {
//    public String solution(String X, String Y) {
//        String answer = "";
//
//        int[] xInt = new int [10];
//        //X의 i번째 값을 XInt[i]++
//        for(int i = 0; i < X.length(); i++){
//            xInt[X.charAt(i) -'0']++;
//        }
//        int[] yInt = new int [10];
//        //X의 i번째 값을 XInt[i]++
//        for(int i = 0; i < Y.length(); i++){
//            yInt[Y.charAt(i) -'0']++;
//        }
//
//        //xInt, yInt를 비교해서 더작은값을 checkInt에 입력
//        int[] checkInt = new int [10];
//        for(int i = 0; i < checkInt.length; i++){
//            if(xInt[i] <= yInt[i]){
//                checkInt[i] = xInt[i];
//            } else if (xInt[i] > yInt[i]){
//                checkInt[i] = yInt[i];
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        //역순으로 빌더에 더함
//        for(int i = 9; i >= 0; i--){
//            if(checkInt[i] > 0){
//                for(int j = 0; j < checkInt[i]; j++){
//                    sb.append(i);
//                }
//            }
//        }
//        answer = sb.toString();
//
//        if(answer.isEmpty()){
//            return answer = "-1";
//            //맨앞과 뒤가 같은데 0이면
//        } else if (answer.charAt(answer.length()-1) == answer.charAt(0) && answer.charAt(0) == '0'){
//            return answer = "0";
//        } else {
//            return answer;
//        }
//    }
//}