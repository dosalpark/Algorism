import java.util.*;
class Solution {    
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        int zeroCount = 0;
        for (int i = 0; i < numbers.length; i++){
            strNumbers[i] = String.valueOf(numbers[i]);
            if(numbers[i] == 0){
                zeroCount++;
            }
        }
        if(zeroCount == numbers.length){
            return "0";
        }
        
        Arrays.sort(strNumbers, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(String strNumber : strNumbers){
            sb.append(strNumber);
        }
        
        return sb.toString();
    }
}