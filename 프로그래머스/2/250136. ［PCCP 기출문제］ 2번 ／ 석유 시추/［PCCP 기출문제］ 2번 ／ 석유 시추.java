import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    public int solution(int[][] land) {
        int[] line = new int[land[0].length];
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        int answer = 0;

        for (int i = 0; i < land[0].length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1) {
                    YX now = new YX(j, i);
                    Queue<YX> queue = new LinkedList<>();
                    Set<Integer> petroleumLine = new HashSet<>();
                    int petroleum = 1;
                    petroleumLine.add(i);
                    land[j][i] = 0;
                    queue.add(now);
                    while (!queue.isEmpty()) {
                        YX cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int ny = cur.Y + dy[k];
                            int nx = cur.X + dx[k];
                            if (check(ny, nx, land)) {
                                land[ny][nx] = 0;
                                petroleum++;
                                petroleumLine.add(nx);
                                queue.add(new YX(ny, nx));
                            }
                        }
                    }
                    for (Integer integer : petroleumLine) {
                        line[integer] += petroleum;
                        answer = Math.max(answer,line[integer]);
                    }
                }
            }
        }
    
        return answer;
    }

    private boolean check(int ny, int nx, int[][] land) {
        int maxY = land.length;
        int maxX = land[0].length;
        return 0 <= ny && ny < maxY && 0 <= nx && nx < maxX && land[ny][nx] == 1;
    }

    public class YX {

        private int Y;
        private int X;

        YX(int Y, int X) {
            this.Y = Y;
            this.X = X;
        }
    }
}