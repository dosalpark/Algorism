import java.util.HashMap;
import java.util.Map;

class Solution {

    int[] answer;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        Map<String, Integer> userMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            userMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            dfs(seller[i], amount[i] * 100, userMap, referral);
        }

        return answer;
    }

    private void dfs(String seller, int amount, Map<String, Integer> userMap, String[] referral) {
        int nowUserIndex = userMap.get(seller);
        //1. 금액이 나눠떨어지는 확인
        if (amount / 10 == 0) {
            //2. 나머지가 0이면 그냥 입금하고 끝
            answer[nowUserIndex] += amount;
            return;
        }
        //3. 나눠 떨어진다면 나눠서 입금
        int nowUserMoney = amount - (amount / 10);
        answer[nowUserIndex] += nowUserMoney;
        //4. 상위유저가 '-'가 아니면 dfs 다시 호출
        String upperUser = referral[nowUserIndex];
        if (!upperUser.equals("-")) {
            dfs(upperUser, amount / 10, userMap, referral);
        }
    }
}
