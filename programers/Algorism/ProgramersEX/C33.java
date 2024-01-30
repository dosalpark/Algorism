//두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서,
//약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
//
////start
//
//class Solution {
//    public int solution(int left, int right) {
//        int answer = 0;
//        //left~right까지
//        for(int i=left; i<=right; i++) {
//            int count = 1;
//            //자기자신은 미리 count에 포함하고 i/2로 설정
//            for(int j=1; j<=i/2; j++) {
//                if(i % j == 0){
//                    count++;
//                }
//            }
//            //약수의 갯수의 따라 +-적용
//            if(count % 2 == 0) {
//                answer += i;
//            }else {
//                answer -= i;
//            }
//        }
//
//        return answer;
//    }
//}