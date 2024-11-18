class Solution {

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] diff = new int[board.length + 1][board[0].length + 1];

        for (int[] ints : skill) {
            int r1 = ints[1];
            int r2 = ints[3];
            int c1 = ints[2];
            int c2 = ints[4];
            int type = ints[0] == 1 ? -1 : 1;
            int degree = ints[5] * type;

            diff[r1][c1] += degree;
            diff[r2 + 1][c2 + 1] += degree;
            diff[r2 + 1][c1] -= degree;
            diff[r1][c2 + 1] -= degree;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 1; i < board.length; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] += diff[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
