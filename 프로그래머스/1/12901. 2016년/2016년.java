import java.time.DayOfWeek;
import java.time.LocalDate;

class Solution {
    public String solution(int a, int b) {

        LocalDate now = LocalDate.of(2016,a,b);
        String week = now.getDayOfWeek().toString();
        return week.substring(0,3).toUpperCase();
    }
}
