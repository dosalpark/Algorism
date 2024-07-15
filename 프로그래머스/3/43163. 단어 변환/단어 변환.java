import java.util.*;
class Solution {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int check = 0;
        int[] visit = new int[words.length];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < words.length; i++) {
            if (flag(i, words, begin)) {
                que.add(i);
                visit[i] = 1;
            }
        }


        while (!que.isEmpty()) {
            int wordIdx = que.poll();
            String word = words[wordIdx];

            if (word.equals(target)) {
                return visit[wordIdx];
            }

            for (int i = 0; i < words.length; i++) {
                if (visit[i] == 0 && flag(i,words,word)) {
                    que.add(i);
                    visit[i] = visit[wordIdx] + 1;
                }

            }
        }

        return answer;
    }

    private boolean flag(int i, String[] words, String begin) {
        int count = 0;
        for (int j = 0; j < words[i].length(); j++) {
            if (begin.charAt(j) != words[i].charAt(j)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

}
