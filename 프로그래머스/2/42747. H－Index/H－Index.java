import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        //citations[i]가 1이고 n 4일때 1이 들어가야함
        //citations[i]가 5이고 n 2일때 2가 들어가야함
        for(int i = 0; i < citations.length; i++){
            int n = citations.length - i;
    
            //citation[i] >= n 이 처음되는 순간이 고점임
            if(citations[i] >= n){
                answer = n;
                break;
            }
        }
        return answer;
    }
}