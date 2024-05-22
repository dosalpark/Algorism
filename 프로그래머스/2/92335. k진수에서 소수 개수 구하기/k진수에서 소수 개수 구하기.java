class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String nStr = Integer.toString(n,k);
        nStr = nStr.replaceAll("101 | 0", "");
        nStr = nStr.replaceAll("0", " ");
        nStr = nStr.replaceAll("\\s+", " ").trim();
        
        String[] numbers = nStr.split(" ");
        
        for(String numberStr : numbers){
            long number = Long.parseLong(numberStr);
            
            if(number == 0 || number == 1) continue;
            boolean flag = true;
            
            for(int i = 2; i <= (int)Math.sqrt(number); i++){
                if(number%i == 0){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}



    
    