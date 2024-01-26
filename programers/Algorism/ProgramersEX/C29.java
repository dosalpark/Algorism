//정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
//단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
////start
//
//class Solution {
//    public int[] solution(int[] arr) {
//        int[] answer = {};
//        //arr배열의 값이 1개일 때
//        if(arr.length <= 1){
//            answer = new int[] {-1};
//        } else {
//            //min: arr배열의 가장낮은값
//            //index: arr배열의 가장 낮은값 기억
//            //j: arr배열 증가시킬 요소
//            int min = arr[0];
//            int index = 0;
//            int j = 0;
//            //min이랑 index에 arr배열의 가장 낮은값 입력
//            for (int i = 0; i < arr.length; i++){
//                if(arr[i] < min) {
//                    min = arr[i];
//                    index = i;
//                }
//            }
//            answer = new int [arr.length-1];
//            //arr배열의 가장낮은값의위치와 i가 동일할 경우 j를 1증가시킴
//            for(int i=0; i < answer.length; i++){
//                if(i == index){
//                    j++;
//                }
//                answer[i] = arr[j];
//                j++;
//            }
//        }
//        return answer;
//    }
//}