import java.util.ArrayList;
import java.util.List;

class Solution {
    String[] maps;
    boolean[][] visit;
    int[] dy = {1,0,-1,0};
    int[] dx = {0,1,0,-1};

    public int[] solution(String[] maps) {
        this.maps = maps;
        this.visit = new boolean[maps.length][maps[0].length()];
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if(!visit[i][j] && maps[i].charAt(j) != 'X'){
                    int sum = dfs(i,j,0);
                    list.add(sum);
                }
            }
        }
        if(list.isEmpty()){
            answer = new int[]{-1};
        } else {
            answer = list.stream().sorted().mapToInt(i -> i).toArray();    
        }

        return answer;
    }

    private int dfs(int y, int x, int sum) {

        int nowSum = sum + Integer.parseInt(String.valueOf(maps[y].charAt(x)));
        visit[y][x] = true;

        for(int i = 0; i <= 3; i++){
            int ny = dy[i]+y;
            int nx = dx[i]+x;

            if(0 <= ny && 0 <= nx && ny < maps.length && nx < maps[0].length() && !visit[ny][nx] && maps[ny].charAt(nx) != 'X'){
                nowSum = dfs(ny,nx,nowSum);
            }

        }
        return nowSum;
    }
}
