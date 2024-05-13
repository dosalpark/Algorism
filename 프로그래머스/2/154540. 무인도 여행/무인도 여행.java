import java.util.*;
class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    int cnt;
    String[] maps;

    public int[] solution(String[] maps) {
        this.maps = maps;

        int x = maps[0].length();
        int y = maps.length;
        boolean[][] visited = new boolean[y][x];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visited[j][i] && maps[j].charAt(i) != 'X') {
                    cnt = 0;
                    dfs(j, i, visited);
                    list.add(cnt);
                }
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        } else {
            Collections.sort(list);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private void dfs(int y, int x, boolean[][] visited) {
        visited[y][x] = true;
        cnt+= maps[y].charAt(x) -'0';
        System.out.println("cnt = " + cnt);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < visited[0].length && ny >= 0 && ny < visited.length && !visited[ny][nx] && maps[ny].charAt(nx) != 'X')
                dfs(y + dy[i], x + dx[i], visited);
        }
    }
}
