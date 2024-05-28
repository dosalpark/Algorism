class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        while (true){
            if(s.equals("1")) break;

            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0') answer[1]++;
            }

            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }

        return answer;
    }
}
