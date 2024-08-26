class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String kNumbers = Long.toString(n,k);
        String[] kNumber = kNumbers.split("0");
        
        for(String number : kNumber){
            if(!number.isEmpty() && !number.equals("1") && check(number)){
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean check(String number){
        long num = Long.parseLong(number);

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
        
    }
}