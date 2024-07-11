//선물준거를 확인해서 서로 같으면 지수비교임

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String,Integer> gitfScore = new HashMap<>();
        Map<String,Integer> tradeScore = new HashMap<>();
        Map<String,Integer> count = new HashMap<>();
        
        for(String gift : gifts){
            String sender = gift.split(" ")[0];
            String recipient = gift.split(" ")[1];
            
            gitfScore.put(gift,gitfScore.getOrDefault(gift, 0) +1);
            
            tradeScore.put(sender,tradeScore.getOrDefault(sender, 0) +1);
            tradeScore.put(recipient,tradeScore.getOrDefault(recipient, 0) -1);
        }
        
        for(int i = 0; i < friends.length; i++){
            for(int j = i+1; j < friends.length; j++){
                int value = 0;
                String iSendj = friends[i] + " " + friends[j];
                String jSendi = friends[j] + " " + friends[i];
                int iSendjCount = gitfScore.getOrDefault(iSendj, 0);
                int jSendiCount = gitfScore.getOrDefault(jSendi, 0);
                
                if(iSendjCount>jSendiCount){
                    value = count.getOrDefault(friends[i], 0) +1;
                    count.put(friends[i], value);
                } else if(iSendjCount<jSendiCount){
                    value = count.getOrDefault(friends[j], 0) +1;
                    count.put(friends[j], value);
                } else {
                    int iTrade = tradeScore.getOrDefault(friends[i], 0);
                    int jTrade = tradeScore.getOrDefault(friends[j], 0);
                    
                    if(iTrade > jTrade){
                        value = count.getOrDefault(friends[i], 0) +1;
                        count.put(friends[i], value);
                    } else if (jTrade > iTrade){
                        value = count.getOrDefault(friends[j], 0) +1;
                        count.put(friends[j], value);
                    }
                }
                answer = Math.max(answer, value);
            }
        }
        return answer;
    }
}