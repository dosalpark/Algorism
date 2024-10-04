class Solution {

    public int solution(int storey) {
        int answer = 0;
        int m = 10;

        while (storey != 0) {
            answer++;
            while (storey % m == 0) {
                storey /= 10;
            }

            if (storey % m < 5) {
                storey -= m / 10;
            } else if (storey % m > 5) {
                storey += m / 10;
            } else {
                if(storey % 100 >= 50){
                    storey += m / 10;
                } else {
                    storey -= m / 10;
                }
            }

        }
        return answer;
    }
}
