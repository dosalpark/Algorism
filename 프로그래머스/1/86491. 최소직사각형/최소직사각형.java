class Solution {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        
        for (int[] size : sizes){
            if(x < Math.max(size[0],size[1])){
                x = Math.max(size[0],size[1]);
             }
            if(y < Math.min(size[0],size[1])){
                y = Math.min(size[0],size[1]);
            }
        }
        return x * y;
    }
}