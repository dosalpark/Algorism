//수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
//        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
////start
//import java.util.*;
//class Solution {
//    public int[] solution(int[] answers) {
//        int[] answer = {};
//        //찍는 패턴
//        int[] a = {1,2,3,4,5};
//        int[] b = {2,1,2,3,2,4,2,5};
//        int[] c = {3,3,1,1,2,2,4,4,5,5};
//        int[] score = {0,0,0};
//        for(int i = 0; i < answers.length; i++){
//            // i/패턴 했을때 나머지랑 비교
//            if(answers[i] == a[i%a.length]){
//                score[0] +=1;
//            }
//            if(answers[i] == b[i%b.length]){
//                score[1] +=1;
//            }
//            if(answers[i] == c[i%c.length]){
//                score[2] +=1;
//            }
//        }
//        //제일 높은점수 확인
//        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
//
//        //하나도 못맞췄으면
//        if(maxScore == 0){
//            answer = new int[]{};
//            return answer;
//        }
//
//        //값을 리스트에 저장 후 배열로 전환
//        List<Integer> maxList = new ArrayList<>();
//        for(int i = 0; i < score.length; i++){
//            if(maxScore==score[i]){
//                maxList.add(i+1);
//            }
//        }
//        answer = maxList.stream().mapToInt(i -> i).toArray();
//        return answer;
//    }
//}