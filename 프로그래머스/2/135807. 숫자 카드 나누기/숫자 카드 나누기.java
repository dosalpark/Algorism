import java.util.*;
class Solution {    
    public boolean divisionFail(int[] array, int i){
        for(int now : array){
            if(now%i == 0){
                return false;
            }
        }
        return true;
    }
    
    public int gcd(int arrayNum, int num){
        if(num==0) return arrayNum;
        return gcd(num, arrayNum%num);
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        
        for(int i = 1; i < arrayA.length; i++){
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }       
        
        if(divisionFail(arrayB, gcdA)){
            answer = Math.max(answer,gcdA);
        }
        if(divisionFail(arrayA, gcdB)){
            answer = Math.max(answer,gcdB);
        }
        
        return answer;
    }
}