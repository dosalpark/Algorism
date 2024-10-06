import java.util.HashSet;
import java.util.Set;

class Solution {

    public int solution(int m, int n, String[] board) {
        String[][] changeBoard = new String[board.length][board[0].length()];
        for (int i = 0; i < changeBoard.length; i++) {
            changeBoard[i] = board[i].split("");
        }
        int answer = 0;
        int[] dx = {0, 0, 1, 1};
        int[] dy = {0, 1, 0, 1};
        while (true){
            Set<int[]> set = new HashSet<>();

            //체크
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (!changeBoard[i][j].equals(".") &&
                        changeBoard[i][j].equals(changeBoard[i + dy[1]][j + dx[1]]) &&
                        changeBoard[i][j].equals(changeBoard[i + dy[2]][j + dx[2]]) &&
                        changeBoard[i][j].equals(changeBoard[i + dy[3]][j + dx[3]])) {
                        set.add(new int[]{i, j});
                    }
                }
            }
            if(set.isEmpty()){
                break;
            }

            //삭제
            for (int[] yx : set) {
                int y = yx[0];
                int x = yx[1];

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (!changeBoard[ny][nx].equals(".")) {
                        answer++;
                        changeBoard[ny][nx] = ".";
                    }
                }
            }

            //칸조절
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (changeBoard[i][j].equals(".")) {
                        int index = i - 1;
                        while (index >= 0) {
                            if (changeBoard[index][j].equals(".")) {
                                index--;
                                continue;
                            }
                            changeBoard[i][j] = changeBoard[index][j];
                            changeBoard[index][j] = ".";
                            break;
                        }
                    }
                }
            }

        }

        return answer;
    }
}
