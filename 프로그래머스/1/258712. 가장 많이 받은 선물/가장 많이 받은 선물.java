import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] nextMonthCount = new int[friends.length];

        Map<String, Integer> toFromCountMap = new HashMap<>();
        Map<String, Integer> giftRank = new HashMap<>();
        for (String gift : gifts) {
            String to = gift.split(" ")[0];
            String from = gift.split(" ")[1];
            toFromCountMap.put(gift, toFromCountMap.getOrDefault(gift,0) +1);
            giftRank.put(to, giftRank.getOrDefault(to, 0) + 1);
            giftRank.put(from, giftRank.getOrDefault(from, 0) - 1);
        }

        for(int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (friends[i].equals(friends[j])) {
                    continue;
                }
                String toIFromJ = friends[i] + " " + friends[j];
                String toJFromI = friends[j] + " " + friends[i];
                if (toFromCountMap.getOrDefault(toIFromJ,0) > toFromCountMap.getOrDefault(toJFromI,0)) {
                    nextMonthCount[i]++;
                } else if ((toFromCountMap.getOrDefault(toIFromJ,0) == toFromCountMap.getOrDefault(toJFromI,0))) {
                    if (giftRank.getOrDefault(friends[i],0) > giftRank.getOrDefault(friends[j],0)) {
                        nextMonthCount[i]++;
                    }
                }
            }
            if(answer < nextMonthCount[i]){
                answer = nextMonthCount[i];
            }
        }
        return answer;
    }
}