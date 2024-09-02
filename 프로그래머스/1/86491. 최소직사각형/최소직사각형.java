class Solution {
    public int solution(int[][] sizes) {
        int xMax = 0;
        int yMax = 0;
        for(int[] size : sizes){
            int max = Math.max(size[0],size[1]);
            int min = Math.min(size[0],size[1]);
            
            xMax = Math.max(xMax,max);
            yMax = Math.max(yMax,min);
        }
        
        return xMax*yMax;
    }
}