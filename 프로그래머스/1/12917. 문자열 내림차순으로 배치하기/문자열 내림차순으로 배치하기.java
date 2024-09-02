
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        char[] arr = s.toCharArray();
         for(int i = 0; i < s.length()-1; i++){
             for(int j = i+1; j < s.length(); j++){
                 if(arr[i] < arr[j]){
                    char temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                 }

             }
         }
         for(char ch : arr){
             answer.append(ch);
         }

        return answer.toString();
    }
}
