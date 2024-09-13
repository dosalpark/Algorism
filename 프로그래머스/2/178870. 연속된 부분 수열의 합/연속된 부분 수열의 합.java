import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sum = sequence[0];

        while (true) {
            if (sum == k) {
                list.add(left + ":" + right + ":" + (right - left));
            }

            if (left == sequence.length && right == sequence.length) {
                break;
            }

            if (sum <= k && right < sequence.length) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else {
                if (left < sequence.length) {
                    sum -= sequence[left];
                }
                left++;
            }

        }
        
        list.sort((o1, o2) -> {
            return Integer.parseInt(o1.split(":")[2]
            ) - Integer.parseInt(o2.split(":")[2]);
        });
        String first = list.get(0);
        answer[0] = Integer.parseInt(first.split(":")[0]);
        answer[1] = Integer.parseInt(first.split(":")[1]);
        return answer;
    }
}
