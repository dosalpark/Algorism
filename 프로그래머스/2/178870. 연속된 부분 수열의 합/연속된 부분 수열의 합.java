import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int length = sequence.length;
        int left = 0, right = 0, sum = sequence[0];
        List<String> list = new ArrayList<>();

        while (true) {
            if (length == left && length == right) {
                break;
            }
            if (k == sum) {
                int minus = right - left;
                list.add(minus + " " + left + " " + right);
            }
            if (sum <= k && right < length) {
                right++;
                if (right < length) {
                    sum += sequence[right];
                }
            } else {
                if (left < length) {
                    sum -= sequence[left];
                }
                left++;
            }
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.split(" ")[0] == o2.split(" ")[0]){
                    return Integer.parseInt(o1.split(" ")[1]) - Integer.parseInt((o2.split(" ")[1]));
                }
                return Integer.parseInt(o1.split(" ")[0]) - Integer.parseInt(o2.split(" ")[0]);
            }
        });
        String ans = list.get(0);
        answer[0] = Integer.parseInt(ans.split(" ")[1]);
        answer[1] = Integer.parseInt(ans.split(" ")[2]);

        return answer;
    }
}
