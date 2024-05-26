class Solution {

    public int solution(int n) {
        int oneCount = counter(n);

        int next = n + 1;
        while (true) {
            if (oneCount == counter(next)) {
                return next;
            }
            next++;
        }
    }

    public int counter(int n) {
        String nstr = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < nstr.length(); i++) {
            if (nstr.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
