import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int playerCount = players.length;
        String[] answer = new String[playerCount];
        
        Map<String,Integer> mapOfPlayer = new HashMap<>();
        for(int i = 0; i < playerCount; i++){
            mapOfPlayer.put(players[i],i);
        }
        
        for(String call : callings){
            //순위호ㅏㄱ인
            int rank = mapOfPlayer.get(call);
            
            
            mapOfPlayer.put(players[rank], rank-1);
            mapOfPlayer.put(players[rank-1], rank);
            
            String temp = players[rank];
            players[rank] = players[rank-1];
            players[rank-1] = temp;
        }
        
        for(String player : players){
            int rank = mapOfPlayer.get(player);
            answer[rank] = player;
        }
        
        return answer;
    }
}