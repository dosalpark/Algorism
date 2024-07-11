class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int r = 12, l = 10;
        
        for(int number : numbers){
            if(number==1 || number==4 || number==7){
                l = number;
                answer += "L";
            }else if(number==3 || number==6 || number==9){
                r = number;
                answer += "R";
            } else {
                if(number == 0) {
                    number = 11;
                }
                int rRow = (r-1)/3;
                int lRow = (l-1)/3;
                int rCol = (r-1)%3;
                int lCol = (l-1)%3;
                int numRow = (number-1)/3;
                int numCol = (number-1)%3;
                
                int rCount = Math.abs(numRow-rRow) + Math.abs(numCol-rCol);
                int lCount = Math.abs(numRow-lRow) + Math.abs(numCol-lCol);
                
                if(rCount==lCount){
                    if(hand.charAt(0)=='r'){
                        r = number;
                        answer += "R";
                    } else {
                        l = number;
                        answer += "L";
                    }
                } else if(rCount<lCount){
                    r = number;
                    answer += "R";
                } else {
                    l = number;
                    answer += "L";
                }
            }
            
        }
        return answer;
    }
}