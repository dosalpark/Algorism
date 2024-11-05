import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1]- o2[1];
        });
        int min = routes[0][1];

        for(int i = 1; i < routes.length; i++){
            int S = routes[i][0];
            int E = routes[i][1];
            if(S <= min && min <= E){
                continue;
            }
            answer++;
            min = E;
        }
        return answer;
    }
}
