import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public int dfs(int x, int y, int maxX, int maxY, Set<Integer> set, int[][] land) {
        Queue<int[]> que = new LinkedList<>();
        land[y][x] = 2;
        que.add(new int[]{y,x});
        int amount = 1;
        set.add(x);

        while (!que.isEmpty()){
            int[] cur = que.poll();
            for (int j = 0; j < 4; j++) {
                int ny = dy[j] + cur[0];
                int nx = dx[j] + cur[1];
                if (ny >= 0 && nx >= 0 && ny < maxY && nx < maxX && land[ny][nx] == 1) {
                    que.add(new int[]{ny,nx});
                    set.add(nx);
                    amount++;
                    land[ny][nx] = 2;
                }
            }
        }
        return amount;
    }


    public int solution(int[][] land) {
//        this.land = land;
        int X = land[0].length;
        int Y = land.length;
        int answer = 0;
        int[] line = new int[X];

        for (int i = 0; i < land[0].length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1) {
                    Set<Integer> set = new HashSet<>();
                    int amount = dfs(i, j, X, Y, set, land);
                    for (Integer integer : set) {
                        line[integer] += amount;
                        if(line[integer] > answer){
                            answer = line[integer];
                        }
                    }
                }
            }

        }
        return answer;
    }
}