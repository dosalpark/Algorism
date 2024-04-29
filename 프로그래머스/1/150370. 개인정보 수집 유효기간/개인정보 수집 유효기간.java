import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);
        List<Integer> checkPrivacy = new ArrayList<>();


        for (int i = 0; i < privacies.length; i++) {
            String type = privacies[i].split(" ")[1];
            LocalDate date = LocalDate.parse(privacies[i].split(" ")[0], formatter);

            for (String term : terms) {
                if (type.equals(term.split(" ")[0])) {
                    date = date.plusMonths(Long.parseLong(term.split(" ")[1])).minusDays(1L);
                }
            }
            if (date.isBefore(todayDate)) {
                checkPrivacy.add(i + 1);
            }
        }
        return checkPrivacy.stream().mapToInt(Integer::intValue).toArray();
    }
}