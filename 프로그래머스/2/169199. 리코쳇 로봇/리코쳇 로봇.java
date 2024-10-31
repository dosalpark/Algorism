import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int maxY = board.length;
        int maxX = board[0].length();
        int[] R = new int[2];
        int[] G = new int[2];
        //출발,도착위치 찾기
        for (int i = 0; i < board.length; i++) {
            if (board[i].indexOf('R') != -1) {
                R = new int[]{i, board[i].indexOf('R')};
            }
            if (board[i].indexOf('G') != -1) {
                G = new int[]{i, board[i].indexOf('G')};
            }
        }
        //charArray로 변환
        char[][] arrayBoard = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            arrayBoard[i] = board[i].toCharArray();
        }

        Queue<YXCount> queue = new LinkedList<>();
        arrayBoard[R[0]][R[1]] = 'X';
        queue.add(new YXCount(R[0], R[1], 0));

        while (!queue.isEmpty()) {
            YXCount cur = queue.poll();
            arrayBoard[cur.Y][cur.X] = 'X';
            if (cur.Y == G[0] && cur.X == G[1]) {
                answer = cur.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.Y;
                int nx = cur.X;
                while (ny + dy[i] < maxY && nx + dx[i] < maxX && ny + dy[i] >= 0 && nx + dx[i] >= 0
                    && arrayBoard[ny + dy[i]][nx + dx[i]] != 'D') {
                    ny += dy[i];
                    nx += dx[i];
                }
                if (arrayBoard[ny][nx] == '.') {
                    arrayBoard[ny][nx] = 'X';
                    queue.add(new YXCount(ny, nx, cur.count + 1));
                } else if (arrayBoard[ny][nx] == 'G') {
                    queue.add(new YXCount(ny, nx, cur.count + 1));
                }
            }
        }



        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private boolean lenCheck(int ny, int nx, int maxY, int maxX, char[][] arrayBoard) {
        return 0 <= ny && 0 <= nx && ny < maxY && nx < maxX && arrayBoard[ny][nx] != 'D'
            && arrayBoard[ny][nx] != 'X';
    }


    public class YXCount {

        private int Y;
        private int X;
        private int count;

        public YXCount(int Y, int X, int count) {
            this.Y = Y;
            this.X = X;
            this.count = count;
        }
    }
}
