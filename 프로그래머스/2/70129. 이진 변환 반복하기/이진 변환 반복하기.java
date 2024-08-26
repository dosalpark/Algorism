class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};

        while(true){
            if(s.equals("1")){
                break;
            }
            
            int zeroCount = 0;
            int oneCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            
            answer[0]++;
            answer[1] += zeroCount;

            s = Integer.toString(oneCount,2);
        }


        return answer;
    }
}
