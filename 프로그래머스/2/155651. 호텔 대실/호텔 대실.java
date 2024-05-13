import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] sortBooking = new int[book_time.length][2];
        List<String> bookingList = new ArrayList<>();
        List<Integer> checkList = new ArrayList<>();

        for (int i = 0; i < book_time.length; i++) {
            String[] reservation = book_time[i];
            String startReserv = reservation[0];
            String endReserv = reservation[1];
            int startTime = (Integer.parseInt(startReserv.split(":")[0]) * 60) + Integer.parseInt(
                startReserv.split(":")[1]);
            int endTime = (Integer.parseInt(endReserv.split(":")[0]) * 60) + Integer.parseInt(
                endReserv.split(":")[1]);
            sortBooking[i][0] = startTime;
            sortBooking[i][1] = endTime;
        }

        Arrays.sort(sortBooking, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        for (int[] ints : sortBooking) {
            if (checkList.isEmpty()) {
                checkList.add(ints[1] + 10); //끝나는시간
                answer++;
                continue;
            }
            boolean flag = false;
            for (Integer i : checkList) {
                if (ints[0] >= i) {
                    checkList.remove(i);
                    checkList.add(ints[1]+10);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                answer++;
                checkList.add(ints[1]+10);
            }
        }
        return answer;
    }
}