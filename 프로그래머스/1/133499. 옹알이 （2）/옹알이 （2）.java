class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] joka = {"aya", "ye", "woo", "ma"};
        
        for(String bab : babbling){
            boolean flag = true;
            String last = "";
            
            while(bab.length() != 0){
                int length = bab.length();
                for(String j : joka){
                    if(bab.startsWith(j) && !j.equals(last)){
                        last = j;
                        bab = bab.substring(j.length());
                        continue;
                        
                    }
                }
                if(length == bab.length()){
                    flag = false;
                    break;
                } else {
                    System.out.println(bab);
                }
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}