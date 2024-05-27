import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


class Solution {
    Set<String> set = new HashSet<>();
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] chars = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length(); j++){
                chars[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            for(int y = chars.length -1; y >= 0; y--){
                for (int x = 0; x < chars[0].length; x++){
                    if(chars[y][x] == '.') {
                        dotCheck(x,y,chars);
                    }
                }
            }

            for(int y = 0; y < chars.length; y++){
                for (int x = 0; x < chars[0].length; x++){
                    if(chars[y][x] != '.')
                        fourCheck(x,y,chars);
                }
            }

            if(set.isEmpty()) break;

            answer += set.size();

            for (String next : set) {
                int yy = Integer.parseInt(next.split(" ")[0]);
                int xx = Integer.parseInt(next.split(" ")[1]);
                chars[yy][xx] = '.';
            }
            set.clear();
        }
        return answer;
    }

    private void dotCheck(int x, int y, char[][] chars) {
        for(int i = y -1; i >= 0; i--){
            if(chars[i][x] != '.'){
                chars[y][x] = chars[i][x];
                chars[i][x] = '.';
                break;
            }
        }
    }

    public void fourCheck(int nowX, int nowY, char[][] chars){
        if(nowX+1 >= chars[0].length || nowY+1 >= chars.length) return;
        if(chars[nowY][nowX] == chars[nowY+1][nowX+1] &&
            chars[nowY][nowX] == chars[nowY][nowX+1] &&
            chars[nowY][nowX] == chars[nowY+1][nowX]){

            set.add(nowY+" "+nowX);
            set.add(nowY+" "+(nowX+1));
            set.add((nowY+1)+" "+nowX);
            set.add((nowY+1)+" "+(nowX+1));
        }

    }
}
