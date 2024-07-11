class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0,0,1,-1};
        int[] dw = {1,-1,0,0};
        int max = board.length;
        String select = board[h][w];
        
        for(int i = 0; i < 4; i++){
            int nh = h + dh[i];
            int nw = w + dw[i];
            
            if(nh >= 0 && max > nh && nw >= 0 && max > nw){
                if(board[nh][nw].equals(select)){
                    answer++;   
                }
            }    
        }
        return answer;
    }
}