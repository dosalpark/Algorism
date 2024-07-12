import java.time.LocalDate;
import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;

        Map<String,Integer> termsMap = new HashMap<>();
        for(String term : terms){
            String 타입 = term.split(" ")[0];
            Integer 개월 = Integer.parseInt(term.split(" ")[1]);
            termsMap.put(타입, 개월);
        }

        LocalDate todayDate = converterDate(today);

        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++){
            String type = privacies[i].split(" ")[1];
            LocalDate datePlusTerm = converterDate(privacies[i].split(" ")[0]).plusMonths(termsMap.get(type));


            if(todayDate.isAfter(datePlusTerm) || todayDate.isEqual(datePlusTerm)){
                answerList.add(i);
            }
        }

        answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i) +1;
        }

        return answer;
    }


    private LocalDate converterDate(String date){
        int year = Integer.parseInt(date.split("\\.")[0]);
        int month = Integer.parseInt(date.split("\\.")[1]);
        int day = Integer.parseInt(date.split("\\.")[2]);

        return LocalDate.of(year, month, day);
    }

}
