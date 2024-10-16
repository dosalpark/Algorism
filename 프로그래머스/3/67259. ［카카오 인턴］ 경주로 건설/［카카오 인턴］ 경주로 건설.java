import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int maxLen = board.length - 1;
        int overLen = board.length;
        int[] dy = {-1, 1, 0, 0};  
        int[] dx = {0, 0, -1, 1};  
        int[][][] costMap = new int[board.length][board[0].length][4]; 
        for (int[][] row : costMap) {
            for (int[] dirCost : row) {
                Arrays.fill(dirCost, Integer.MAX_VALUE);  
            }
        }

        Queue<Go> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) { 
            queue.add(new Go(0, 0, i, 0)); 
            costMap[0][0][i] = 0;
        }

        while (!queue.isEmpty()) {
            Go cur = queue.poll();

            
            if (cur.x == maxLen && cur.y == maxLen) {
                answer = Math.min(answer, cur.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (0 <= ny && ny < overLen && 0 <= nx && nx < overLen && board[ny][nx] == 0) {
                    int cost = cur.cost + (cur.dir == i ? 100 : 600);

                    if (cost < costMap[ny][nx][i]) {
                        costMap[ny][nx][i] = cost;
                        queue.add(new Go(ny, nx, i, cost));
                    }
                }
            }
        }
        return answer;
    }

    public class Go {
        private int y;
        private int x;
        private int dir; 
        private int cost;

        public Go(int y, int x, int dir, int cost) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cost = cost;
        }
    }
}
