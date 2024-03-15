import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;

        //rank를 정립
        Map<String,Integer> rank = new HashMap<>();
        for (int i =0; i< players.length;i++){
            rank.put(players[i],i);
        }

        //callings 에서 불린 calling을 찾아서 교체
        for (String calling : callings) {
            //현재 순위
            int callOfPlayerRank = rank.get(calling);
            //앞사람찾고
            String frontCallingPlayer = answer[callOfPlayerRank-1];
            int frontCallOfPlayerRank = rank.get(frontCallingPlayer);
            //교체
            rank.replace(calling,frontCallOfPlayerRank);
            rank.replace(frontCallingPlayer, callOfPlayerRank);

            String changePlayer = calling;
            answer[callOfPlayerRank] = answer[callOfPlayerRank-1];
            answer[callOfPlayerRank-1] = changePlayer;
        }
        return answer;
    }
}