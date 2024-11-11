import java.util.Arrays;

class Solution {

    public int solution(int[][] board) {
        int answer = 1;
        boolean isOne = false;
        for (int i = 0; i < board.length; i++) {
            if(Arrays.stream(board[i]).sum() != 0){
                isOne = true;
            }
            if(i == 0) continue;
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0)  continue;
                board[i][j] =
                    Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }
        if(answer==1 && !isOne){
            return 0;
        }

        return answer * answer;
    }
}
