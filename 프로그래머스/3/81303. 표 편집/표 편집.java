import java.util.Stack;

class Solution {

    public String solution(int n, int k, String[] cmd) {
        Stack<int[]> remove = new Stack<>();
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].equals("Z")) {
                int[] cur = remove.pop();
                if (cur[1] != -1) {
                    next[cur[1]] = cur[0];
                }
                if (cur[2] != -1) {
                    prev[cur[2]] = cur[0];
                }
            } else if (cmd[i].equals("C")) {
                remove.add(new int[]{k, prev[k], next[k]});
                if (prev[k] != -1) {
                    next[prev[k]] = next[k];
                }
                if (next[k] != -1) {
                    prev[next[k]] = prev[k];
                }
                k = next[k] == -1 ? prev[k] : next[k];
            } else {
                String direction = cmd[i].split(" ")[0];
                int move = Integer.parseInt(cmd[i].split(" ")[1]);
                while (move-- > 0) {
                    if (direction.equals("U")) {
                        k = prev[k];
                    } else {
                        k = next[k];
                    }
                }

            }
        }
        StringBuilder answer = new StringBuilder("O".repeat(n));
        while (!remove.isEmpty()) {
            int[] cur = remove.pop();
            answer.setCharAt(cur[0], 'X');
        }
        return answer.toString();
    }
}
