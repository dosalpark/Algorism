//양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
//
//제한 조건
//x는 1 이상, 10000 이하인 정수입니다.
//
////start
//class Solution {
//    public boolean solution(int x) {
//        boolean answer = false;
//        int sum = 0;
//        int xCopy = x;
//        //제한조건 확인
//        if (1 <= x && x <=10000){
//            //길이 확인 할 String생성
//            String xStr = String.valueOf(x);
//            //각 자릿값 배열에 넣기
//            int[] xArr = new int[xStr.length()];
//            for (int i = 0; i < xStr.length(); i++){
//                xArr[i] = x%10;
//                x /= 10;
//            }
//            //x의 자릿수 더하기
//            for (int j = 0; j < xStr.length(); j++){
//                sum = sum + xArr[j];
//            }
//            // x%sum이 나머지 없을때 true로 변경
//            if(xCopy % sum == 0){
//                answer = true;
//            }
//        }
//        return answer;
//    }
//}