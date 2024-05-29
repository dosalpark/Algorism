class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int max = t * m;
        StringBuilder sb = new StringBuilder();
        //총 구해야하는 갯수 t*m
        for(int i = 0; i < 99999; i++){
            String converter = Integer.toString(i,n).toUpperCase();
            sb.append(converter);
            
            if(max < sb.length()) break;
        }
        
        for(int i = p-1; i < sb.length(); i = i + m){
            if(t == 0) break;
            answer+= "" + sb.charAt(i);
            t--;
        }
        
        
        return answer;
    }
}