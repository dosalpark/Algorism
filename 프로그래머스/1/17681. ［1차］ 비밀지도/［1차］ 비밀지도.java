class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            String binaryArr1 = String.format("%"+n+"s",Integer.toBinaryString(arr1[i])).replace(" ","0");
            String binaryArr2 = String.format("%"+n+"s",Integer.toBinaryString(arr2[i])).replace(" ","0");
            
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){              
                
                if(binaryArr1.charAt(j) == '0' && binaryArr2.charAt(j) == '0'){
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
                
            answer[i] = sb.toString();
            }
        }
        
        return answer;
    }
}