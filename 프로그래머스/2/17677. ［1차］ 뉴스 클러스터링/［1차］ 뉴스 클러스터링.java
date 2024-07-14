import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i = 1; i < str1.length(); i++){
            String substr = str1.substring(i-1,i+1);
            if(substr.matches("[a-z][a-z]")){
                list1.add(substr);
            }
        }
        for(int i = 1; i < str2.length(); i++){
            String substr = str2.substring(i-1,i+1);
            if(substr.matches("[a-z][a-z]")){
                list2.add(substr);
            }
        }
        
        
        int total = list1.size() + list2.size();
        int list1size = list1.size();
        int list2size = list2.size();
        
        
        for(String str : list1){
            list2.remove(str);
        }
        
        int 교 = list2size - list2.size(); //중복값
        int 합 = total - 교;
        
        
        return answer = 합 == 0 ? 65536 : 65536*교/합;
    }
}

//ha an nd ds sh ha ak ke  count 16, 합 8, 교 8 
//sh ha ak ke ha an nd ds