import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        List<Integer> lostList = new ArrayList<>();
        for (int i : lost) {
            lostList.add(i);
        }
        List<Integer> reserveList = new ArrayList<>();
        for (int i : reserve) {
            reserveList.add(i);
        }

        // 여벌 체육복을 가진 학생이 도난당한 경우 제거
        List<Integer> delList = new ArrayList<>();
        for (int i : reserveList) {
            if (lostList.contains(i)) {
                delList.add(i);
            }
        }
        reserveList.removeAll(delList);
        lostList.removeAll(delList);

        Collections.sort(lostList);
        // 체육복 빌려주기
        for (int i = 0; i < lostList.size(); i++) {
            int lostStudent = lostList.get(i);
            if (reserveList.contains(lostStudent - 1)) {
                reserveList.remove((Integer) (lostStudent - 1));
            } else if (reserveList.contains(lostStudent + 1)) {
                reserveList.remove((Integer) (lostStudent + 1));
            } else {
                answer--;
            }
        }

        return answer;
    }
}