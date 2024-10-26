class Solution {
    public int[] solution(int n, int s) {
        if(n > s){
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int turn = 0;
        while (n > 0){
            int a = s/n;
            answer[turn] = a;
            s = s - a;
            turn++;
            n--;
        }

        return answer;
    }
}
