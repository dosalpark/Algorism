import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while(true){
            if(n%2 == 1){
                n--;
                ans++;
            } else {
                n /= 2;
            }
            
            if(n==0) break;
        }
        
        
        
        return ans;
    }
}