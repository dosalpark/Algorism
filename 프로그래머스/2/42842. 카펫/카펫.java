class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer;
        int sum = brown + yellow;
        int x = 3;
        while(true){
            int y = sum / x;
            if(sum == y * x && brown == (x+y)*2 -4){
                answer = new int[]{y, x};
                break;
            }
            x++;
            
        }
        return answer;
    }
}
// xxxxxxxx
// xoooooox
// xoooooox
// xoooooox
// xoooooox
// xxxxxxxx
//8 + 6 14*2 28-4 = 24
//4 + 3 7*2 14-4 = 24
//

// xxxxxxxxxxxxxxxx
// xoooooooooooooox
// xxxxxxxxxxxxxxxx
