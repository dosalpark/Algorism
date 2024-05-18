import java.util.*;
class Solution {

    public int bfs(String begin, String target, String[] words) {
        Queue<String[]> que = new LinkedList<>();
        int length = begin.length();
        que.add(new String[]{begin,""});

        while(!que.isEmpty()){
            String[] cur = que.poll();

            if(cur[0].equals(target)){
                return cur[1].length();
            }


            for(int i = 0; i < words.length; i++){
                if(words[i].equals("ffffff")){
                    continue;
                }
                int stack = 0;
                for(int j = 0; j < length; j++){
                    if(cur[0].charAt(j) != words[i].charAt(j)){
                        stack++;
                    }
                }
                if(stack == 1){
                    que.add(new String[]{words[i],cur[1] + "0"});
                    words[i] = "ffffff";
                }
            }
        }


        return 0;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        return answer;
    }
}
