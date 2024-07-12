class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {50,50,0,0};

        for(int y = 0; y < wallpaper.length; y++){
            for(int x = 0; x < wallpaper[y].length(); x++){
                if(wallpaper[y].charAt(x) == '#'){

                    answer[0] = Math.min(y,answer[0]);
                    answer[1] = Math.min(x,answer[1]);
                    answer[2] = Math.max(y+1,answer[2]);
                    answer[3] = Math.max(x+1,answer[3]);
                }
            }
        }
        return answer;
    }
}
